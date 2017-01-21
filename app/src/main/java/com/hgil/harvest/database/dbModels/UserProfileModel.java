package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 07-01-2017.
 */

public class UserProfileModel {

    private int user_profile_id;    //not null
    private String email;   //not null
    private String name;    //not null
    private String description;
    private String user_code;
    private String user_type;
    private String device_id;
    private String device_type;
    private String device_id_1;
    private String device_type_1;
    private String device_id_2;
    private String device_type_2;
    private String address;
    private String city_name;
    private String orders_self;
    private String orders_others;
    private String img_url_1;
    private int no_login;
    private String phone_1;
    private String phone_2;
    private String ip;
    private String u_ts;    //not null

    public int getUser_profile_id() {
        return user_profile_id;
    }

    public void setUser_profile_id(int user_profile_id) {
        this.user_profile_id = user_profile_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_id_1() {
        return device_id_1;
    }

    public void setDevice_id_1(String device_id_1) {
        this.device_id_1 = device_id_1;
    }

    public String getDevice_type_1() {
        return device_type_1;
    }

    public void setDevice_type_1(String device_type_1) {
        this.device_type_1 = device_type_1;
    }

    public String getDevice_id_2() {
        return device_id_2;
    }

    public void setDevice_id_2(String device_id_2) {
        this.device_id_2 = device_id_2;
    }

    public String getDevice_type_2() {
        return device_type_2;
    }

    public void setDevice_type_2(String device_type_2) {
        this.device_type_2 = device_type_2;
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

    public String getOrders_self() {
        return orders_self;
    }

    public void setOrders_self(String orders_self) {
        this.orders_self = orders_self;
    }

    public String getOrders_others() {
        return orders_others;
    }

    public void setOrders_others(String orders_others) {
        this.orders_others = orders_others;
    }

    public String getImg_url_1() {
        return img_url_1;
    }

    public void setImg_url_1(String img_url_1) {
        this.img_url_1 = img_url_1;
    }

    public int getNo_login() {
        return no_login;
    }

    public void setNo_login(int no_login) {
        this.no_login = no_login;
    }

    public String getPhone_1() {
        return phone_1;
    }

    public void setPhone_1(String phone_1) {
        this.phone_1 = phone_1;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
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
