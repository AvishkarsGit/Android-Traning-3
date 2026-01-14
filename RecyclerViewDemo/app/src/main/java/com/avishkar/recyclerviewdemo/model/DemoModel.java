package com.avishkar.recyclerviewdemo.model;

public class DemoModel {
    String title, description;

    public DemoModel() {
        //default constructor
    }

    public DemoModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
