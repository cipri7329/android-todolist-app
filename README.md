# ToDo List App - Android Tutorial
This is a step by step tutorial guiding you to build a simple Android app.

------------------------
## Step 1) Install Android Studio

- identify your platform: `windows/mac/linux`
- follow the steps provided [here](https://developer.android.com/studio/install.html)

------------------------
## Step 2) Requirements Understanding
The following points act as a description of the app and as a requirements guide.

Not all points are mandatory.

The developer is free to improvise, improve, add or remove features.

### Task Manager App
Requirements guideline

Build a Task Manager App / ToDo List App.

The app supports multiple task categories such as:
- work
- family
- school
- spiritual
- personal  
- and others.

Each category contains a list of tasks to be done.

Each **task** can have different properties such as:
- title
- (optional) description
- category
- (optional) date deadline
- color

Design and usability suggestions:
- u1) the categories can be selected from menu bar which contain all the categories
- u2) each category menu item leads to a view with items only from that category
- u3) each category view contains a list with todo-tasks
- u4) each todo-task has a check-box (done)
- u5) when a todo-task is clicked the user is asked to mark it as done
- u6) provide a button to "add task"
- u7) (optional) done tasks are moved to the bottom of the list
- u8) (optional) sort the tasks by earliest-deadline first
- u9) (optional) each category has an associated color
- u10) (optional) provide the option to add description to a task
- u11) (optional) provide option to change the category of a task
- u12) (optional) deploy app and run it on your personal phone

U1, U2 to U* are user stories.

A **user story** represents a short, simple description of a feature told from the perspective of the person who desires the new capability, usually a user or customer of the system.
They typically follow a simple template: As a < type of user >, I want < some goal > so that < some reason >.

(Optional) More details about user-stories can be read [here](https://www.mountaingoatsoftware.com/agile/user-stories).

------------------------
## Step 3) Basic Android Concepts

### Activities
An Android activity is a graphical user interface component.
It corresponds roughly to a window in a desktop application.
Since mobile phone screens are small, an activity typically takes up the whole screen.
If you open multiple activities they are stacked on top of each other.
You cannot arrange activities side by side, like you can do with desktop windows.

An Android activity is one screen of the Android app's user interface.
In that way an Android activity is very similar to windows in a desktop application.
An Android app may contain one or more activities, meaning one or more screens.
The Android app starts by showing the main activity, and from there the app may make it possible to open additional activities.

More details [here](http://tutorials.jenkov.com/android/core-concepts.html#activities)

### Project Structure

We will write code and modify information only in two directories:
- app/java
- app/res

In **app/java** folder we write java code that:
- models our tasks and categories
- stores information
- defines actions (add task), behavior (filter)

In **app/res** directory we have code that:
- defines how the elements on the screen will look like

For an in-depth understanding navigate to this [link](https://developer.android.com/studio/projects/index.html).


------------------------
## Step 4) App Development

Please follow the steps in the following links.

Focus on the main user stories. Leave the optional ones for later work.

### Phase 1 - Project creation

[project creation](http://bit.ly/android-todoapp-phase1)

### Phase 2 - Categories and Tasks

[slides for phase 2](http://bit.ly/android-todoapp-phase2)

The entire code for phase 2 can be seen on github at this [link](https://github.com/ciprian12/android-todolist-app/blob/add-categories/app/src/main/java/com/ueo/study/ueotodolist/TaskModel.java)

#### Task Definition

Let's define a class that stores the information for a task.
A class is a method to represent real-life objects or concepts.

Learn more about Java classes [here](https://www.tutorialspoint.com/java/java_object_classes.htm).

Our TodoTask can be modeled as a java class in the following way:


    //this represents our TodoTask
    public class TaskModel {

      //these are our attributes
      private String name; //our title
      private String description;
      private Date deadline;
      private String category;
      private boolean done;
      private boolean isSelected;

      //this is called a constructor - this enables us to create tasks
      public TaskModel(String name, String description, Date deadline, String category) {
          this.name = name;
          this.description = description;
          this.deadline = deadline;
          this.done = false;
          this.isSelected = false;
          this.category = category;
      }

      // this is a method to get the value of a property, e.g. name
      public String getName() {
          return name;
      }

      // this is a method to set the value of a property, e.g. name
      public void setName(String name) {
          this.name = name;
      }

      // add more methods to access the other properties ...
    }

#### Categories List

  Let's create another class called **CategoriesModel**.
  This class will store all the categories in our project and which tasks are associated to which category.

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

The entire code can be seen on github at this [link](https://github.com/ciprian12/android-todolist-app/blob/add-categories/app/src/main/java/com/ueo/study/ueotodolist/CategoriesModel.java)

Now we have a way to store and filter our tasks.

It's not a good practice to hardcode strings.
We can use strings to name categories.
But if we later have to change the term from "home" to "house" it will be annoying to change in multiple places.

That is why as a good practice we use constants to define our strings.
Add to your CategoriesModel the following constants.

    public static final String CATEGORY_WORK = "work";
    public static final String CATEGORY_FAMILY = "family";
    public static final String CATEGORY_SCHOOL = "school";
    public static final String CATEGORY_SPIRITUAL = "spiritual";
    public static final String CATEGORY_PERSONAL = "personal";




create a list with [recyclerview](https://developer.android.com/guide/topics/ui/layout/recyclerview.html)

------------------------
## Step 5) Evaluation

Each user story values 1 point.

Each user story can gain 0, 0.5 or 1 points.

The app graded with the maximum number of points is considered the winner.
