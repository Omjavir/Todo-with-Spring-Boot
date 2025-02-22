package com.example.Todo.controller;

import com.example.Todo.entity.TodoEntry;
import com.example.Todo.service.TodoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<?> getAllTodos(){
      List<TodoEntry> todos = todoService.getAllTodos();
      if(todos != null && !todos.isEmpty()){
        return new ResponseEntity<>(todos, HttpStatus.OK);
      }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public TodoEntry getTodoById(@PathVariable ObjectId id){
        return todoService.getTodoById(id).orElse(null);
    }

    @PostMapping("/add")
    public ResponseEntity<TodoEntry> addTodo(@RequestBody TodoEntry newTodo){
        todoService.addTodo(newTodo);
        return new ResponseEntity<TodoEntry>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public TodoEntry updateTodoById(@PathVariable ObjectId id, @RequestBody TodoEntry newTodo){

        TodoEntry oldTodo = todoService.getTodoById(id).orElse(null);

        if(oldTodo != null){
            oldTodo.setTitle(newTodo.getTitle() != null && !newTodo.getTitle().equals("") ? newTodo.getTitle() : oldTodo.getTitle());

            oldTodo.setDescription(newTodo.getDescription() != null && !newTodo.getDescription().equals("") ? newTodo.getDescription() : oldTodo.getDescription());
        }

        todoService.addTodo(oldTodo);
        return oldTodo;
    }

    @DeleteMapping("/id/{id}")
    public boolean deleteTodoById(@PathVariable ObjectId id){
        todoService.deleteTodo(id);
        return true;
    }
}
