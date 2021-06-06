package com.example.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class TimePickerDialogFragment extends DialogFragment {

    private final LocalDateTime ldt = LocalDateTime.now();

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                @SuppressLint("DefaultLocale") String formattedTime = String.format("%02d:%02d", hourOfDay, minute);
                Toast.makeText(getActivity(), "Wybrałeś godzinę: " + formattedTime, Toast.LENGTH_LONG).show();
            }
        }, ldt.getHour(), ldt.getMinute(), true);
        return timePickerDialog;
    }
}
