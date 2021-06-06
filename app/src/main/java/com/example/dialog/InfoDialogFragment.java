package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class InfoDialogFragment extends DialogFragment {

    DialogInterface.OnClickListener onClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialog");
        builder.setMessage("Info o dialogu");
        builder.setPositiveButton("TAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Zgodziłeś się", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NIE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Nie zgodziłeś się", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("ANULUJ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(getActivity(), "Anulowałeś", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        return builder.create();
    }



    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            onClickListener = (DialogInterface.OnClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement DialogInterface.OnClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onClickListener = null;
    }
}
