package com.example.todo.storage;

import com.example.todo.model.TodoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTodoRepository implements TodoRepository {
    private final List<TodoItem> items = new ArrayList<>();
    private int nextId = 1;

    @Override
    public TodoItem save(String description) {
        TodoItem item = new TodoItem(nextId, description);
        nextId++;
        items.add(item);
        return item;
    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public Optional<TodoItem> findById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    @Override
    public boolean deleteById(int id) {
        return items.removeIf(item -> item.getId() == id);
    }
}
