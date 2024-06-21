package com.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String img;
    private int identification;

    public User(int id, String username, String password, String img, int identification) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.img = img;
        this.identification = identification;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", img='" + img + '\'' +
                ", identification=" + identification +
                '}';
    }
}
