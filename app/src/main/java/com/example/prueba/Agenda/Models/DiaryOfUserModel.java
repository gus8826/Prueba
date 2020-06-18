package com.example.prueba.Agenda.Models;

public class DiaryOfUserModel {

    private String idReport;
    private String idUser;
    private String name;
    private String nameAlias;
    private String image;
    private int image_;
    private String comments;

    public DiaryOfUserModel(String idReport, String name, String nameAlias, int image_) {
        this.idReport = idReport;
        this.name = name;
        this.nameAlias = nameAlias;
        this.image_ = image_;
    }

    public DiaryOfUserModel() {
    }

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAlias() {
        return nameAlias;
    }

    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImage_() {
        return image_;
    }

    public void setImage_(int image_) {
        this.image_ = image_;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
