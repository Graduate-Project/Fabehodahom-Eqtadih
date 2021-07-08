package com.example.myproject.data;

public class AudioModel {

    private int videoId;
    private int personId;
    private String videoName;
    private String videoDescription;
    private String instructorName;
    private int Category;
    private String seriesName;
    private String videoLink;

    private AudioModel audio;

    public AudioModel( String videoDescription, String instructorName, String seriesName) {
        this.videoDescription = videoDescription;
        this.instructorName = instructorName;
        this.seriesName = seriesName;
    }

    public AudioModel( String videoDescription, String instructorName, String seriesName, String videoLink) {
        this.videoDescription = videoDescription;
        this.instructorName = instructorName;
        this.seriesName = seriesName;
        this.videoLink = videoLink;
    }


    public AudioModel(AudioModel audio) {
        this.audio = audio;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}
