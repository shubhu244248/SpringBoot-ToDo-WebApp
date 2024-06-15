package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.todo.service.ToDoItemService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoItemService toDoItemService;
	
	@GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", toDoItemService.getAll());
        return modelAndView;
    }

}
