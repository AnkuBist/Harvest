package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class OcModel {

    private int oc_id;
    private String email;
    private String desig;
    private String rep_to;
    private String oc_code;
    private int state;
    private String ip;
    private String u_ts;

    public int getOc_id() {
        return oc_id;
    }

    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getRep_to() {
        return rep_to;
    }

    public void setRep_to(String rep_to) {
        this.rep_to = rep_to;
    }

    public String getOc_code() {
        return oc_code;
    }

    public void setOc_code(String oc_code) {
        this.oc_code = oc_code;
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
