package com.example.smileswift;import android.app.TimePickerDialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Addclass extends AppCompatActivity {

    private CalendarView calendarView;
    private Button addButton;
    private long selectedDateInMillis;
    private int selectedHourOfDay;
    private int selectedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_add);

        calendarView = findViewById(R.id.calendarView);
        addButton = findViewById(R.id.addButton);

        // Get the current date
        Calendar calendar = Calendar.getInstance();
        selectedDateInMillis = calendar.getTimeInMillis();

        // Create a gradient drawable for the button background
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                new int[]{getResources().getColor(R.color.startColor), getResources().getColor(R.color.endColor)}
        );
        gradientDrawable.setCornerRadius(8); // Adjust corner radius as needed

        // Set the gradient drawable as the background of the button
        addButton.setBackground(gradientDrawable);

        // CalendarView listener to get the selected date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Calendar selectedCalendar = Calendar.getInstance();
                selectedCalendar.set(year, month, dayOfMonth);
                selectedDateInMillis = selectedCalendar.getTimeInMillis();
            }
        });

        // Button click listener to show TimePicker dialog
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    private void showTimePickerDialog() {
        final Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedHourOfDay = hourOfDay;
                        selectedMinute = minute;

                        // Handle adding appointment logic here
                        Calendar selectedDateTime = Calendar.getInstance();
                        selectedDateTime.setTimeInMillis(selectedDateInMillis);
                        selectedDateTime.set(Calendar.HOUR_OF_DAY, selectedHourOfDay);
                        selectedDateTime.set(Calendar.MINUTE, selectedMinute);

                        // You can use selectedDateTime.getTimeInMillis() to add the appointment to the database
                        // Example: Insert into database with selectedDateTime.getTimeInMillis()
                        Toast.makeText(Addclass.this, "Appointment added for " + selectedDateTime.getTime(), Toast.LENGTH_SHORT).show();
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }
}
