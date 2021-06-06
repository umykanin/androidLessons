package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dialog.R;

public class SharedPreferencesMainActivity extends AppCompatActivity {

    private static final String prefFirstRun = "pref_first_run";
    private static final String prefName = "pref_name";

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefereces);

        TextView textView = findViewById(R.id.textView_shared_pref);
        editText = findViewById(R.id.editText_shared_pref);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean firstRun = sharedPreferences.getBoolean(prefFirstRun, true);

        if (firstRun) {
            textView.setText("Jesteś tu pierwszy raz.");
        } else {
            String name = sharedPreferences.getString(prefName, "");
            textView.setText("Już tu byłeś " + name);
            editText.setText("");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(prefFirstRun, false);
        editor.putString(prefName, editText.getText().toString());
        editor.commit();
    }
}
