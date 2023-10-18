package com.tramquangvinh.customlistview;

public class Bear {
    private int image;
    private String name;

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bear(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
