package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class OutletModel {

    private int outlet_id;  //not null
    private String outlet_code; //not null
    private String name;    //not null
    private String outlet_cat, outlet_cat1, outlet_cat2, outlet_cat3;
    private String outlet_type;
    private String mobile_no;
    private String phone_no;
    private String email_id;
    private String address;
    private String city_name;
    private String pin_code;
    private String location_code;
    private float cr_limit;
    private float outstanding;  //not null
    private String outlet_group_id;
    private String gps_long;
    private String gps_lat;
    private String service_branch;
    private String service_rep;
    private String created_by;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutlet_cat() {
        return outlet_cat;
    }

    public void setOutlet_cat(String outlet_cat) {
        this.outlet_cat = outlet_cat;
    }

    public String getOutlet_cat1() {
        return outlet_cat1;
    }

    public void setOutlet_cat1(String outlet_cat1) {
        this.outlet_cat1 = outlet_cat1;
    }

    public String getOutlet_cat2() {
        return outlet_cat2;
    }

    public void setOutlet_cat2(String outlet_cat2) {
        this.outlet_cat2 = outlet_cat2;
    }

    public String getOutlet_cat3() {
        return outlet_cat3;
    }

    public void setOutlet_cat3(String outlet_cat3) {
        this.outlet_cat3 = outlet_cat3;
    }

    public String getOutlet_type() {
        return outlet_type;
    }

    public void setOutlet_type(String outlet_type) {
        this.outlet_type = outlet_type;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public float getCr_limit() {
        return cr_limit;
    }

    public void setCr_limit(float cr_limit) {
        this.cr_limit = cr_limit;
    }

    public float getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(float outstanding) {
        this.outstanding = outstanding;
    }

    public String getOutlet_group_id() {
        return outlet_group_id;
    }

    public void setOutlet_group_id(String outlet_group_id) {
        this.outlet_group_id = outlet_group_id;
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

    public String getService_branch() {
        return service_branch;
    }

    public void setService_branch(String service_branch) {
        this.service_branch = service_branch;
    }

    public String getService_rep() {
        return service_rep;
    }

    public void setService_rep(String service_rep) {
        this.service_rep = service_rep;
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
}
