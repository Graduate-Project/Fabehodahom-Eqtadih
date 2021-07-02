package com.example.myproject.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttributeModel {

    @SerializedName("sefatId")
    @Expose
    private Integer sefatId;

    @SerializedName("sefatName")
    @Expose
    private String sefatName;

    @SerializedName("sefatDetails")
    @Expose
    private String sefatDetails;

    @SerializedName("sefatFadL")
    @Expose
    private Object sefatFadL;

    @SerializedName("sefatSteps")
    @Expose
    private Object sefatSteps;

    @SerializedName("Image")
    @Expose
    private Object Image ;

    @SerializedName("sefatAudio")
    @Expose
    private Object sefatAudio;

    public Integer getSefatId() {
        return sefatId;
    }

    public void setSefatId(Integer sefatId) {
        this.sefatId = sefatId;
    }

    public String getSefatName() {
        return sefatName;
    }

    public void setSefatName(String sefatName) {
        this.sefatName = sefatName;
    }

    public String getSefatDetails() {
        return sefatDetails;
    }

    public void setSefatDetails(String sefatDetails) {
        this.sefatDetails = sefatDetails;
    }

    public Object getSefatFadL() {
        return sefatFadL;
    }

    public void setSefatFadL(Object sefatFadL) {
        this.sefatFadL = sefatFadL;
    }

    public Object getSefatSteps() {
        return sefatSteps;
    }

    public void setSefatSteps(Object sefatSteps) {
        this.sefatSteps = sefatSteps;
    }

    public Object getImage() {
        return Image;
    }

    public void setImage(Object image) {
        Image = image;
    }

    public Object getSefatAudio() {
        return sefatAudio;
    }

    public void setSefatAudio(Object sefatAudio) {
        this.sefatAudio = sefatAudio;
    }
}
