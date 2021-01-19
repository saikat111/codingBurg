package com.sorder.saikat.codingburg.model;

public class SliderItem {
    String ImageUrl;
    String Description;

    public SliderItem(String imageUrl, String description) {
        ImageUrl = imageUrl;
        Description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
