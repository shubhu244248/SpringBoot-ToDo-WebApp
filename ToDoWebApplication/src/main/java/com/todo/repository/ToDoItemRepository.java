package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.ToDoItem;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
