package com.example.myproject.pojo;

public class LibraryData {

    private int libImg;
    private String libName;
    private String libDisc;

    public LibraryData(int libImg, String libName) {
        this.libImg = libImg;
        this.libName = libName;
    }

    public int getLibImg() {
        return libImg;
    }

    public void setLibImg(int libImg) {
        this.libImg = libImg;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }
}
