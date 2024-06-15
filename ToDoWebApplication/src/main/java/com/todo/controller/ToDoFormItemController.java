package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.model.ToDoItem;
import com.todo.service.ToDoItemService;

import jakarta.validation.Valid;

@Controller
public class ToDoFormItemController {

	 @Autowired
	    private ToDoItemService toDoItemService;

	    @GetMapping("/create-todo")
	    public String showCreateForm(ToDoItem todoItem) {
	        return "new-todo-item";
	    }

	    @PostMapping("/todo")
	    public String createTodoItem(@Valid ToDoItem todoItem, BindingResult result, Model model) {

	        ToDoItem item = new ToDoItem();
	        item.setDescription(todoItem.getDescription());
	        item.setIsComplete(todoItem.getIsComplete());

	        toDoItemService.save(todoItem);
	        return "redirect:/";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
	        ToDoItem todoItem = toDoItemService
	                .getById(id)
	                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

	        toDoItemService.delete(todoItem);
	        return "redirect:/";
	    }

	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
	        ToDoItem todoItem = toDoItemService
	                .getById(id)
	                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

	        model.addAttribute("todo", todoItem);
	        return "edit-todo-item";
	    }

	    @PostMapping("/todo/{id}")
	    public String updateTodoItem(@PathVariable("id") Long id, @Valid ToDoItem todoItem, BindingResult result, Model model) {

	        ToDoItem item = toDoItemService
	                .getById(id)
	                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

	        item.setIsComplete(todoItem.getIsComplete());
	        item.setDescription(todoItem.getDescription());

	        toDoItemService.save(item);

	        return "redirect:/";
	    }
}
