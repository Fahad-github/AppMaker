package com.fyp.appmaker.Models;

public class TemplateListModel {
    Integer image;
    String name;

    public TemplateListModel(Integer image, String name) {
        this.image = image;
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}


