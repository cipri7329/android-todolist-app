package com.ueo.study.ueotodolist;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CategoriesModel {

    public static final String CATEGORY_ALL = "all";
    public static final String CATEGORY_WORK = "work";
    public static final String CATEGORY_FAMILY = "family";
    public static final String CATEGORY_SCHOOL = "school";
    public static final String CATEGORY_SPIRITUAL = "spiritual";
    public static final String CATEGORY_PERSONAL = "personal";

    private List<TaskModel> tasks ;

    public CategoriesModel() {
        this.tasks = new ArrayList<>();
        this.tasks.addAll(sampleTasks());
    }

    public void addTask(TaskModel task) {
        tasks.add(task);
    }

    public String[] getCategories() {
        String[] categories = new String[]{
                CATEGORY_WORK,
                CATEGORY_FAMILY,
                CATEGORY_SCHOOL,
                CATEGORY_SPIRITUAL,
                CATEGORY_PERSONAL
        };
        return categories;
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
    private List<TaskModel> sampleTasks(){
        List<TaskModel> modelList = new ArrayList<TaskModel>();
        modelList.add(new TaskModel("family 1", "clean the dishes", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family 2", "clean the car", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family read", "read a book", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family activity", "walk the dog", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family shopping", "buy groceries", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("family visit", "visit grandparents", Calendar.getInstance().getTime(), CATEGORY_FAMILY));
        modelList.add(new TaskModel("personal 1", "play some football", Calendar.getInstance().getTime(), CATEGORY_PERSONAL));
        modelList.add(new TaskModel("personal 2", "read a book", Calendar.getInstance().getTime(), CATEGORY_PERSONAL));
        modelList.add(new TaskModel("spiritual 2", "pray", Calendar.getInstance().getTime(), CATEGORY_SPIRITUAL));
        modelList.add(new TaskModel("spiritual 1", "learn a new song", Calendar.getInstance().getTime(), CATEGORY_SPIRITUAL));
        modelList.add(new TaskModel("school 3", "do homework", Calendar.getInstance().getTime(), CATEGORY_SCHOOL));
        modelList.add(new TaskModel("school 2", "learn german", Calendar.getInstance().getTime(), CATEGORY_SCHOOL));
        modelList.add(new TaskModel("school 1", "learn android", Calendar.getInstance().getTime(), CATEGORY_SCHOOL));
        modelList.add(new TaskModel("work 3", "plan vacation", Calendar.getInstance().getTime(), CATEGORY_WORK));
        modelList.add(new TaskModel("work 2", "contact client A", Calendar.getInstance().getTime(), CATEGORY_WORK));
        modelList.add(new TaskModel("work 1", "ask for help", Calendar.getInstance().getTime(), CATEGORY_WORK));
        return modelList;
    }

}
