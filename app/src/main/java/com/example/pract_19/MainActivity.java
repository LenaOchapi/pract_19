package com.example.pract_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Dialog;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class MainActivity extends AppCompatActivity {

    private Button btnShowDialog, btnShowDate, btnShowTime;
    private TextView TVDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);
        btnShowDate = findViewById(R.id.btnShowDate);
        btnShowTime = findViewById(R.id.btnShowTime);
        TVDate = findViewById(R.id.TVDate);

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        btnShowDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });

        btnShowTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Current Date and Time");
        builder.setMessage(getCurrentDateTime());
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

    private void showDate() {
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        TVDate.setText(currentDate);
    }

    private void showTime() {
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        TVDate.setText(currentTime);
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return sdf.format(new Date());
    }
}