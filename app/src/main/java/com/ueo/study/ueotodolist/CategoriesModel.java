package com.ueo.study.ueotodolist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CategoriesModel {

    public static final String CATEGORY_WORK = "work";
    public static final String CATEGORY_FAMILY = "family";
    public static final String CATEGORY_SCHOOL = "school";
    public static final String CATEGORY_SPIRITUAL = "spiritual";
    public static final String CATEGORY_PERSONAL = "personal";

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

    /**
     * returns a list with some sample tasks
     * @return
     */
    public List<TaskModel> sampleTasks(){
        List<TaskModel> modelList = new ArrayList<TaskModel>();
        modelList.add(new TaskModel("family 1", "1323", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family 2", "2321", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family Reebok", "3221", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family Boss", "1323", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family Wrangler", "5651", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family Lee", "1898", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("personal 1", "1655", Calendar.getInstance().getTime(), CATEGORY_PERSONAL));
        modelList.add(new TaskModel("personal 2", "8881", Calendar.getInstance().getTime(), CATEGORY_PERSONAL));
        modelList.add(new TaskModel("spiritual 2 Hil", "167", Calendar.getInstance().getTime(), CATEGORY_SPIRITUAL));
        modelList.add(new TaskModel("spiritual 1", "177", Calendar.getInstance().getTime(), CATEGORY_SPIRITUAL));
        modelList.add(new TaskModel("school 3", "177", Calendar.getInstance().getTime(), CATEGORY_SCHOOL));
        modelList.add(new TaskModel("school 2", "177", Calendar.getInstance().getTime(), CATEGORY_SCHOOL));
        modelList.add(new TaskModel("school 1", "177", Calendar.getInstance().getTime(), CATEGORY_SCHOOL));
        modelList.add(new TaskModel("work 3", "177", Calendar.getInstance().getTime(), CATEGORY_WORK));
        modelList.add(new TaskModel("work 2", "177", Calendar.getInstance().getTime(), CATEGORY_WORK));
        modelList.add(new TaskModel("work 1", "177", Calendar.getInstance().getTime(), CATEGORY_WORK));
        return modelList;
    }

}
