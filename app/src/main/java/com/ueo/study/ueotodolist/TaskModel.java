package com.ueo.study.ueotodolist;

import java.util.Date;

/**
 * this models a TodoTask
 *
 * Each **task** can have different properties such as:
 * - title
 * - (optional) description
 * - category
 * - (optional) date deadline
 * - color
 */
public class TaskModel {

    private String name; //our title
    private String description;
    private Date deadline;
    private String category;
    private boolean done;

    public TaskModel(String name, String description, Date deadline, String category) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.done = false;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
