package com.hgil.harvest.database.dbModels;

/**
 * Created by mohan.giri on 06-01-2017.
 */

public class PaymentItemModel {

    private long pay_item_id;    //not null
    private String payment_id;
    private float amount;   //not null
    private String pay_type;    //not null
    private String cheque_no;
    private String cheque_date;
    private String bank_id;
    private String bank_branch;
    private float disc_val1, disc_val2, disc_val3;
    private String status;
    private String confirmed_by;
    private String created_by;
    private String payment_ref;
    private String pay_by_date;
    private String realized_date;
    private int appr_status;
    private long appr_id;
    private long invoice_id;
    private String inv_ref;
    private String comments;
    private int state;
    private String ip;
    private String u_ts;    //not null
    
    public String getU_ts() {
        return u_ts;
    }

    public void setU_ts(String u_ts) {
        this.u_ts = u_ts;
    }

    public long getPay_item_id() {
        return pay_item_id;
    }

    public void setPay_item_id(long pay_item_id) {
        this.pay_item_id = pay_item_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getCheque_no() {
        return cheque_no;
    }

    public void setCheque_no(String cheque_no) {
        this.cheque_no = cheque_no;
    }

    public String getCheque_date() {
        return cheque_date;
    }

    public void setCheque_date(String cheque_date) {
        this.cheque_date = cheque_date;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public float getDisc_val1() {
        return disc_val1;
    }

    public void setDisc_val1(float disc_val1) {
        this.disc_val1 = disc_val1;
    }

    public float getDisc_val2() {
        return disc_val2;
    }

    public void setDisc_val2(float disc_val2) {
        this.disc_val2 = disc_val2;
    }

    public float getDisc_val3() {
        return disc_val3;
    }

    public void setDisc_val3(float disc_val3) {
        this.disc_val3 = disc_val3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirmed_by() {
        return confirmed_by;
    }

    public void setConfirmed_by(String confirmed_by) {
        this.confirmed_by = confirmed_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getPayment_ref() {
        return payment_ref;
    }

    public void setPayment_ref(String payment_ref) {
        this.payment_ref = payment_ref;
    }

    public String getPay_by_date() {
        return pay_by_date;
    }

    public void setPay_by_date(String pay_by_date) {
        this.pay_by_date = pay_by_date;
    }

    public String getRealized_date() {
        return realized_date;
    }

    public void setRealized_date(String realized_date) {
        this.realized_date = realized_date;
    }

    public int getAppr_status() {
        return appr_status;
    }

    public void setAppr_status(int appr_status) {
        this.appr_status = appr_status;
    }

    public long getAppr_id() {
        return appr_id;
    }

    public void setAppr_id(long appr_id) {
        this.appr_id = appr_id;
    }

    public long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getInv_ref() {
        return inv_ref;
    }

    public void setInv_ref(String inv_ref) {
        this.inv_ref = inv_ref;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
