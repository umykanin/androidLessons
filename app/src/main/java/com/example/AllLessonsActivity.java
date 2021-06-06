package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.actionbar.ActionBarMainActivity;
import com.example.database.DataBaseListActivity;
import com.example.dialog.DialogMainActivity;
import com.example.dialog.R;
import com.example.filesystem.FileSystemActivity;
import com.example.preferences.CurrentPreferencesActivity;
import com.example.sharedpreferences.SharedPreferencesMainActivity;

import java.util.ArrayList;
import java.util.List;

public class AllLessonsActivity extends AppCompatActivity {
    private final List<Lesson> lessons = new ArrayList<>();

    {
        lessons.add(new Lesson("Dialogs", DialogMainActivity.class));
        lessons.add(new Lesson("Action Bar", ActionBarMainActivity.class));
        lessons.add(new Lesson("Shared Preferences", SharedPreferencesMainActivity.class));
        lessons.add(new Lesson("Preferences", CurrentPreferencesActivity.class));
        lessons.add(new Lesson("File System", FileSystemActivity.class));
        lessons.add(new Lesson("Date Base", DataBaseListActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_lessons_list);

        ListView lessonsListView = findViewById(R.id.lessonsList);
        lessonsListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lessons));
        lessonsListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), lessons.get(position).getActivity());
            startActivity(intent);
        });
    }
}
