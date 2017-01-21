package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class OrderSchemeModel {

    private long order_id;
    private int sku_id;
    private String sku_code;
    private int scheme_id;
    private long free_scheme_id;
    private int is_invoice;
    private int type;
    private float disc_count;
    private float disc_value;
    private String disc_desc;
    private int state;
    private String ip;
    private String u_ts;

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public int getSku_id() {
        return sku_id;
    }

    public void setSku_id(int sku_id) {
        this.sku_id = sku_id;
    }

    public String getSku_code() {
        return sku_code;
    }

    public void setSku_code(String sku_code) {
        this.sku_code = sku_code;
    }

    public int getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(int scheme_id) {
        this.scheme_id = scheme_id;
    }

    public long getFree_scheme_id() {
        return free_scheme_id;
    }

    public void setFree_scheme_id(long free_scheme_id) {
        this.free_scheme_id = free_scheme_id;
    }

    public int getIs_invoice() {
        return is_invoice;
    }

    public void setIs_invoice(int is_invoice) {
        this.is_invoice = is_invoice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getDisc_count() {
        return disc_count;
    }

    public void setDisc_count(float disc_count) {
        this.disc_count = disc_count;
    }

    public float getDisc_value() {
        return disc_value;
    }

    public void setDisc_value(float disc_value) {
        this.disc_value = disc_value;
    }

    public String getDisc_desc() {
        return disc_desc;
    }

    public void setDisc_desc(String disc_desc) {
        this.disc_desc = disc_desc;
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
