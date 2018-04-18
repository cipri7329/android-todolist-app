package com.ueo.study.ueotodolist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView tasksRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<TaskModel> tasksList = new ArrayList<>();

    private TextView selectedCategoryText;
    final private CategoriesModel categoriesModel = new CategoriesModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add new task", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                showTaskPopup();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        selectedCategoryText = (TextView) findViewById(R.id.category_tasks);
        selectedCategoryText.setText(CategoriesModel.CATEGORY_ALL);

        //tasks recycler view
        tasksRecyclerView = (RecyclerView) findViewById(R.id.tasks_recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        tasksRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        tasksRecyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration itemDecor = new DividerItemDecoration(tasksRecyclerView.getContext(), DividerItemDecoration.HORIZONTAL);
        tasksRecyclerView.addItemDecoration(itemDecor);

        // specify an adapter
        mAdapter = new TaskRecyclerViewAdapter(getInitialTasks(), this);
        tasksRecyclerView.setAdapter(mAdapter);
    }

    private List<TaskModel> getInitialTasks(){
        List<TaskModel> sampleTasks = categoriesModel.getTasks();
        tasksList.addAll(sampleTasks);
        return tasksList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_personal) {
            // Handle the personal category
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasksForCategory(CategoriesModel.CATEGORY_PERSONAL);
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();
            selectedCategoryText.setText(CategoriesModel.CATEGORY_PERSONAL);

        } else if (id == R.id.nav_school) {
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasksForCategory(CategoriesModel.CATEGORY_SCHOOL);
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();
            selectedCategoryText.setText(CategoriesModel.CATEGORY_SCHOOL);
        } else if (id == R.id.nav_family) {
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasksForCategory(CategoriesModel.CATEGORY_FAMILY);
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();
            selectedCategoryText.setText(CategoriesModel.CATEGORY_FAMILY);
        } else if (id == R.id.nav_spiritual) {
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasksForCategory(CategoriesModel.CATEGORY_SPIRITUAL);
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();
            selectedCategoryText.setText(CategoriesModel.CATEGORY_SPIRITUAL);
        } else if (id == R.id.nav_work) {
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasksForCategory(CategoriesModel.CATEGORY_WORK);
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();
            selectedCategoryText.setText(CategoriesModel.CATEGORY_WORK);
        }else if (id == R.id.nav_all) {
            tasksList.clear();
            List<TaskModel> filteredTasks = categoriesModel.getTasks();
            tasksList.addAll(filteredTasks);
            mAdapter.notifyDataSetChanged();
            selectedCategoryText.setText(CategoriesModel.CATEGORY_ALL);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showTaskPopup() {
        try {
            //We need to get the instance of the LayoutInflater, use the context of this activity
            LayoutInflater inflater = (LayoutInflater) HomeActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Inflate the view from a predefined XML layout (no need for root id, using entire layout)
            View layout = inflater.inflate(R.layout.task_popup,null);

            //Get the devices screen density to calculate correct pixel sizes
            float density=HomeActivity.this.getResources().getDisplayMetrics().density;
            // create a focusable PopupWindow with the given layout and correct size
            final PopupWindow pw = new PopupWindow(layout, ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
            pw.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
            
            final Spinner staticSpinner = (Spinner) layout.findViewById(R.id.category_spinner);
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categoriesModel.getCategories());
            // Specify the layout to use when the list of choices appears
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            staticSpinner.setAdapter(aa);

            final TextView taskTitle = (TextView) layout.findViewById(R.id.title_input);
            final TextView taskDescription = (TextView) layout.findViewById(R.id.description_input);

            //Button to close the pop-up
            ((Button) layout.findViewById(R.id.task_add)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //extract the filled in information
                    String name = taskTitle.getText().toString();
                    String description = taskDescription.getText().toString();
                    String category = staticSpinner.getSelectedItem().toString();

                    //create a new task
                    TaskModel newTask = new TaskModel(name, description, new Date(), category);
                    //add the task to our list
                    categoriesModel.addTask(newTask);

                    tasksList.clear();
                    List<TaskModel> filteredTasks = categoriesModel.getTasks();
                    tasksList.addAll(filteredTasks);

                    Snackbar.make(v, "task added: " + newTask.toString(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    //notify that the data has changed in the list
                    mAdapter.notifyDataSetChanged();
                    tasksRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
                    //close the window
                    pw.dismiss();

                }
            });

            // display the pop-up in the center
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
