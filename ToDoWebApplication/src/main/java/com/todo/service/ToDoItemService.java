package com.todo.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.ToDoItem;
import com.todo.repository.ToDoItemRepository;

@Service
public class ToDoItemService {

	@Autowired
	private ToDoItemRepository toDoItemRepository;

	public Iterable<ToDoItem> getAll() {

		return toDoItemRepository.findAll();
	}

	public Optional<ToDoItem> getById(Long id) {

		return toDoItemRepository.findById(id);
	}

	public ToDoItem save(ToDoItem toDoItem) {

		if (toDoItem.getId() == null) {
			toDoItem.setCreateAt(Instant.now());
		}

		toDoItem.setUpdatedAt(Instant.now());
		
		return toDoItemRepository.save(toDoItem);
	}

	public void delete(ToDoItem toDoItem) {
		
		toDoItemRepository.delete(toDoItem);
	}

}
