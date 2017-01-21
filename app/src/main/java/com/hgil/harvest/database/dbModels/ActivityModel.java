package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 05-01-2017.
 */

public class ActivityModel {

    private int activity_id;
    private String name;
    private int par_activity;
    private int def_start_time;
    private int def_end_time;
    private int def_dar_time;
    private int max_dar_time;
    private String val_fields;
    private int state;
    private String ip;
    private String u_ts;

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPar_activity() {
        return par_activity;
    }

    public void setPar_activity(int par_activity) {
        this.par_activity = par_activity;
    }

    public int getDef_start_time() {
        return def_start_time;
    }

    public void setDef_start_time(int def_start_time) {
        this.def_start_time = def_start_time;
    }

    public int getDef_end_time() {
        return def_end_time;
    }

    public void setDef_end_time(int def_end_time) {
        this.def_end_time = def_end_time;
    }

    public int getDef_dar_time() {
        return def_dar_time;
    }

    public void setDef_dar_time(int def_dar_time) {
        this.def_dar_time = def_dar_time;
    }

    public int getMax_dar_time() {
        return max_dar_time;
    }

    public void setMax_dar_time(int max_dar_time) {
        this.max_dar_time = max_dar_time;
    }

    public String getVal_fields() {
        return val_fields;
    }

    public void setVal_fields(String val_fields) {
        this.val_fields = val_fields;
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
