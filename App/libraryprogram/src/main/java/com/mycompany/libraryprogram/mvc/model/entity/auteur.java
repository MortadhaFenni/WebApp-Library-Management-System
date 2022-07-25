package com.mycompany.libraryprogram.mvc.model.entity;

import java.sql.Date;

public class auteur {

    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String avatar;

    public auteur() {
    }

    public auteur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    
    
    public auteur(String nom, String prenom, Date date_naissance, String avatar) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.avatar = avatar;
    }

    public auteur(int id, String nom, String prenom, Date date_naissance, String avatar) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
