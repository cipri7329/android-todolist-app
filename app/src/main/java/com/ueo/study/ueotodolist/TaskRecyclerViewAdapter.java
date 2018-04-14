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

    private List<TaskModel> filterList;
    private Context context;

    public TaskRecyclerViewAdapter(List<TaskModel> filterModelList, Context ctx) {
        filterList = filterModelList;
        context = ctx;
    }

    @Override
    public TaskRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout2, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TaskModel filterM = filterList.get(position);

        holder.taskName.setText(filterM.getName());
        holder.taskDescription.setText("" + filterM.getDescription());
        holder.taskCategory.setText("" + filterM.getCategory());
        if (filterM.isDone()) {
            holder.taskState.setChecked(true);
        } else {
            holder.taskState.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

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

            //checkbox click event handling
            taskState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(TaskRecyclerViewAdapter.this.context,
                                "task done:" + taskName.getText(),
                                Toast.LENGTH_LONG).show();
                    } else {

                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            TextView brndName = (TextView) v.findViewById(R.id.task_title);
            //show more information about brand
        }
    }
}