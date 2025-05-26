package com.example.aplikasipasteltasky_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class TodoAdapter extends BaseAdapter {
    private Context context;
    private List<Task> taskList;

    public TodoAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.todo_item, parent, false);
        }

        Task task = taskList.get(position);

        CheckBox checkBox = convertView.findViewById(R.id.taskCheckbox);
        TextView textView = convertView.findViewById(R.id.taskText);
        ImageView priorityIcon = convertView.findViewById(R.id.priorityIcon);

        checkBox.setChecked(task.isCompleted);
        textView.setText(task.title);

        // Warna ikon prioritas (optional, pastikan warna tersedia di colors.xml)
        switch (task.priority) {
            case 1:
                priorityIcon.setColorFilter(context.getResources().getColor(R.color.pastel_maroon));
                break;
            case 2:
                priorityIcon.setColorFilter(context.getResources().getColor(R.color.pastel_green));
                break;
            case 3:
                priorityIcon.setColorFilter(context.getResources().getColor(R.color.pastel_blue));
                break;
        }

        return convertView;
    }
}
