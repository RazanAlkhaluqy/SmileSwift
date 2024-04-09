package com.example.smileswift;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
public class Add extends Activity {



        private CalendarView calendarView;
        private Button showAvailableButton;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

//            calendarView = findViewById(R.id.calendarView);
////            showAvailableButton = findViewById(R.id.showAvailableButton);
//
//            showAvailableButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Retrieve selected date from CalendarView
//                    long selectedDateMillis = calendarView.getDate();
//
//                    // Start AvailableActivity and pass the selected date
//                    Intent intent = new Intent(Add.this, Available.class);
//                    intent.putExtra("selectedDateMillis", selectedDateMillis);
//                    startActivity(intent);
//                }
//            });
        }
    }
