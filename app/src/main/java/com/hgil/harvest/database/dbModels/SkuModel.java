package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class SkuModel {

    private int sku_id; //not null
    private String sku_code;    //not null
    private String name;    //not null
    private float mrp;  //not null
    private String uom; //not null
    private String variant; //not null
    private String sku_desc;
    private String cat, cat1, cat2;
    private float blk1_size, blk2_size, blk3_size, blk4_size, blk5_size, blk6_size, blk7_size, blk8_size, blk9_size, blk10_size;
    private float max_disc;
    private String bar_code;
    private int pos;
    private String tax_code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getSku_desc() {
        return sku_desc;
    }

    public void setSku_desc(String sku_desc) {
        this.sku_desc = sku_desc;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public float getBlk1_size() {
        return blk1_size;
    }

    public void setBlk1_size(float blk1_size) {
        this.blk1_size = blk1_size;
    }

    public float getBlk2_size() {
        return blk2_size;
    }

    public void setBlk2_size(float blk2_size) {
        this.blk2_size = blk2_size;
    }

    public float getBlk3_size() {
        return blk3_size;
    }

    public void setBlk3_size(float blk3_size) {
        this.blk3_size = blk3_size;
    }

    public float getBlk4_size() {
        return blk4_size;
    }

    public void setBlk4_size(float blk4_size) {
        this.blk4_size = blk4_size;
    }

    public float getBlk5_size() {
        return blk5_size;
    }

    public void setBlk5_size(float blk5_size) {
        this.blk5_size = blk5_size;
    }

    public float getBlk6_size() {
        return blk6_size;
    }

    public void setBlk6_size(float blk6_size) {
        this.blk6_size = blk6_size;
    }

    public float getBlk7_size() {
        return blk7_size;
    }

    public void setBlk7_size(float blk7_size) {
        this.blk7_size = blk7_size;
    }

    public float getBlk8_size() {
        return blk8_size;
    }

    public void setBlk8_size(float blk8_size) {
        this.blk8_size = blk8_size;
    }

    public float getBlk9_size() {
        return blk9_size;
    }

    public void setBlk9_size(float blk9_size) {
        this.blk9_size = blk9_size;
    }

    public float getBlk10_size() {
        return blk10_size;
    }

    public void setBlk10_size(float blk10_size) {
        this.blk10_size = blk10_size;
    }

    public float getMax_disc() {
        return max_disc;
    }

    public void setMax_disc(float max_disc) {
        this.max_disc = max_disc;
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
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
