package com.dias.course.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseInstance extends RoomDatabase {
    public abstract UserDAO getUserDao();
}
