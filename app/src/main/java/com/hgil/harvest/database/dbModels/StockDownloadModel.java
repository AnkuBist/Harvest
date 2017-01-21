package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 07-01-2017.
 */

public class StockDownloadModel {

    private long stock_id;
    private String src_entity;
    private String dst_entity;
    private int sku_id;
    private String sku_code;
    private float qty;
    private float mrp;
    private float ref_mrp;
    private float ref_type;
    private String ref_id;
    private String trip_id;
    private String trip_ref_id;
    private String description; //null
    private String stock_date;  //null
    private String owner_id;    //null
    private String beat_id;     //null
    private String batch_no;    //null
    private int state;          //null
    private String u_ts;

    public long getStock_id() {
        return stock_id;
    }

    public void setStock_id(long stock_id) {
        this.stock_id = stock_id;
    }

    public String getSrc_entity() {
        return src_entity;
    }

    public void setSrc_entity(String src_entity) {
        this.src_entity = src_entity;
    }

    public String getDst_entity() {
        return dst_entity;
    }

    public void setDst_entity(String dst_entity) {
        this.dst_entity = dst_entity;
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

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    public float getRef_mrp() {
        return ref_mrp;
    }

    public void setRef_mrp(float ref_mrp) {
        this.ref_mrp = ref_mrp;
    }

    public float getRef_type() {
        return ref_type;
    }

    public void setRef_type(float ref_type) {
        this.ref_type = ref_type;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_ref_id() {
        return trip_ref_id;
    }

    public void setTrip_ref_id(String trip_ref_id) {
        this.trip_ref_id = trip_ref_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock_date() {
        return stock_date;
    }

    public void setStock_date(String stock_date) {
        this.stock_date = stock_date;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getBeat_id() {
        return beat_id;
    }

    public void setBeat_id(String beat_id) {
        this.beat_id = beat_id;
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

    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }
}
