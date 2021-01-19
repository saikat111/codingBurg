package com.sorder.saikat.codingburg.model;

public class NewsModel {
    String title ;
    String  news;
    String image ;
    String writer_name ;
    String  date ;
    String update_time;

    public NewsModel(String title, String news, String image, String writer_name, String date, String update_time) {
        this.title = title;
        this.news = news;
        this.image = image;
        this.writer_name = writer_name;
        this.date = date;
        this.update_time = update_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWriter_name() {
        return writer_name;
    }

    public void setWriter_name(String writer_name) {
        this.writer_name = writer_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
