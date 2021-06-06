package com.example.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DialogMainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private TextView textViewSelected;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        textViewSelected = findViewById(R.id.text_selected);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                textViewSelected.setText("Zgodziłeś się");
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                textViewSelected.setText("Nie zgodziłeś się");
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                textViewSelected.setText("Anulowałeś");
        }
    }

    public void infoDialog(View view) {
        InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
        infoDialogFragment.show(getSupportFragmentManager(), null);
    }

    public void infoDialog2(View view) {
        InfoDialogFragment2 infoDialogFragment2 = new InfoDialogFragment2();
        infoDialogFragment2.show(getSupportFragmentManager(), null);

    }

    public void simpleDialog(View view) {
        SimpleDialogFragment simpleDialogFragment = new SimpleDialogFragment();
        simpleDialogFragment.show(getSupportFragmentManager(), null);
    }

    public void singleListElementWithCheckDialog(View view) {
        SingleListElementCheckedDialogFragment singleListElementCheckedDialogFragment = new SingleListElementCheckedDialogFragment();
        singleListElementCheckedDialogFragment.show(getSupportFragmentManager(), null);
    }

    public void singleListElementDialog(View view) {
        SingleListElementDialogFragment singleListElementDialogFragment = new SingleListElementDialogFragment();
        singleListElementDialogFragment.show(getSupportFragmentManager(), null);
    }


    public void timePickerDialog(View view) {
        TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
        timePickerDialogFragment.show(getSupportFragmentManager(), null);
    }

    public void datePickerDialog(View view) {
        DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
        datePickerDialogFragment.show(getSupportFragmentManager(), null);
    }

    public void customDialog(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        customDialogFragment.show(getSupportFragmentManager(), null);
    }
}
