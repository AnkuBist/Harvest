package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 05-01-2017.
 */

public class InvoiceHeaderModel {

    private long invoice_id;
    private long order_id;
    private String owner_id;
    private int beat_id;
    private String beat_code;
    private String ref_id;
    private String inv_id;
    private String inv_date;
    private String inv_to;
    private int item_count;
    private float inv_amount;
    private float paid_amount;
    private float unpaid_amount;
    private float tax;
    private String tax_code;
    private String tax_name;
    private float tax_2;
    private String tax_name_2;
    private float tax_3;
    private String tax_name_3;
    private float tax_4;
    private String tax_name_4;
    private String order_type;
    private String status;
    private String gps_long;
    private String gps_lat;
    private int state;
    private String u_ts;

    public long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
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

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getInv_id() {
        return inv_id;
    }

    public void setInv_id(String inv_id) {
        this.inv_id = inv_id;
    }

    public String getInv_date() {
        return inv_date;
    }

    public void setInv_date(String inv_date) {
        this.inv_date = inv_date;
    }

    public String getInv_to() {
        return inv_to;
    }

    public void setInv_to(String inv_to) {
        this.inv_to = inv_to;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public float getInv_amount() {
        return inv_amount;
    }

    public void setInv_amount(float inv_amount) {
        this.inv_amount = inv_amount;
    }

    public float getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(float paid_amount) {
        this.paid_amount = paid_amount;
    }

    public float getUnpaid_amount() {
        return unpaid_amount;
    }

    public void setUnpaid_amount(float unpaid_amount) {
        this.unpaid_amount = unpaid_amount;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

    public String getTax_name() {
        return tax_name;
    }

    public void setTax_name(String tax_name) {
        this.tax_name = tax_name;
    }

    public float getTax_2() {
        return tax_2;
    }

    public void setTax_2(float tax_2) {
        this.tax_2 = tax_2;
    }

    public String getTax_name_2() {
        return tax_name_2;
    }

    public void setTax_name_2(String tax_name_2) {
        this.tax_name_2 = tax_name_2;
    }

    public float getTax_3() {
        return tax_3;
    }

    public void setTax_3(float tax_3) {
        this.tax_3 = tax_3;
    }

    public String getTax_name_3() {
        return tax_name_3;
    }

    public void setTax_name_3(String tax_name_3) {
        this.tax_name_3 = tax_name_3;
    }

    public float getTax_4() {
        return tax_4;
    }

    public void setTax_4(float tax_4) {
        this.tax_4 = tax_4;
    }

    public String getTax_name_4() {
        return tax_name_4;
    }

    public void setTax_name_4(String tax_name_4) {
        this.tax_name_4 = tax_name_4;
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
