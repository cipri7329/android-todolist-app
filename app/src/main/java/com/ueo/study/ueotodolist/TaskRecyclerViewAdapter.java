package com.ueo.study.ueotodolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TaskRecyclerViewAdapter extends
        RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> {

    private List<TaskModel> tasksList;
    private Context context;

    public TaskRecyclerViewAdapter(List<TaskModel> tasksLst, Context ctx) {
        this.tasksList = tasksLst;
        this.context = ctx;
    }

    @Override
    public TaskRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /*
     * the recycler view will create a view for each task when we scroll through the list.
     * once a task is out of the screen, the graphical elements will be destroyed.
     * that is why we have to initialize every time the graphical elements with actual values.
     */
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

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    /**
     * this class gets a reference to all the graphical elements of a task.
     * this is called an inner-class because it is defined inside another class.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView taskName;
        public TextView taskDescription;
        public TextView taskCategory;
        public CheckBox taskState;

        public ViewHolder(View view) {
            super(view);
            taskName = (TextView) view.findViewById(R.id.task_title);
            taskDescription = (TextView) view.findViewById(R.id.task_description);
            taskCategory = (TextView) view.findViewById(R.id.task_category);
            taskState = (CheckBox) view.findViewById(R.id.task_status);

            //item click event listener
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            TextView taskTitle = (TextView) v.findViewById(R.id.task_title);
            //show more information about brand

        }
    }

}