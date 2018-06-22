package com.urancompany.model;


public class Exhibit {
    private String title;
    private String[] images;

    public Exhibit(String title, String[] images) {
        this.title = title;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String[] getImages() {
        return images;
    }
}
