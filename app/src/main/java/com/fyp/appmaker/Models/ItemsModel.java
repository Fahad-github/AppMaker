package com.fyp.appmaker.Models;

public class ItemsModel {
    String itemImage;
    String itemTitle;
    String itemKey;
    public ItemsModel(String itemImage, String itemTitle) {
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
    }

    public ItemsModel(String itemImage, String itemTitle, String itemKey){
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
        this.itemKey = itemKey;
    }

    public String getItemImage() {
        return itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }
}
