package com.example.aplikasipasteltasky_listview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AlertDialog;


public class MainActivity extends AppCompatActivity {
    private List<Task> taskList;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi views
        EditText taskInput = findViewById(R.id.taskInput);
        Button addButton = findViewById(R.id.addButton);
        ListView todoListView = findViewById(R.id.todoListView);

        // Inisialisasi task list
        taskList = new ArrayList<>();

        // Contoh task awal
        taskList.add(new Task(1, "Belajar Android Studio", false, 2, "Work"));
        taskList.add(new Task(2, "Beli skincare", false, 1, "Personal"));
        taskList.add(new Task(3, "Nonton Drakor", false, 3, "Personal"));

        // Setup adapter
        adapter = new TodoAdapter(this, taskList);
        todoListView.setAdapter(adapter);

        // Handle checkbox
        todoListView.setOnItemClickListener((parent, view, position, id) -> {
            Task task = taskList.get(position);
            task.isCompleted = !task.isCompleted;
            adapter.notifyDataSetChanged();
        });

        // Handle tombol tambah
        addButton.setOnClickListener(v -> {
            String newTaskTitle = taskInput.getText().toString().trim();
            if (!newTaskTitle.isEmpty()) {
                int newId = taskList.isEmpty() ? 1 : taskList.get(taskList.size() - 1).id + 1;
                taskList.add(new Task(newId, newTaskTitle, false, 2, "Personal"));
                adapter.notifyDataSetChanged();
                taskInput.setText("");
            }
        });

        // Long click untuk menghapus task
        todoListView.setOnItemLongClickListener((parent, view, position, id) -> {
            Task task = taskList.get(position);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Hapus Task")
                    .setMessage("Yakin mau hapus \"" + task.title + "\"?")
                    .setPositiveButton("Hapus", (dialog, which) -> {
                        taskList.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("Batal", null)
                    .show();

            return true;
        });

    }
}
