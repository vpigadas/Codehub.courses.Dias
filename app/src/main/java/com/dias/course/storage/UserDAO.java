package com.dias.course.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(List<UserEntity> data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity... data);

    @Delete
    public int delete(UserEntity data);

    @Query("SELECT * FROM User")
    public List<UserEntity> get();

    @Query("SELECT * FROM User LIMIT 1")
    @Nullable
    public UserEntity getFirst();

    @Query("SELECT * FROM User WHERE name like :strName")
    @NonNull
    public List<UserEntity> get(String strName);
}
