package com.rx1226.http;

import com.google.gson.annotations.SerializedName;

public class SignInRespond {
    @SerializedName("Data")
    private String data;
    @SerializedName("Success")
    private boolean isSuccess;
    @SerializedName("Status")
    private int status;
    @SerializedName("ErrMessage")
    private String message;

    public String getData() {
        return data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
