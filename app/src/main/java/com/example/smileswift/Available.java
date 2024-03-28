package com.example.smileswift;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Available extends Activity {

        private TextView availableTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_available);

            availableTextView = findViewById(R.id.availableTextView);

            // Retrieve selected date from intent
            long selectedDateMillis = getIntent().getLongExtra("selectedDateMillis", 0);

            // Use selected date to fetch available appointments (You need to implement this logic)
            // For demonstration purposes, let's assume we have a method getAvailableAppointments() returning a string
            String availableAppointments = getAvailableAppointments(selectedDateMillis);

            // Display available appointments
            availableTextView.setText(availableAppointments);
        }

        // This method should be implemented to fetch available appointments from your data source
        private String getAvailableAppointments(long selectedDateMillis) {
            // Implement your logic to fetch available appointments for the selected date
            // For demonstration purposes, return a placeholder string
            return "Available Appointment 1\nAvailable Appointment 2\nAvailable Appointment 3";
        }
    }

