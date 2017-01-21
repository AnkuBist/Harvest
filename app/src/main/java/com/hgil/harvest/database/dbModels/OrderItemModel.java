package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class OrderItemModel {

    private long order_id;
    private int sku_id;
    private String sku_code;
    private float qty;
    private float free_qty;
    private float item_disc;
    private float rep_qty;
    private float rep_price;
    private float mrp;
    private String item_time;
    private String item_info;
    private String order_type;
    private float num_units;
    private float blk1, blk2, blk3, blk4, blk5, blk6, blk7, blk8, blk9, blk10;
    private String status;
    private String dist_id;
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

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getFree_qty() {
        return free_qty;
    }

    public void setFree_qty(float free_qty) {
        this.free_qty = free_qty;
    }

    public float getItem_disc() {
        return item_disc;
    }

    public void setItem_disc(float item_disc) {
        this.item_disc = item_disc;
    }

    public float getRep_qty() {
        return rep_qty;
    }

    public void setRep_qty(float rep_qty) {
        this.rep_qty = rep_qty;
    }

    public float getRep_price() {
        return rep_price;
    }

    public void setRep_price(float rep_price) {
        this.rep_price = rep_price;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    public String getItem_time() {
        return item_time;
    }

    public void setItem_time(String item_time) {
        this.item_time = item_time;
    }

    public String getItem_info() {
        return item_info;
    }

    public void setItem_info(String item_info) {
        this.item_info = item_info;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public float getNum_units() {
        return num_units;
    }

    public void setNum_units(float num_units) {
        this.num_units = num_units;
    }

    public float getBlk1() {
        return blk1;
    }

    public void setBlk1(float blk1) {
        this.blk1 = blk1;
    }

    public float getBlk2() {
        return blk2;
    }

    public void setBlk2(float blk2) {
        this.blk2 = blk2;
    }

    public float getBlk3() {
        return blk3;
    }

    public void setBlk3(float blk3) {
        this.blk3 = blk3;
    }

    public float getBlk4() {
        return blk4;
    }

    public void setBlk4(float blk4) {
        this.blk4 = blk4;
    }

    public float getBlk5() {
        return blk5;
    }

    public void setBlk5(float blk5) {
        this.blk5 = blk5;
    }

    public float getBlk6() {
        return blk6;
    }

    public void setBlk6(float blk6) {
        this.blk6 = blk6;
    }

    public float getBlk7() {
        return blk7;
    }

    public void setBlk7(float blk7) {
        this.blk7 = blk7;
    }

    public float getBlk8() {
        return blk8;
    }

    public void setBlk8(float blk8) {
        this.blk8 = blk8;
    }

    public float getBlk9() {
        return blk9;
    }

    public void setBlk9(float blk9) {
        this.blk9 = blk9;
    }

    public float getBlk10() {
        return blk10;
    }

    public void setBlk10(float blk10) {
        this.blk10 = blk10;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDist_id() {
        return dist_id;
    }

    public void setDist_id(String dist_id) {
        this.dist_id = dist_id;
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
