package com.example.todo.storage;

import com.example.todo.model.TodoItem;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    TodoItem save(String description);

    List<TodoItem> findAll();

    Optional<TodoItem> findById(int id);

    boolean deleteById(int id);
}