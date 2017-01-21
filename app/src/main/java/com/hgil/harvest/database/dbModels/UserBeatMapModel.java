package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 07-01-2017.
 */

public class UserBeatMapModel {

    private int user_beat_id;
    private String email;
    private String beat_id;
    private String ip;  //null
    private String u_ts;

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public int getUser_beat_id() {
        return user_beat_id;
    }

    public void setUser_beat_id(int user_beat_id) {
        this.user_beat_id = user_beat_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBeat_id() {
        return beat_id;
    }

    public void setBeat_id(String beat_id) {
        this.beat_id = beat_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
