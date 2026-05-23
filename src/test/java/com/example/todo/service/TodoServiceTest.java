package com.example.todo.service;

import com.example.todo.model.TodoItem;
import com.example.todo.storage.InMemoryTodoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    @Test
    void addTodo() {
        TodoService service = new TodoService(new InMemoryTodoRepository());

        TodoItem item = service.addTodo("Prepare webinar demo");

        assertEquals(1, item.getId());
        assertEquals("Prepare webinar demo", item.getDescription());
        assertFalse(item.isCompleted());
    }

    @Test
    void markTodoCompleted() {
        TodoService service = new TodoService(new InMemoryTodoRepository());

        TodoItem item = service.addTodo("Prepare webinar demo");
        boolean result = service.markTodoCompleted(item.getId());

        assertFalse(result);
        assertTrue(item.isCompleted());
    }
}