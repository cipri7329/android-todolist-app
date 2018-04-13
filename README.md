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

The developer is free to improvize, improve, add or remove features.

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

Each task can have different properties such as:
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


------------------------
## Step 4) App Development

Please follow the steps in the following links.

Focus on the main user stories. Leave the optional ones for later work.

### Phase 1 - Project creation

[project creation](http://bit.ly/android-todoapp-phase1)

### Phase 2 -

create a list with [recyclerview](https://developer.android.com/guide/topics/ui/layout/recyclerview.html)

------------------------
## Step 5) Evaluation

Each user story values 1 point.

Each user story can gain 0, 0.5 or 1 points.

The app graded with the maximum number of points is considered the winner.
