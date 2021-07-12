package com.example.myproject.data;

public class VideoModel {

    private String videoLink;
    private String seriesName;
    private String Category;
    private String instructorName;
    private String videoName;
    private int personId;
    private int videoId;

    public VideoModel(String videoLink) {
        this.videoLink=videoLink;
    }

    public VideoModel(String videoLink, String seriesName, String instructorName, String videoName) {
        this.videoLink = videoLink;
        this.seriesName = seriesName;
        this.instructorName = instructorName;
        this.videoName = videoName;
    }

    public VideoModel(String videoLink, String instructorName, String videoName) {
        this.videoLink = videoLink;
        this.instructorName = instructorName;
        this.videoName = videoName;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}

