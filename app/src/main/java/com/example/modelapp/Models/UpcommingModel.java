package com.example.modelapp.Models;

public class UpcommingModel {
    String name;
    String mode;
    String date;
    String urlImg;

    public UpcommingModel() {
    }

    public UpcommingModel(String name, String mode, String date, String urlImg) {
        this.name = name;
        this.mode = mode;
        this.date = date;
        this.urlImg = urlImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg_url() {
        return urlImg;
    }

    public void setImg_url(String img_url) {
        this.urlImg = img_url;
    }
}
