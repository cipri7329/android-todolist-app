package com.ueo.study.ueotodolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView tasksRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String id = "Home Tasks";

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView tasksTitle = (TextView) findViewById(R.id.tasks_title);
        tasksTitle.setText(id);

        //tasks recycler view
        tasksRecyclerView = (RecyclerView) findViewById(R.id.tasks_lst);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        tasksRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        tasksRecyclerView.setLayoutManager(mLayoutManager);

        DividerItemDecoration itemDecor = new DividerItemDecoration(tasksRecyclerView.getContext(), DividerItemDecoration.HORIZONTAL);
        tasksRecyclerView.addItemDecoration(itemDecor);

        // specify an adapter (see also next example)
        mAdapter = new TaskRecyclerViewAdapter(getInitialTasks(), this);
        tasksRecyclerView.setAdapter(mAdapter);
    }

    private List<TaskModel> getInitialTasks(){
        List<TaskModel> modelList = new ArrayList<TaskModel>();
        modelList.add(new TaskModel("Adidas", "1323", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nike", "2321", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Reebok", "3221", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Boss", "1323", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Wrangler", "5651", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Lee", "1898", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Levis", "1655", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Polo", "8881", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Tommy Hil", "167", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica1", "177", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica2", "177", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica3", "177", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica4", "177", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica5", "177", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica6", "177", Calendar.getInstance().getTime()));
        modelList.add(new TaskModel("Nautica7", "177", Calendar.getInstance().getTime()));

        return modelList;
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
            // Handle the camera action
        } else if (id == R.id.nav_school) {

        } else if (id == R.id.nav_family) {

        } else if (id == R.id.nav_spiritual) {

        } else if (id == R.id.nav_work) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
