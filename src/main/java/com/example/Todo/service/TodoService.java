package com.example.Todo.service;

import com.example.Todo.entity.TodoEntry;
import com.example.Todo.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntry> getAllTodos(){
       return todoRepository.findAll();
    }

    public Optional<TodoEntry> getTodoById(ObjectId id){
       return todoRepository.findById(id);
    }

    public void addTodo(TodoEntry todoEntry){
        todoRepository.save(todoEntry);
    }

    public void deleteTodo(ObjectId id){
        todoRepository.deleteById(id);
    }
}
