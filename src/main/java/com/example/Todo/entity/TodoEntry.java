package com.example.Todo.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class TodoEntry {


    @Id
    private ObjectId id;
    private String title;
    private String description;
}