package com.example.dialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class DatePickerDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (view, year, month, dayOfMonth) -> {
            @SuppressLint("DefaultLocale") String formattedDate = String.format("%04d-%02d-%02d", year, month, dayOfMonth);
            Toast.makeText(getActivity(), "Wybrałeś: " + formattedDate, Toast.LENGTH_LONG).show();
        }, 2021, 5, 31);
        return datePickerDialog;
    }
}
