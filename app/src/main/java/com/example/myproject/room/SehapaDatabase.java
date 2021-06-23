package com.example.myproject.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Sehapa.class, version = 1)
public abstract class SehapaDatabase extends RoomDatabase {

    private static SehapaDatabase instance;
    public abstract SehapaDao sehapaDao();

    public static synchronized SehapaDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SehapaDatabase.class, "Sehapa_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
