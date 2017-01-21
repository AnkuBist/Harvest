package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 05-01-2017.
 */

public class InvoiceItemModel {

    private long invoice_item_id;
    private long invoice_id;
    private int sku_id;
    private String sku_code;
    private String sku_name;
    private float mrp;
    private float qty;
    private float free_qty;
    private float rep_qty;
    private float rep_price;
    private float item_disc;
    private String item_time;
    private String item_info;
    private float amount;
    private float tax;
    private String tax_code, tax_name;
    private float tax_2;
    private String tax_name_2;
    private float tax_3;
    private String tax_name_3;
    private float tax_4;
    private String tax_name_4;
    private float tax_5;
    private String tax_name_5;
    private float tax_6;
    private String tax_name_6;
    private float tax_7;
    private String tax_name_7;
    private float tax_8;
    private String tax_name_8;
    private float tax_9;
    private String tax_name_9;
    private float tax_10;
    private String tax_name_10;
    private String order_type;
    private long order_id;
    private String batch_no;
    private String status;
    private int state;
    private String u_ts;
    
    public long getInvoice_item_id() {
        return invoice_item_id;
    }

    public void setInvoice_item_id(long invoice_item_id) {
        this.invoice_item_id = invoice_item_id;
    }

    public long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(long invoice_id) {
        this.invoice_id = invoice_id;
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

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
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

    public float getItem_disc() {
        return item_disc;
    }

    public void setItem_disc(float item_disc) {
        this.item_disc = item_disc;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    public float getTax_5() {
        return tax_5;
    }

    public void setTax_5(float tax_5) {
        this.tax_5 = tax_5;
    }

    public String getTax_name_5() {
        return tax_name_5;
    }

    public void setTax_name_5(String tax_name_5) {
        this.tax_name_5 = tax_name_5;
    }

    public float getTax_6() {
        return tax_6;
    }

    public void setTax_6(float tax_6) {
        this.tax_6 = tax_6;
    }

    public String getTax_name_6() {
        return tax_name_6;
    }

    public void setTax_name_6(String tax_name_6) {
        this.tax_name_6 = tax_name_6;
    }

    public float getTax_7() {
        return tax_7;
    }

    public void setTax_7(float tax_7) {
        this.tax_7 = tax_7;
    }

    public String getTax_name_7() {
        return tax_name_7;
    }

    public void setTax_name_7(String tax_name_7) {
        this.tax_name_7 = tax_name_7;
    }

    public float getTax_8() {
        return tax_8;
    }

    public void setTax_8(float tax_8) {
        this.tax_8 = tax_8;
    }

    public String getTax_name_8() {
        return tax_name_8;
    }

    public void setTax_name_8(String tax_name_8) {
        this.tax_name_8 = tax_name_8;
    }

    public float getTax_9() {
        return tax_9;
    }

    public void setTax_9(float tax_9) {
        this.tax_9 = tax_9;
    }

    public String getTax_name_9() {
        return tax_name_9;
    }

    public void setTax_name_9(String tax_name_9) {
        this.tax_name_9 = tax_name_9;
    }

    public float getTax_10() {
        return tax_10;
    }

    public void setTax_10(float tax_10) {
        this.tax_10 = tax_10;
    }

    public String getTax_name_10() {
        return tax_name_10;
    }

    public void setTax_name_10(String tax_name_10) {
        this.tax_name_10 = tax_name_10;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
