package com.example.smileswift;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

//import de.hdodenhof.circleimageview.CircleImageView;

public class ReSchedule extends AppCompatActivity {

    DrawerLayout drawerLayout;
    TextView nav_name;

    ArrayList<String> slotTimes = new ArrayList<>();
    ArrayList<String> docTimings = new ArrayList<>();
    ArrayList<String> docReserved = new ArrayList<>();

    HashMap<String, ArrayList<String>> itemList = new HashMap<>();
//    BookAppointmentAdapter adapter;

    RecyclerView slotCards;
//    CircleImageView img;
    TextView name, time, price;
    Button btn;
    EditText remarks;

    String dr_name, slot, dr_price;

    DBsmileswift db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reschedule);

        drawerLayout = findViewById(R.id.drawer_layout);
        nav_name = findViewById(R.id.nav_name);
        nav_name.setText(PatientDashboard.UserName);

        db = new DBsmileswift(this);

        dr_name = getIntent().getExtras().getString("dr_name");
        slot = getIntent().getExtras().getString("slot");

        btn = findViewById(R.id.re_btn);

//        img = findViewById(R.id.re_dr_image);
        name = findViewById(R.id.re_dr_name);
        remarks = findViewById(R.id.re_remarks);
        time = findViewById(R.id.re_dr_time);
        price = findViewById(R.id.re_dr_price);
        slotCards = findViewById(R.id.reschedule_slots);

        name.setText(dr_name);

        // Load doctor's image using Glide or any other method

        time.setText(getIntent().getExtras().getString("dr_time"));
        price.setText(getIntent().getExtras().getString("dr_price"));

        // Load doctor's image using Glide or any other method

        slotTimes = getIntent().getStringArrayListExtra("slotTimes");
        docTimings = getIntent().getStringArrayListExtra("docTimings");
        docReserved = getIntent().getStringArrayListExtra("docReserved");

        slotCards(slotTimes);
//
//        btn.setOnClickListener(v -> {
//            String selectedSlot = adapter.getSelected();
//            if (selectedSlot != null) {
//                // Update the database with the new appointment details
//                boolean isUpdated = db.updateAppointment(dr_name, slot, selectedSlot, remarks.getText().toString(), dr_price);
//                if (isUpdated) {
//                    Toast.makeText(this, "Appointment Rescheduled Successfully", Toast.LENGTH_SHORT).show();
//                    finish();
//                } else {
//                    Toast.makeText(this, "Failed to reschedule appointment", Toast.LENGTH_SHORT).show();
//                }
//            } else {
//                Toast.makeText(this, "Please select a Slot", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void slotCards(ArrayList<String> slotTimes) {
//        slotCards.setHasFixedSize(true);
//        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) slotCards.getLayoutParams();
//        layoutParams.width = 334; // Adjust width as needed
//        layoutParams.height = 314; // Adjust height as needed
//        slotCards.setLayoutParams(layoutParams);
//
//        ArrayList<String> sectionList = new ArrayList<>();
//        sectionList.add("Today's Slots");
//        itemList.put(sectionList.get(0), slotTimes);
//        adapter = new BookAppointmentAdapter(this, sectionList, itemList, docTimings, docReserved, dr_name);
//        GridLayoutManager manager = new GridLayoutManager(this, 3);
//        slotCards.setLayoutManager(manager);
//        adapter.setLayoutManager(manager);
//        slotCards.setAdapter(adapter);
//    }

    // ---------------------------- NAVIGATION BAR ---------------------------- //
    public void ClickMenu(View view) {
        PatientDashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        PatientDashboard.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        PatientDashboard.redirectActivity(this, PatientDashboard.class);
    }

    public void ClickUpdateProfile(View view) {
        PatientDashboard.redirectActivity(this, UpdateProfilePatient.class);
    }

    public void ClickLogout(View view) {
        PatientDashboard.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PatientDashboard.closeDrawer(drawerLayout);
    }
    // ----------------------------------------------------------------------- //
}
