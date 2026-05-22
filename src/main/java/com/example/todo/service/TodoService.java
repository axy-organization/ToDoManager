package com.example.todo.service;

import com.example.todo.model.TodoItem;
import com.example.todo.storage.TodoRepository;

import java.util.List;

public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoItem addTodo(String description) {
        return repository.save(description);
    }

    public List<TodoItem> getAllTodos() {
        return repository.findAll();
    }

    public boolean markTodoCompleted(int id) {
        return repository.findById(id)
                .map(item -> {
                    item.markCompleted();
                    return true;
                })
                .orElse(false);
    }

    public boolean deleteTodo(int id) {
        return repository.deleteById(id);
    }
}
