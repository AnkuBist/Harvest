package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class SchemeTypeModel {

    private int scheme_type_id; //not null
    private String name;    //not null
    private int state;
    private String ip;
    private String u_ts;    //not null

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public int getScheme_type_id() {
        return scheme_type_id;
    }

    public void setScheme_type_id(int scheme_type_id) {
        this.scheme_type_id = scheme_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

