package com.example.Todo.repository;

import com.example.Todo.entity.TodoEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoEntry, ObjectId> {
}
