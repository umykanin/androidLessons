package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment {

    private DialogInterface.OnClickListener onClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Zwykły dialog");
        builder.setMessage("Treść zwykłego dialogu");
        builder.setPositiveButton("Mogę", onClickListener);
        builder.setNegativeButton("Nie mogę", onClickListener);
        builder.setNeutralButton("Nie wiem", onClickListener);
        return builder.create();
    }
}
