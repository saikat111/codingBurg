package com.sorder.saikat.codingburg.model;

public class LessonModel {
    String url;
    String title;
    String type;
    String lecturer1;
    String lecturer2;
    String code_title1;
    String code1;
    String code_title2;
    String code2;
    String image_title1;
    String image1;
    String image_title2;
    String image2;
    String writer_name;
    String date;
    String update_time;

    public LessonModel(String url, String title, String type, String lecturer1, String lecturer2,String code_title1, String code1, String code_title2, String code2, String image_title1, String image1, String image_title2, String image2, String writer_name, String date, String update_time) {
        this.url = url;
        this.title = title;
        this.type = type;
        this.lecturer1 = lecturer1;
        this.lecturer2 = lecturer2;
        this.code_title1 = code_title1;
        this.code1 = code1;
        this.code_title2 = code_title2;
        this.code2 = code2;
        this.image_title1 = image_title1;
        this.image1 = image1;
        this.image_title2 = image_title2;
        this.image2 = image2;
        this.writer_name = writer_name;
        this.date = date;
        this.update_time = update_time;
    }

    public String getCode_title1() {
        return code_title1;
    }

    public void setCode_title1(String code_title1) {
        this.code_title1 = code_title1;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getLecturer1() {
        return lecturer1;
    }

    public void setLecturer1(String lecturer1) {
        this.lecturer1 = lecturer1;
    }

    public String getLecturer2() {
        return lecturer2;
    }

    public void setLecturer2(String lecturer2) {
        this.lecturer2 = lecturer2;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode_title2() {
        return code_title2;
    }

    public void setCode_title2(String code_title2) {
        this.code_title2 = code_title2;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getImage_title1() {
        return image_title1;
    }

    public void setImage_title1(String image_title1) {
        this.image_title1 = image_title1;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage_title2() {
        return image_title2;
    }

    public void setImage_title2(String image_title2) {
        this.image_title2 = image_title2;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
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
