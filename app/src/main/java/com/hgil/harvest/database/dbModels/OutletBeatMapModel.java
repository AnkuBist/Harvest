package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class OutletBeatMapModel {

    private int outlet_map_id;  //not null
    private String outlet_code; //not null
    private String beat_name;   //not null
    private int map_order;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public int getOutlet_map_id() {
        return outlet_map_id;
    }

    public void setOutlet_map_id(int outlet_map_id) {
        this.outlet_map_id = outlet_map_id;
    }

    public String getOutlet_code() {
        return outlet_code;
    }

    public void setOutlet_code(String outlet_code) {
        this.outlet_code = outlet_code;
    }

    public String getBeat_name() {
        return beat_name;
    }

    public void setBeat_name(String beat_name) {
        this.beat_name = beat_name;
    }

    public int getMap_order() {
        return map_order;
    }

    public void setMap_order(int map_order) {
        this.map_order = map_order;
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
