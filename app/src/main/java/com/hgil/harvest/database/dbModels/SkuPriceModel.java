package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class SkuPriceModel {

    private int price_id;   //not null
    private String sku_code;    //not null
    private String location_code;   //not null
    private float mrp;
    private float mrp_min;
    private float mrp_max;
    private float start_qty;
    private float end_qty;
    private float margin;
    private String start_date;
    private String end_date;
    private String tax_code;
    private String batch_no;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    public float getMrp_min() {
        return mrp_min;
    }

    public void setMrp_min(float mrp_min) {
        this.mrp_min = mrp_min;
    }

    public float getMrp_max() {
        return mrp_max;
    }

    public void setMrp_max(float mrp_max) {
        this.mrp_max = mrp_max;
    }

    public float getStart_qty() {
        return start_qty;
    }

    public void setStart_qty(float start_qty) {
        this.start_qty = start_qty;
    }

    public float getEnd_qty() {
        return end_qty;
    }

    public void setEnd_qty(float end_qty) {
        this.end_qty = end_qty;
    }

    public float getMargin() {
        return margin;
    }

    public void setMargin(float margin) {
        this.margin = margin;
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

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
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
