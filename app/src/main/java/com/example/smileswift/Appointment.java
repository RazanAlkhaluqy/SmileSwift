package com.example.smileswift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Appointment extends AppCompatActivity {
    public static String Appointment_id;
    public static String Appointment_Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
}