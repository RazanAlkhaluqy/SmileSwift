package com.example.smileswift;
public class Patient {
    private int id;
    private String name;
    private String password;
    private String number;

    // Constructor
    public Patient(int id, String name, String password, String number) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.number = number;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

