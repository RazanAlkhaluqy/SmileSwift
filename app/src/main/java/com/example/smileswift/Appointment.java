package com.example.smileswift;
public class Appointment {
    private int id;
    private String date;
    private String state;
    private int doctorId;
    private int patientId;

    // Constructor
    public Appointment(int id, String date, String state, int doctorId, int patientId) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}

