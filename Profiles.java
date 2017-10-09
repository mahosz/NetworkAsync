package com.example.mchho.networkasync;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profiles {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("profile")
    @Expose
    private List<Profile> profile = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Profile> getProfile() {
        return profile;
    }

    public void setProfile(List<Profile> profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", profile=" + profile +
                '}';
    }
}