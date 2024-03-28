package com.example.smileswift;
public class Doctor {
    private int id;
    private String name;
    private int yearsOfService;

    // Constructor
    public Doctor(int id, String name, int yearsOfService) {
        this.id = id;
        this.name = name;
        this.yearsOfService = yearsOfService;
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

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }
}

