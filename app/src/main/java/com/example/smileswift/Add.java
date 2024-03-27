package com.example.smileswift;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Add extends AppCompatActivity {



        private TextView textView;
        private Button button;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            textView = findViewById(R.id.text);
            button = findViewById(R.id.button);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    openDatePicker(); // Open date picker dialog

                    openTimePicker(); //Open time picker dialog
                }
            });





        }

        private void openDatePicker(){
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.DialogTheme , new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                    //Showing the picked value in the textView
                    textView.setText(String.valueOf(year)+ "."+String.valueOf(month)+ "."+String.valueOf(day));

                }
            }, 2023, 01, 20);

            datePickerDialog.show();
        }


        private void openTimePicker(){

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {


                    //Showing the picked value in the textView
                    textView.setText(String.valueOf(hour)+ ":"+String.valueOf(minute));

                }
            }, 15, 30, false);

            timePickerDialog.show();
        }


}