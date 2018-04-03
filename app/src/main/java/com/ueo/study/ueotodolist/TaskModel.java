package com.ueo.study.ueotodolist;

import java.util.Date;

public class TaskModel {

    private String name;
    private String description;
    private Date deadline;
    private boolean done;
    private boolean isSelected;

    public TaskModel(String name, String description, Date deadline) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.done = false;
        this.isSelected = false;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}
