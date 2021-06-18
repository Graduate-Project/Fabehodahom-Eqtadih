package com.example.myproject.pojo;

public class AudioData {

    private int audioImage;
    private String audioName;
    private String audioDescription;
    private String period;

    public AudioData(int audioImage, String audioName, String audioDescription, String period) {
        this.audioImage = audioImage;
        this.audioName = audioName;
        this.audioDescription = audioDescription;
        this.period = period;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioDescription() {
        return audioDescription;
    }

    public void setAudioDescription(String audioDescription) {
        this.audioDescription = audioDescription;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getAudioImage() {
        return audioImage;
    }

    public void setAudioImage(int audioImage) {
        this.audioImage = audioImage;
    }
}
