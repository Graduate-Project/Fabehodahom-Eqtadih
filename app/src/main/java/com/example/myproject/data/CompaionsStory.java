package com.example.myproject.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CompaionsStory {
    @SerializedName("personId")
    @Expose
    private Integer personId;
    @SerializedName("personName")
    @Expose
    private String personName;
    @SerializedName("personBreif")
    @Expose
    private Object personBreif;
    @SerializedName("Narration")
    @Expose
    private String narration;
    @SerializedName("placeOfDeth")
    @Expose
    private Object placeOfDeth;
    @SerializedName("placeOfBirth")
    @Expose
    private Object placeOfBirth;
    @SerializedName("per_image")
    @Expose
    private Object perImage;
    @SerializedName("Audio")
    @Expose
    private Object audio;

    public CompaionsStory(String narration) {
        this.narration = narration;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Object getPersonBreif() {
        return personBreif;
    }

    public void setPersonBreif(Object personBreif) {
        this.personBreif = personBreif;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Object getPlaceOfDeth() {
        return placeOfDeth;
    }

    public void setPlaceOfDeth(Object placeOfDeth) {
        this.placeOfDeth = placeOfDeth;
    }

    public Object getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Object placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Object getPerImage() {
        return perImage;
    }

    public void setPerImage(Object perImage) {
        this.perImage = perImage;
    }

    public Object getAudio() {
        return audio;
    }

    public void setAudio(Object audio) {
        this.audio = audio;
    }
}
