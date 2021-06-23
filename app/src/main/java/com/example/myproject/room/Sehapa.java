package com.example.myproject.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sehapa_table")
public class Sehapa {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String body;

    public Sehapa(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
