# ToDo List App - Android Tutorial
This is a step by step tutorial guiding you to build a simple Android app.

------------------------
## Install Android Studio

- identify your platform: `windows/mac/linux`
- follow the steps provided [here](https://developer.android.com/studio/install.html)

------------------------
## Requirements Understanding
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
- u13) (optional) add your profile icon to the application

U1, U2 to U* are user stories.

A **user story** represents a short, simple description of a feature told from the perspective of the person who desires the new capability, usually a user or customer of the system.
They typically follow a simple template: As a < type of user >, I want < some goal > so that < some reason >.

(Optional) More details about user-stories can be read [here](https://www.mountaingoatsoftware.com/agile/user-stories).

------------------------
## App Development

Please follow the steps in the following links.

Focus on the main user stories. Leave the optional ones for later work.

---------------------------------------------------
### Project creation

[project creation](http://bit.ly/android-todoapp-phase1)

#### Project Structure

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

---------------------------------------------------
### TodoTask Definition

[slides](http://bit.ly/android-todoapp-phase2)

The entire code can be seen on github at this [link](https://github.com/ciprian12/android-todolist-app/blob/master/app/src/main/java/com/ueo/study/ueotodolist)


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

The entire code can be seen on github at this [link](https://github.com/ciprian12/android-todolist-app/blob/master/app/src/main/java/com/ueo/study/ueotodolist/CategoriesModel.java)

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

---------------------------------------------------
### UI components: Menus and Tasks

### Modify how the menus look

Go to `res -> menu -> activity_home_drawer.xml `.
The .xml files define the layout, how the items will look on the screen.
Switch between `Design/Text` and text to see the order of the items and how things will look.

Change the names of the menu items.

    <item
        android:id="@+id/nav_personal"
        android:icon="@drawable/ic_menu_camera"
        android:title="Personal" />
    <item

Add new menu item by copying one of the items.
Paste it before the </group> tag.

Update the `android:id` values for each item.
The id provides a unique identification mechanism for each element.

### Modify the action for each menu

Go to `app -> java -> com.ueo.study.ueotodolist (your package name) -> HomeActivity`
Navigate method `onNavigationItemSelected`.
Update the `R.id.nav_camera` with the new ids from the previous step.
`R.id.*` is a global way to access a graphical element.

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_personal) {
            // Handle the personal category
        } else if (id == R.id.nav_school) {
        ...


### Task Design

Now we get to the part where add the code that will define how our tasks will look on the screen.

On `res -> layout` right click and add new layout resource file.
Name it `task_layout`.

Change the `layout_height` to `wrap_content`.

Now let's add some elements there.

Add the following:
- a `TextView` for the task title
- a `TextView` for the task description
- a `TextView` for the category
- a `CheckBox` button for the task done/not done status

Select an element and
set constraints to the top/down/left/right elements to fix them on the position.

--------------------------------------------------
### Activities - HomeActivity

#### Android Activity
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

#### Modify HomeActivity

Open the **HomeActivity** in your project.
It may be called **MainActivity** in your project.

Add a field for your `CategoriesModel`.

     private CategoriesModel categoriesModel = new CategoriesModel();
     private List<TaskModel> tasksList = new ArrayList<>();
     private TextView selectedCategoryText;

#### RecyclerView

We will create a list with `RecyclerView` component.

If your app needs to display a scrolling list of elements based on large data sets (or data that frequently changes), you should use `RecyclerView` as described on
 [more about recyclerview](https://developer.android.com/guide/topics/ui/layout/recyclerview.html).

A simple `RecyclerView` tutorial can be found [here](https://www.androidhive.info/2016/01/android-working-with-recycler-view/).

In `res/layout/content_home.xml` we add the following:

    <android.support.v7.widget.RecyclerView
       android:id="@+id/tasks_lst"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:layout_marginTop="16dp"
       android:scrollbars="vertical"
       app:layout_constraintEnd_toEndOf="parent"
       app:layout_constraintStart_toStartOf="parent"
       app:layout_constraintTop_toBottomOf="@+id/tasks_title" />

To feed all our data to the list, we must extend the RecyclerView.Adapter class. This object creates views for items, and replaces the content of some of the views with new data items when the original item is no longer visible.

Let's create a class `TaskRecyclerViewAdapter`.

#### Connect the tasks to their graphical elements  

In the `HomeActivity` we will connect the `TaskRecyclerViewAdapter` with our tasks.

Add these fields to your activity.

      private RecyclerView tasksRecyclerView;
      private RecyclerView.Adapter mAdapter;

Then in the method
`protected void onCreate(Bundle savedInstanceState)`
we will add the actual creation of our list.

    //tasks recycler view
    tasksRecyclerView = (RecyclerView) findViewById(R.id.tasks_recyclerview);

    // use a linear layout manager
    mLayoutManager = new LinearLayoutManager(this);
    tasksRecyclerView.setLayoutManager(mLayoutManager);

    // specify an adapter
     mAdapter = new TaskRecyclerViewAdapter(getInitialTasks(), this);
     tasksRecyclerView.setAdapter(mAdapter);

The `getInitialTasks()` is just a method to populate the UI with some sample tasks.

    private List<TaskModel> getInitialTasks(){
       List<TaskModel> sampleTasks = categoriesModel.sampleTasks();
       tasksList.addAll(sampleTasks);
       return tasksList;
    }

Now we can change what happens when we click the button on our menu.
Update the method `public boolean onNavigationItemSelected(MenuItem item)`.


    if (id == R.id.nav_personal) {
            // Handle the personal category
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasksForCategory(CategoriesModel.CATEGORY_PERSONAL);
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();


#### Add CheckBox behavior

We now want to add some behavior when we click the checkbox on a task.

Navigate to the class `TaskRecyclerViewAdapter` (code available [here](https://github.com/ciprian12/android-todolist-app/blob/master/app/src/main/java/com/ueo/study/ueotodolist/TaskRecyclerViewAdapter.java)).

Let's add a field `private List<TaskModel> tasksList;` which is initialized in the constructor.

There we see the inner-class `ViewHolder`. This class gets a reference to all the graphical elements of a task.

      public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

The recycler view will create a view for each task when we scroll through the list.
Once a task is out of the screen, the graphical elements will be destroyed.
That is why we have to initialize every time the graphical elements with actual values.

The classes `TaskModel`, `ViewHolder` and `TaskRecyclerViewAdapter` for a design pattern called **Model-View-Controller**.

The **Model** holds the data, i.e. our task details.
The **View** defines how we display the data, i.e. textbox, checkbox, date, calendar and so on.
The **Controller** the updates the view when the model has changed (e.g. a task is done) or updates the model when the user has invoked an action on the display (e.g. click the checkbox).

Another example for model-view-controller can be found [here](https://realpython.com/the-model-view-controller-mvc-paradigm-summarized-with-legos/).

Therefore we have to update the method ` public void onBindViewHolder(ViewHolder holder, int position)` in `TaskRecyclerViewAdapter`. We want to save the state when the checkbox has been clicked.

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    final TaskModel selectedTask = tasksList.get(position);

    // update the data from the model (task) to the view (ui elements)
    holder.taskName.setText(selectedTask.getName());
    holder.taskDescription.setText("" + selectedTask.getDescription());
    holder.taskCategory.setText("" + selectedTask.getCategory());

    //when item from the display has been touched, we update the information of the model.
    holder.taskState.setOnCheckedChangeListener(null); //reset the listener when the item is recreated when scrolling
    holder.taskState.setChecked(selectedTask.isDone()); //update the display with the status of the task
    holder.taskState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           if (isChecked) {
               //display a short message when we click the checkbox
               Toast.makeText(TaskRecyclerViewAdapter.this.context,
                       "task done:" + selectedTask.getName(),
                       Toast.LENGTH_LONG).show();
               //save the status of the task
               selectedTask.setDone(true);
           } else {
               selectedTask.setDone(false);
           }
       }
    });
    }


--------------------------------------------------
### Popup Window - add new tasks

to be added ...

--------------------------------------------------
### Delete Option - delete tasks

to be added ...

------------------------
## Evaluation

Each user story values 1 point.

Each user story can gain 0, 0.5 or 1 points.

The app graded with the maximum number of points is considered the winner.
