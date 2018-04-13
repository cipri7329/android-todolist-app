package com.ueo.study.ueotodolist;

import java.util.ArrayList;
import java.util.List;

public class CategoriesModel {

    private List<TaskModel> tasks ;

    public CategoriesModel() {
        this.tasks = new ArrayList<TaskModel>();
    }

    public void addTask(TaskModel task) {
        tasks.add(task);
    }

    public List<TaskModel> getTasksForCategory(String category) {
        //create empty list where will store the associated tasks
        List<TaskModel> filteredTasks = new ArrayList<TaskModel>();

        //iterate through all tasks
        for(TaskModel task : tasks){
            //select only the corresponding tasks for that category
            if(task.getCategory().equals(category))
                filteredTasks.add(task);
        }

        return filteredTasks;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

}
