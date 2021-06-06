package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Lesson;
import com.example.database.nativeDb.DataBaseNativeUsersListActivity;
import com.example.database.roomDb.DataBaseRoomActivity;
import com.example.dialog.R;

import java.util.ArrayList;
import java.util.List;

public class DataBaseListActivity extends AppCompatActivity {

    private final List<Lesson> dbLessons = new ArrayList<>();

    {
        dbLessons.add(new Lesson("Natywna", DataBaseNativeUsersListActivity.class));
        dbLessons.add(new Lesson("Room", DataBaseRoomActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_lessons);
        ListView listView = findViewById(R.id.dbLessonsList);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dbLessons));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), dbLessons.get(position).getActivity());
            startActivity(intent);
        });
    }
}
