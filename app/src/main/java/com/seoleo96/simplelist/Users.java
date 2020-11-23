package com.seoleo96.simplelist;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("name")
    private String username;
    @SerializedName("img")
    private String urlImage;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
