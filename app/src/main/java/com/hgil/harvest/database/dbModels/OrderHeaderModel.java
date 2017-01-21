package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class OrderHeaderModel {

    private long order_id;
    private int beat_id;
    private int outlet_id;
    private String beat_code;
    private String outlet_code;
    private float net_amount;
    private int item_count;
    private String order_date;
    private String owner_id;
    private String dist_id;
    private String invoice_id;
    private String delivery_status;
    private String order_type;
    private String status;
    private String gps_long;
    private String gps_lat;
    private String order_info;
    private String created_at;
    private int state;
    private String ip;
    private String u_ts;
    private long ref_id;

    public long getRef_id() {
        return ref_id;
    }

    public void setRef_id(long ref_id) {
        this.ref_id = ref_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public int getBeat_id() {
        return beat_id;
    }

    public void setBeat_id(int beat_id) {
        this.beat_id = beat_id;
    }

    public int getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(int outlet_id) {
        this.outlet_id = outlet_id;
    }

    public String getBeat_code() {
        return beat_code;
    }

    public void setBeat_code(String beat_code) {
        this.beat_code = beat_code;
    }

    public String getOutlet_code() {
        return outlet_code;
    }

    public void setOutlet_code(String outlet_code) {
        this.outlet_code = outlet_code;
    }

    public float getNet_amount() {
        return net_amount;
    }

    public void setNet_amount(float net_amount) {
        this.net_amount = net_amount;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getDist_id() {
        return dist_id;
    }

    public void setDist_id(String dist_id) {
        this.dist_id = dist_id;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGps_long() {
        return gps_long;
    }

    public void setGps_long(String gps_long) {
        this.gps_long = gps_long;
    }

    public String getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(String gps_lat) {
        this.gps_lat = gps_lat;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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
