package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 05-01-2017.
 */

public class BeatModel {

    private int beat_id;
    private String name;
    private int par_beat_id;
    private String beat_code;
    private int outlet_count;
    private String city_name;
    private String location_code;
    private String created_by;
    private int state;
    private String ip;
    private String u_ts;

    public int getBeat_id() {
        return beat_id;
    }

    public void setBeat_id(int beat_id) {
        this.beat_id = beat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPar_beat_id() {
        return par_beat_id;
    }

    public void setPar_beat_id(int par_beat_id) {
        this.par_beat_id = par_beat_id;
    }

    public String getBeat_code() {
        return beat_code;
    }

    public void setBeat_code(String beat_code) {
        this.beat_code = beat_code;
    }

    public int getOutlet_count() {
        return outlet_count;
    }

    public void setOutlet_count(int outlet_count) {
        this.outlet_count = outlet_count;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
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

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }
}
