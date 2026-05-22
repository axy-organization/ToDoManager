package com.example.todo.model;

public class TodoItem {
    private final int id;
    private final String description;
    private boolean completed;

    public TodoItem(int id, String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }

        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "[X]" : "[ ]";
        return id + ". " + status + " " + description;
    }
}