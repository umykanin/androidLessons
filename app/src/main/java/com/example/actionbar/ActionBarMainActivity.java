package com.example.actionbar;

import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dialog.R;

public class ActionBarMainActivity extends AppCompatActivity implements ActionMode.Callback {

    private boolean displayTitle = true;
    private boolean displayHomeButton = true;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_example_1:
                Toast.makeText(this, "Jeden", Toast.LENGTH_SHORT).show();
            case R.id.menu_example_2:
                Toast.makeText(this, "Dwa", Toast.LENGTH_SHORT).show();
            case R.id.menu_example_3:
                Toast.makeText(this, "Trzy", Toast.LENGTH_SHORT).show();
            case R.id.menu_example_4:
                Toast.makeText(this, "Cztery", Toast.LENGTH_SHORT).show();
            case R.id.menu_example_5:
                Toast.makeText(this, "Pięć", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void toggleActionBarVisibility(View view) {
        if(getSupportActionBar() != null) {
            if (getSupportActionBar().isShowing()) {
                getSupportActionBar().hide();
            } else {
                getSupportActionBar().show();
            }
        }
    }

    public void toggleTitleVisibility(View view) {
        displayTitle = !displayTitle;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(displayTitle);
        }
    }

    public void toggleHomeButtonVisibility(View view) {
        if (getSupportActionBar() != null) {
            displayHomeButton = !displayHomeButton;
            getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeButton);
        }
    }

    public void startActionMode(View view) {
        startActionMode(this);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_mode_example, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_item_1:
                Toast.makeText(this, "Akcja 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_action_item_2:
                Toast.makeText(this, "Akcja 2", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
