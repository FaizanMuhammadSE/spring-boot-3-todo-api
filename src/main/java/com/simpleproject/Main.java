package com.simpleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/todo")
public class Main {
    private final TodoRepository todoRepository;

    public Main(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/all")
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/intro")
    public String intro() {
        return "I'm Todo API which will serve following GET/POST/DELETE/PUT";
    }

    record TodoRequest(String task) {}
    @PostMapping
    public void addTodo(@RequestBody TodoRequest request) {
        Todo todo = new Todo();
        todo.setTask(request.task());
        todoRepository.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable("id") Integer id) {
        todoRepository.deleteById(id);
    }

    @PutMapping("/update")
    public void updateTodo(@RequestBody Todo reqTodo) {
        TodoRequest newTodo = new TodoRequest(reqTodo.getTask());
        deleteTodo(reqTodo.getId());
        addTodo(newTodo);
    }
}
