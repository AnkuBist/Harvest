package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class PaymentModel {

    private long payment_id; //not null
    private String owner_id;
    private int beat_id;
    private String beat_code;
    private int outlet_id;
    private String outlet_code;
    private float total_amount;
    private float disc_val1;
    private float disc_val2;
    private float disc_val3;
    private String payment_status;
    private String gps_long;
    private String gps_lat;
    private String created_by;
    private String payment_ref;
    private String receipt_no;
    private String pay_date;
    private int confirmed;
    private String confirmed_by;
    private String confirmed_on;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public int getBeat_id() {
        return beat_id;
    }

    public void setBeat_id(int beat_id) {
        this.beat_id = beat_id;
    }

    public String getBeat_code() {
        return beat_code;
    }

    public void setBeat_code(String beat_code) {
        this.beat_code = beat_code;
    }

    public int getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(int outlet_id) {
        this.outlet_id = outlet_id;
    }

    public String getOutlet_code() {
        return outlet_code;
    }

    public void setOutlet_code(String outlet_code) {
        this.outlet_code = outlet_code;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getDisc_val1() {
        return disc_val1;
    }

    public void setDisc_val1(float disc_val1) {
        this.disc_val1 = disc_val1;
    }

    public float getDisc_val2() {
        return disc_val2;
    }

    public void setDisc_val2(float disc_val2) {
        this.disc_val2 = disc_val2;
    }

    public float getDisc_val3() {
        return disc_val3;
    }

    public void setDisc_val3(float disc_val3) {
        this.disc_val3 = disc_val3;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getPayment_ref() {
        return payment_ref;
    }

    public void setPayment_ref(String payment_ref) {
        this.payment_ref = payment_ref;
    }

    public String getReceipt_no() {
        return receipt_no;
    }

    public void setReceipt_no(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public String getConfirmed_by() {
        return confirmed_by;
    }

    public void setConfirmed_by(String confirmed_by) {
        this.confirmed_by = confirmed_by;
    }

    public String getConfirmed_on() {
        return confirmed_on;
    }

    public void setConfirmed_on(String confirmed_on) {
        this.confirmed_on = confirmed_on;
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

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }
}
