package com.example.myproject.character;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.fragment.app.DialogFragment;

import com.example.myproject.R;

import java.util.ArrayList;

public class Dialog extends DialogFragment {

    Activity activity;
    private AlertDialog dialog;

    public ArrayList<String> arrayList = new ArrayList<>();
    public int i;


    public Dialog(Activity activity) {
        this.activity = activity;
    }

    void startAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.attribute_dialog, null));
        builder.setCancelable(true);
        dialog = builder.create();
    }
}
