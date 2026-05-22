package com.example.todo.ui;

import com.example.todo.model.TodoItem;
import com.example.todo.service.TodoService;

import java.util.List;
import java.util.Scanner;

public class TodoCli {
    private final TodoService service;
    private final Scanner scanner = new Scanner(System.in);

    public TodoCli(TodoService service) {
        this.service = service;
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
            case "1" -> addTodo();
            case "2" -> listTodos();
            case "3" -> completeTodo();
            case "4" -> deleteTodo();
            case "0" -> running = false;
            default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye.");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== Todo App ===");
        System.out.println("1. Add todo");
        System.out.println("2. List todos");
        System.out.println("3. Complete todo");
        System.out.println("4. Delete todo");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    private void addTodo() {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        TodoItem item = service.addTodo(description);
        System.out.println("Added: " + item);
    }

    private void listTodos() {
        List<TodoItem> items = service.getAllTodos();

        if (items.isEmpty()) {
            System.out.println("No todos found.");
            return;
        }

        items.forEach(System.out::println);
    }

    private void completeTodo() {
        System.out.print("Enter todo id: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (service.markTodoCompleted(id)) {
            System.out.println("Todo completed.");
        } else {
            System.out.println("Todo not found.");
        }
    }

    private void deleteTodo() {
        System.out.print("Enter todo id: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (service.deleteTodo(id)) {
            System.out.println("Todo deleted.");
        } else {
            System.out.println("Todo not found.");
        }
    }
}
