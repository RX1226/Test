package com.rx1226.http;

import com.google.gson.annotations.SerializedName;

public class GetChannelRequest {
    @SerializedName("fnCHANNEL_ID")
    private int chanel;
    @SerializedName("fsDEVICE")
    private String device;
    @SerializedName("fsASSET_ID")
    private String assetId;
    @SerializedName("fsTOKEN")
    private String token;

    public GetChannelRequest(int chanel, String device, String assetId, String token) {
        this.chanel = chanel;
        this.device = device;
        this.assetId = assetId;
        this.token = token;
    }

    public int getChanel() {
        return chanel;
    }

    public void setChanel(int chanel) {
        this.chanel = chanel;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
