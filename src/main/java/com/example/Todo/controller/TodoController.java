package com.example.Todo.controller;

import com.example.Todo.entity.TodoEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private Map<Long, TodoEntry> todoEntries = new HashMap<>();

    @GetMapping
    public List<TodoEntry> getAllTodos(){
        return new ArrayList<>(todoEntries.values());
    }

    @GetMapping("/id/{id}")
    public TodoEntry getTodoById(@PathVariable Long id){
        return todoEntries.get(id);
    }

    @PostMapping("/add")
    public boolean addTodo(@RequestBody TodoEntry newTodo){
        todoEntries.put(newTodo.getId(), newTodo);
        return true;
    }

    @PutMapping("/id/{id}")
    public TodoEntry updateTodoById(@PathVariable Long id, @RequestBody TodoEntry updatedTodo){
        return todoEntries.put(id, updatedTodo);
    }

    @DeleteMapping("/id/{id}")
    public TodoEntry deleteTodoById(@PathVariable Long id){
        return todoEntries.remove(id);
    }
}
