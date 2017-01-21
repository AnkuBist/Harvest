package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 05-01-2017.
 */

public class CategoryModel {

    private int category_id;
    private String category_code;
    private String name;
    private int parent_cat;
    private int pos;
    private int state;
    private String ip;
    private String u_ts;

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_cat() {
        return parent_cat;
    }

    public void setParent_cat(int parent_cat) {
        this.parent_cat = parent_cat;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
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
