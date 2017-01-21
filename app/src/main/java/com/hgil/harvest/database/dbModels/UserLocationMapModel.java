package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class UserLocationMapModel {

    private int user_location_id;
    private String email;
    private String location_code;
    private String ip;  //null
    private String u_ts;

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public int getUser_location_id() {
        return user_location_id;
    }

    public void setUser_location_id(int user_location_id) {
        this.user_location_id = user_location_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
