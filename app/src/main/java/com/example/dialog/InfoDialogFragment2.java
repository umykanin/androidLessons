package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class InfoDialogFragment2 extends DialogFragment {

    private DialogInterface.OnClickListener onClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialog");
        builder.setMessage("Info o dialogu");
        builder.setPositiveButton("TAK", onClickListener);
        builder.setNegativeButton("NIE", onClickListener);
        builder.setNeutralButton("ANULUJ", onClickListener);
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onClickListener = (DialogInterface.OnClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "tekst błędu");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onClickListener = null;
    }
}
