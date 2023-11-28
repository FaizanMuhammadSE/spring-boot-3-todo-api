package com.simpleproject;

import java.util.Objects;

public class Todo {
    private Number id;
    private String task;

    public Todo(Number id,String task){
        this.id = id;
        this.task = task;
    }
    public Todo(){
    }
    public Number getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setId(Number id) {
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
