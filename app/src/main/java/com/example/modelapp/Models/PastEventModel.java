package com.example.modelapp.Models;

public class PastEventModel {
    String img_url;
    String name;

    PastEventModel() {

    }

    public PastEventModel(String img_url, String name) {
        this.img_url = img_url;
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
