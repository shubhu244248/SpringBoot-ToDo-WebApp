package com.todo.model;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "todo_items")
public class ToDoItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Description is required")
	private String description;
	private Boolean isComplete;
	private Instant createAt;
	private Instant updatedAt;

}
