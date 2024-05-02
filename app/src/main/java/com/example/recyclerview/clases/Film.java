package com.example.recyclerview.clases;

public class Film {
    private String name;
    private String duration;
    private String image;

    public Film(String name, String duration, String image) {
        this.name = name;
        this.duration = duration;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
