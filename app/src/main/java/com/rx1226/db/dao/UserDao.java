package com.rx1226.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rx1226.db.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER")
    List<UserEntity> getAllUser();

    @Query("SELECT * FROM USER WHERE name LIKE :name")
    UserEntity queryByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserEntity... users);

    @Update
    void update(UserEntity... users);

    @Delete
    void delete(UserEntity... users);
}
