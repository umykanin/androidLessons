package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SingleListElementCheckedDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       final String[] colors = {"niebieski", "zielony", "różowy", "biały", "czerwony", "żółty"};
       final boolean[] checks = new boolean[colors.length];
        checks[0] = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Kolory");
        builder.setMultiChoiceItems(colors, checks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String selected = (isChecked) ? "Zaznaczono" : "Odznaczono";
                Toast.makeText(getActivity(), selected + " " + colors[which], Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("OK", null);
        builder.setNeutralButton("Anuluj", null);
        return builder.create();
    }
}
