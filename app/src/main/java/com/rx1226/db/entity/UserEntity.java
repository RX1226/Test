package com.rx1226.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "USER")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    private String name;

    @ColumnInfo(name = "number", typeAffinity = ColumnInfo.INTEGER)
    private int number;

    @Ignore
    private boolean isLogin; //不建立在table內

    public UserEntity(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isLogin() {
        return isLogin;
    }
}