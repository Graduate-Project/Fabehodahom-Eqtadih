package com.example.myproject.room;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Entity(tableName = "Sehapa_table")
public class Sehapa {
    @PrimaryKey(autoGenerate = true)
    private int personid;
    private String personBreif;
    private String personName;
    private  String narration;

    public Sehapa(int personid, String narration) {
        this.personid = personid;
        this.narration = narration;
    }
    @Ignore
    public Sehapa(int personid, String personBreif, String personName, String narration) {
        this.personid = personid;
        this.personBreif = personBreif;
        this.personName = personName;
        this.narration = narration;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getPersonBreif() {
        return personBreif;
    }

    public void setPersonBreif(String personBreif) {
        this.personBreif = personBreif;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }
}
