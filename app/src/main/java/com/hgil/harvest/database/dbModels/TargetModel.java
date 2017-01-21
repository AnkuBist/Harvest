package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 07-01-2017.
 */

public class TargetModel {

    private int target_id;  //not null
    private String target_def_id;   //not null
    private String userid;  //not null
    private int period_type;    //not null
    private String start_date;  //not null
    private String end_date;    //not null
    private float target_value;
    private float target_acheived;
    private String created_by;
    private int target_repeat;
    private int par_target_id;
    private int target_status;
    private float spilled_over;
    private String spill_over;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public String getTarget_def_id() {
        return target_def_id;
    }

    public void setTarget_def_id(String target_ref_id) {
        this.target_def_id = target_def_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getPeriod_type() {
        return period_type;
    }

    public void setPeriod_type(int period_type) {
        this.period_type = period_type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public float getTarget_value() {
        return target_value;
    }

    public void setTarget_value(float target_value) {
        this.target_value = target_value;
    }

    public float getTarget_acheived() {
        return target_acheived;
    }

    public void setTarget_acheived(float target_acheived) {
        this.target_acheived = target_acheived;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public int getTarget_repeat() {
        return target_repeat;
    }

    public void setTarget_repeat(int target_repeat) {
        this.target_repeat = target_repeat;
    }

    public int getPar_target_id() {
        return par_target_id;
    }

    public void setPar_target_id(int par_target_id) {
        this.par_target_id = par_target_id;
    }

    public int getTarget_status() {
        return target_status;
    }

    public void setTarget_status(int target_status) {
        this.target_status = target_status;
    }

    public float getSpilled_over() {
        return spilled_over;
    }

    public void setSpilled_over(float spilled_over) {
        this.spilled_over = spilled_over;
    }

    public String getSpill_over() {
        return spill_over;
    }

    public void setSpill_over(String spill_over) {
        this.spill_over = spill_over;
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
