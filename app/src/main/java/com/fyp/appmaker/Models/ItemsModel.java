package com.fyp.appmaker.Models;

public class ItemsModel {
    String itemImage;
    String itemTitle;

    public ItemsModel(String itemImage, String itemTitle) {
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
    }

    public String getItemImage() {
        return itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }
}
