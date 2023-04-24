package com.example.task2eman_ziad;

import androidx.appcompat.app.AppCompatActivity;

public class hotel extends AppCompatActivity {
    private String name;
    private String rate;

    private double rate_bar;

    private int image_resource_id;

    public hotel(int image_resource_id, String name,String rate, double rate_bar) {
        this.name = name;
        this.image_resource_id = image_resource_id;

        this.rate=rate;
        this.rate_bar = rate_bar;
    }

    public String getName() {
        return name;
    }
    public int getImage_resource_id() {
        return image_resource_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }


    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getRate_bar() {
        return rate_bar;
    }

    public void setRate_bar(double rate_bar) {
        this.rate_bar = rate_bar;
    }
}
