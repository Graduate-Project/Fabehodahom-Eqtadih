package com.example.myproject.room;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface SehapaDao {

    @Insert
    void insertSehapy (Sehapa sehapa);

    @Query("select * from Sehapa_table")
    List<Sehapa> getSehapa();



}
