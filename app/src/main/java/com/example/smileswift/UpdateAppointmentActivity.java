package com.example.smileswift;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UpdateAppointmentActivity extends AppCompatActivity {

    // Declare UI elements
    TextView textView;
    RecyclerView recyclerView;
    TextView doctorNameTextView;
    TextView appointmentTimeTextView;
    Button updateButton;
    ImageView backButton;

    // Declare database helper
    DBsmileswift dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_appointment);

        // Initialize UI elements
        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.reschedule_slots);
        doctorNameTextView = findViewById(R.id.re_dr_name);
        appointmentTimeTextView = findViewById(R.id.re_dr_time);
        updateButton = findViewById(R.id.re_btn);
        backButton = findViewById(R.id.backicon);

        // Initialize database helper
        dbHelper = new DBsmileswift(this);

        // Set onClickListener for the update button
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle update appointment logic here
                // For example, you can retrieve selected appointment slot from the RecyclerView
                // and update the appointment record in the database
                Toast.makeText(UpdateAppointmentActivity.this, "Update button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set onClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click, for example, navigate back to previous activity
                //onBackPressed();
                finish();
            }
        });

//        public List<String> getAppointmentSlots() {
//            List<String> appointmentSlots = new ArrayList<>();
//            // Perform database query to fetch appointment slots
//            // For example:
//            SQLiteDatabase db = getReadableDatabase();
//            Cursor cursor = db.rawQuery("SELECT slot FROM Appointments", null);
//            if (cursor.moveToFirst()) {
//                do {
//                    String slot = cursor.getString(cursor.getColumnIndex("slot"));
//                    appointmentSlots.add(slot);
//                } while (cursor.moveToNext());
//            }
//            cursor.close();
//            return appointmentSlots;
//        }
//
//        public String getDoctorName() {
//            String doctorName = "";
//            // Perform database query to fetch doctor name
//            // For example:
//            SQLiteDatabase db = getReadableDatabase();
//            Cursor cursor = db.rawQuery("SELECT name FROM Doctor", null);
//            if (cursor.moveToFirst()) {
//                doctorName = cursor.getString(cursor.getColumnIndex("name"));
//            }
//            cursor.close();
//            return doctorName;
//        }
//
//        public String getAppointmentTime() {
//            String appointmentTime = "";
//            // Perform database query to fetch appointment time
//            // For example:
//            SQLiteDatabase db = getReadableDatabase();
//            Cursor cursor = db.rawQuery("SELECT time FROM Appointments", null);
//            if (cursor.moveToFirst()) {
//                appointmentTime = cursor.getString(cursor.getColumnIndex("time"));
//            }
//            cursor.close();
//            return appointmentTime;
//        }
//
//        AppointmentSlotAdapter adapter = new AppointmentSlotAdapter(appointmentSlots);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3)); // 3 columns
//        recyclerView.setAdapter(adapter);

    }
}
