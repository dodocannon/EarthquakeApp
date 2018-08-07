package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private long time;
    private String location;

    public Earthquake(double magnitude, long time, String location)
    {
        this.magnitude = magnitude;
        this.location = location;
        this.time = time;
    }

    public double getMagnitude() {
        return magnitude;
    }


    public long getTime() {
        return time;
    }


    public String getLocation() {
        return location;
    }



}
