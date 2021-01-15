package com.sorder.saikat.codingburg.model;

public class CategoryModel {
    String url;
    String name;
    String title;
    String type;
    String image;
    String date;
    String update;

    public CategoryModel(String url, String name, String title, String type, String image, String date, String update) {
        this.url = url;
        this.name = name;
        this.title = title;
        this.type = type;
        this.image = image;
        this.date = date;
        this.update = update;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
