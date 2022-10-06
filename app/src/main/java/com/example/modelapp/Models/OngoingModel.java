package com.example.modelapp.Models;

public class OngoingModel {
    String name;
    String mode;
    String date;
    String img_url;

    public OngoingModel() {

    }

    public OngoingModel(String name, String mode, String date, String img_url) {
        this.name = name;
        this.mode = mode;
        this.date = date;
        this.img_url = img_url;
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
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
