package com.codegym.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10000000)
    private String title;
    @Column(length = 10000000)
    private String context;
    @Column(length = 10000000)
    private String img;
    private Date date;
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(int id, String title, String context, String img, Date date, User user) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.img = img;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

