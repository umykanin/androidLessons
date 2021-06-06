package com.example.preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import com.example.dialog.R;

import java.util.Set;

public class CurrentPreferencesActivity extends AppCompatActivity {

    private static final String PREF_LIGHT = "pref_light";
    private static final String PREF_WASH_MACHINE = "pref_wash_machine";
    private static final String PREF_NAME = "pref_name";
    private static final String PREF_ANIMALS = "pref_animals";
    private static final String PREF_ICE_CREAM = "pref_ice_cream";

    TextView light;
    TextView washMachine;
    TextView name;
    TextView animal;
    TextView iceCream;
    TextView ringtone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        light = findViewById(R.id.light);
        washMachine = findViewById(R.id.wash_machine);
        name = findViewById(R.id.name);
        animal = findViewById(R.id.animal);
        iceCream = findViewById(R.id.ice_cream);
        ringtone = findViewById(R.id.ringtone);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        boolean lightEnabled = sp.getBoolean(PREF_LIGHT, false);
        boolean washMachineOn = sp.getBoolean(PREF_WASH_MACHINE, false);
        String nameString = sp.getString(PREF_NAME, "");
        String animalString = sp.getString(PREF_ANIMALS, "");
        Set<String> iceCreams = sp.getStringSet(PREF_ICE_CREAM, null);

        String lightValue = lightEnabled ? "włączone" : "wyłączone";
        String washMachineValue = washMachineOn ? "włączona" : "wyłączona";

        light.setText(lightValue);
        washMachine.setText(washMachineValue);
        name.setText(nameString);
        animal.setText(animalString);
        iceCream.setText(iceCreams.toString());
    }

    public void changeSettings(View view) {
        Intent intent = new Intent(getApplicationContext(), PreferencesActivity.class);
        startActivity(intent);
    }

    public void chooseCities(View view) {
        Intent intent = new Intent(getApplicationContext(), CitiesActivity.class);
        startActivity(intent);

    }
}
