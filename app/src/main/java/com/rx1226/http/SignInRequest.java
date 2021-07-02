package com.rx1226.http;

import com.google.gson.annotations.SerializedName;

public class SignInRequest {
    @SerializedName("fsDEVICE")
    private String device;
    @SerializedName("fsUSER_ID")
    private String id;
    @SerializedName("fsPASSWORD")
    private String pw;

    public SignInRequest(String device, String id, String pw) {
        this.device = device;
        this.id = id;
        this.pw = pw;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
