package com.simpleproject;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Objects;

@Entity
public class Todo {
    @Id
    @SequenceGenerator(
            name = "todo_id_sequence",
            sequenceName = "todo_id_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_id_sequence"
    )
    private Integer id;
    private String task;

    public Todo(Integer id, String task){
        this.id = id;
        this.task = task;
    }
    public Todo(){
    }
    public Integer getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task);
    }
}
