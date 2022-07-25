package com.mycompany.libraryprogram.mvc.model.entity;

import java.util.Date;

public class livre {

    private int issn;
    private String titre;
    private String resume;
    private int nb_pages;
    private int genres;
    private int s_genre;
    private String avatar;
    private String file;
    private Integer userId;
    private Date createdAt = new Date();

    public livre() {
    }

    public livre(int issn, String titre, String resume, int nb_pages, int genres, int s_genre, String avatar, String file, Integer userId) {
        this.issn = issn;
        this.titre = titre;
        this.resume = resume;
        this.nb_pages = nb_pages;
        this.genres = genres;
        this.s_genre = s_genre;
        this.avatar = avatar;
        this.file = file;
        this.userId = userId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getNb_pages() {
        return nb_pages;
    }

    public void setNb_pages(int nb_pages) {
        this.nb_pages = nb_pages;
    }

    public int getGenres() {
        return genres;
    }

    public void setGenres(int genres) {
        this.genres = genres;
    }

    public int getS_genre() {
        return s_genre;
    }

    public void setS_genre(int s_genre) {
        this.s_genre = s_genre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    
}
