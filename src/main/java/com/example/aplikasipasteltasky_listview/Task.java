package com.example.aplikasipasteltasky_listview;

public class Task {
    public int id;
    public String title;
    public boolean isCompleted;
    public int priority;
    public String category;

    public Task(int id, String title, boolean isCompleted, int priority, String category) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
        this.priority = priority;
        this.category = category;
    }
}
