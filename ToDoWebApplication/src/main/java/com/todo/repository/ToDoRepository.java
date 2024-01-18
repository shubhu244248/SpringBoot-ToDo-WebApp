package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.ToDoItem;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {

}
