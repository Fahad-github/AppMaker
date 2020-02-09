package com.fyp.appmaker.Models;

public class AppDetailsModel {

    String id;
    String userId;
    String appName;
    String creatorName;
    String icon;
    String appDesc;

    public AppDetailsModel(String id, String userId, String appName, String creatorName, String icon, String appDesc) {
        this.id = id;
        this.userId = userId;
        this.appName = appName;
        this.creatorName = creatorName;
        this.icon = icon;
        this.appDesc = appDesc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getAppName() {
        return appName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getIcon() {
        return icon;
    }

    public String getAppDesc() {
        return appDesc;
    }
}
