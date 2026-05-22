package com.example.todo;

import com.example.todo.service.TodoService;
import com.example.todo.storage.InMemoryTodoRepository;
import com.example.todo.ui.TodoCli;

public class Main {
    public static void main(String[] args) {
        InMemoryTodoRepository repository = new InMemoryTodoRepository();
        TodoService service = new TodoService(repository);
        TodoCli cli = new TodoCli(service);

        cli.start();
    }
}
