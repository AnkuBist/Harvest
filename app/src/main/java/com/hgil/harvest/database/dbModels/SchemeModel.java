package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class SchemeModel {

    private int scheme_id;  //not null
    private String location_code;
    private String sku_code;    //not null
    private String scheme_type; //not null
    private String start_date;
    private String end_date;
    private int item_start;
    private int item_end;
    private float item_disc;
    private int free_sku_id;
    private float item_disc_max;
    private float item_disc_per;
    private String scope_outlet;
    private String scope_outlet_cat;
    private String scope_sku_cat;
    private String scope_dist_id;
    private String ref_id;
    private String scheme_code;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public int getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(int scheme_id) {
        this.scheme_id = scheme_id;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public String getScheme_type() {
        return scheme_type;
    }

    public void setScheme_type(String scheme_type) {
        this.scheme_type = scheme_type;
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

    public int getItem_start() {
        return item_start;
    }

    public void setItem_start(int item_start) {
        this.item_start = item_start;
    }

    public int getItem_end() {
        return item_end;
    }

    public void setItem_end(int item_end) {
        this.item_end = item_end;
    }

    public float getItem_disc() {
        return item_disc;
    }

    public void setItem_disc(float item_disc) {
        this.item_disc = item_disc;
    }

    public int getFree_sku_id() {
        return free_sku_id;
    }

    public void setFree_sku_id(int free_sku_id) {
        this.free_sku_id = free_sku_id;
    }

    public float getItem_disc_max() {
        return item_disc_max;
    }

    public void setItem_disc_max(float item_disc_max) {
        this.item_disc_max = item_disc_max;
    }

    public float getItem_disc_per() {
        return item_disc_per;
    }

    public void setItem_disc_per(float item_disc_per) {
        this.item_disc_per = item_disc_per;
    }

    public String getScope_outlet() {
        return scope_outlet;
    }

    public void setScope_outlet(String scope_outlet) {
        this.scope_outlet = scope_outlet;
    }

    public String getScope_outlet_cat() {
        return scope_outlet_cat;
    }

    public void setScope_outlet_cat(String scope_outlet_cat) {
        this.scope_outlet_cat = scope_outlet_cat;
    }

    public String getScope_sku_cat() {
        return scope_sku_cat;
    }

    public void setScope_sku_cat(String scope_sku_cat) {
        this.scope_sku_cat = scope_sku_cat;
    }

    public String getScope_dist_id() {
        return scope_dist_id;
    }

    public void setScope_dist_id(String scope_dist_id) {
        this.scope_dist_id = scope_dist_id;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getScheme_code() {
        return scheme_code;
    }

    public void setScheme_code(String scheme_code) {
        this.scheme_code = scheme_code;
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
