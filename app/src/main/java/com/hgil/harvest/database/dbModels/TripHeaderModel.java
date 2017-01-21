package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 07-01-2017.
 */

public class TripHeaderModel {

    private long trip_id;    //not null
    private String owner_id;
    private String start_time;
    private String end_time;
    private String vehicle_id;
    private String vehicle_type;
    private String vehicle_name;
    private String driver_name;
    private String alt_driver_name;
    private float start_meter;
    private float end_meter;
    private String verified_by;
    private String trip_status;
    private String vehicle_status;
    private String ref_id;
    private float loaded_qty;
    private float current_qty;
    private float returned_qty;
    private float damaged_qty;
    private float closing_qty;
    private float scheme_qty;
    private float d1, d2, d3, d4, d5, d6;
    private String t1, t2, t3, t4, t5, t6;
    private String created_by;
    private String gps_long;
    private String gps_lat;
    private int state;
    private String ip;
    private String u_ts;    //not null

    public long getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(long trip_id) {
        this.trip_id = trip_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getAlt_driver_name() {
        return alt_driver_name;
    }

    public void setAlt_driver_name(String alt_driver_name) {
        this.alt_driver_name = alt_driver_name;
    }

    public float getStart_meter() {
        return start_meter;
    }

    public void setStart_meter(float start_meter) {
        this.start_meter = start_meter;
    }

    public float getEnd_meter() {
        return end_meter;
    }

    public void setEnd_meter(float end_meter) {
        this.end_meter = end_meter;
    }

    public String getVerified_by() {
        return verified_by;
    }

    public void setVerified_by(String verified_by) {
        this.verified_by = verified_by;
    }

    public String getTrip_status() {
        return trip_status;
    }

    public void setTrip_status(String trip_status) {
        this.trip_status = trip_status;
    }

    public String getVehicle_status() {
        return vehicle_status;
    }

    public void setVehicle_status(String vehicle_status) {
        this.vehicle_status = vehicle_status;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public float getLoaded_qty() {
        return loaded_qty;
    }

    public void setLoaded_qty(float loaded_qty) {
        this.loaded_qty = loaded_qty;
    }

    public float getCurrent_qty() {
        return current_qty;
    }

    public void setCurrent_qty(float current_qty) {
        this.current_qty = current_qty;
    }

    public float getReturned_qty() {
        return returned_qty;
    }

    public void setReturned_qty(float returned_qty) {
        this.returned_qty = returned_qty;
    }

    public float getDamaged_qty() {
        return damaged_qty;
    }

    public void setDamaged_qty(float damaged_qty) {
        this.damaged_qty = damaged_qty;
    }

    public float getClosing_qty() {
        return closing_qty;
    }

    public void setClosing_qty(float closing_qty) {
        this.closing_qty = closing_qty;
    }

    public float getScheme_qty() {
        return scheme_qty;
    }

    public void setScheme_qty(float scheme_qty) {
        this.scheme_qty = scheme_qty;
    }

    public float getD1() {
        return d1;
    }

    public void setD1(float d1) {
        this.d1 = d1;
    }

    public float getD2() {
        return d2;
    }

    public void setD2(float d2) {
        this.d2 = d2;
    }

    public float getD3() {
        return d3;
    }

    public void setD3(float d3) {
        this.d3 = d3;
    }

    public float getD4() {
        return d4;
    }

    public void setD4(float d4) {
        this.d4 = d4;
    }

    public float getD5() {
        return d5;
    }

    public void setD5(float d5) {
        this.d5 = d5;
    }

    public float getD6() {
        return d6;
    }

    public void setD6(float d6) {
        this.d6 = d6;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String getT5() {
        return t5;
    }

    public void setT5(String t5) {
        this.t5 = t5;
    }

    public String getT6() {
        return t6;
    }

    public void setT6(String t6) {
        this.t6 = t6;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
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
