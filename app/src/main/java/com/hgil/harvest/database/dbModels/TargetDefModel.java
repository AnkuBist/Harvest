package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 07-01-2017.
 */

public class TargetDefModel {

    private int target_def_id;
    private String target_name;
    private String target_source;
    private String target_value;
    private String target_param;    //null
    private String target_type;     //null
    private String outlet_code;     //null
    private String beat_code;
    private String sku_code;
    private int dist_id;            //null
    private String userid_col;      //null
    private String date_col;        //null
    private int state;              //null
    private String ip;              //null
    private String u_ts;

    public int getTarget_def_id() {
        return target_def_id;
    }

    public void setTarget_def_id(int target_def_id) {
        this.target_def_id = target_def_id;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }

    public String getTarget_source() {
        return target_source;
    }

    public void setTarget_source(String target_source) {
        this.target_source = target_source;
    }

    public String getTarget_value() {
        return target_value;
    }

    public void setTarget_value(String target_value) {
        this.target_value = target_value;
    }

    public String getTarget_param() {
        return target_param;
    }

    public void setTarget_param(String target_param) {
        this.target_param = target_param;
    }

    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public String getOutlet_code() {
        return outlet_code;
    }

    public void setOutlet_code(String outlet_code) {
        this.outlet_code = outlet_code;
    }

    public String getBeat_code() {
        return beat_code;
    }

    public void setBeat_code(String beat_code) {
        this.beat_code = beat_code;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public int getDist_id() {
        return dist_id;
    }

    public void setDist_id(int dist_id) {
        this.dist_id = dist_id;
    }

    public String getUserid_col() {
        return userid_col;
    }

    public void setUserid_col(String userid_col) {
        this.userid_col = userid_col;
    }

    public String getDate_col() {
        return date_col;
    }

    public void setDate_col(String date_col) {
        this.date_col = date_col;
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
