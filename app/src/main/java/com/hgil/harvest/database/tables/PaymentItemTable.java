package com.hgil.harvest.database.tables;

/**
 * Created by mohan.giri on 06-01-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hgil.harvest.database.dbModels.PaymentItemModel;

import java.util.ArrayList;

public class PaymentItemTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_payment_item";
    private static final String PAY_ITEM_ID = "pay_item_id";
    private static final String PAYMENT_ID = "payment_id";
    private static final String AMOUNT = "amount";
    private static final String PAY_TYPE = "pay_type";
    private static final String CHEQUE_NO = "cheque_no";
    private static final String CHEQUE_DATE = "cheque_date";
    private static final String BANK_ID = "bank_id";
    private static final String BANK_BRANCH = "bank_branch";
    private static final String DISC_VAL1 = "disc_val1";
    private static final String DISC_VAL2 = "disc_val2";
    private static final String DISC_VAL3 = "disc_val3";
    private static final String STATUS = "status";
    private static final String CONFIRMED_BY = "confirmed_by";
    private static final String CREATED_BY = "created_by";
    private static final String PAYMENT_REF = "payment_ref";
    private static final String PAY_BY_DATE = "pay_by_date";
    private static final String REALIZED_DATE = "realized_date";
    private static final String APPR_STATUS = "appr_status";
    private static final String APPR_ID = "appr_id";
    private static final String INVOICE_ID = "invoice_id";
    private static final String INV_REF = "inv_ref";
    private static final String COMMENTS = "comments";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public PaymentItemTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + PAY_ITEM_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + PAYMENT_ID + " TEXT NULL, " + AMOUNT + " INTEGER NOT NULL, " + PAY_TYPE + " TEXT NOT NULL, "
                + CHEQUE_NO + " TEXT NULL, " + CHEQUE_DATE + " TEXT NULL, " + BANK_ID + " TEXT NULL, "
                + BANK_BRANCH + " TEXT NULL, " + DISC_VAL1 + " REAL NULL, " + DISC_VAL2 + " REAL NULL, " + DISC_VAL3 + " REAL NULL, "
                + STATUS + " TEXT NULL, " + CONFIRMED_BY + " TEXT NULL, " + CREATED_BY + " TEXT NULL, " + PAYMENT_REF + " TEXT NULL, "
                + PAY_BY_DATE + " TEXT NULL, " + REALIZED_DATE + " TEXT NULL, " + APPR_STATUS + " INTEGER NULL, "
                + APPR_ID + " INTEGER NULL, " + INVOICE_ID + " INTEGER NULL, " + INV_REF + " TEXT NULL, "
                + COMMENTS + " TEXT NULL, " + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertPaymentItem(PaymentItemModel paymentItemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PAY_ITEM_ID, paymentItemModel.getPay_item_id());
        contentValues.put(PAYMENT_ID, paymentItemModel.getPayment_id());
        contentValues.put(AMOUNT, paymentItemModel.getAmount());
        contentValues.put(PAY_TYPE, paymentItemModel.getPay_type());
        contentValues.put(CHEQUE_NO, paymentItemModel.getCheque_no());
        contentValues.put(CHEQUE_DATE, paymentItemModel.getCheque_date());
        contentValues.put(BANK_ID, paymentItemModel.getBank_id());
        contentValues.put(BANK_BRANCH, paymentItemModel.getBank_branch());
        contentValues.put(DISC_VAL1, paymentItemModel.getDisc_val1());
        contentValues.put(DISC_VAL2, paymentItemModel.getDisc_val2());
        contentValues.put(DISC_VAL3, paymentItemModel.getDisc_val3());
        contentValues.put(STATUS, paymentItemModel.getStatus());
        contentValues.put(CONFIRMED_BY, paymentItemModel.getConfirmed_by());
        contentValues.put(CREATED_BY, paymentItemModel.getCreated_by());
        contentValues.put(PAYMENT_REF, paymentItemModel.getPayment_ref());
        contentValues.put(PAY_BY_DATE, paymentItemModel.getPay_by_date());
        contentValues.put(REALIZED_DATE, paymentItemModel.getRealized_date());
        contentValues.put(APPR_STATUS, paymentItemModel.getAppr_status());
        contentValues.put(APPR_ID, paymentItemModel.getAppr_id());
        contentValues.put(INVOICE_ID, paymentItemModel.getInvoice_id());
        contentValues.put(INV_REF, paymentItemModel.getInv_ref());
        contentValues.put(COMMENTS, paymentItemModel.getComments());
        contentValues.put(STATE, paymentItemModel.getState());
        contentValues.put(IP, paymentItemModel.getIp());
        contentValues.put(U_TS, paymentItemModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public PaymentItemModel getPaymentItemById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + PAY_ITEM_ID + "=" + id, null);

        PaymentItemModel paymentItemModel = new PaymentItemModel();
        if (res.moveToFirst()) {
            paymentItemModel.setPay_item_id(res.getLong(res.getColumnIndex(PAY_ITEM_ID)));
            paymentItemModel.setPayment_id(res.getString(res.getColumnIndex(PAYMENT_ID)));
            paymentItemModel.setAmount(res.getFloat(res.getColumnIndex(AMOUNT)));
            paymentItemModel.setPay_type(res.getString(res.getColumnIndex(PAY_TYPE)));
            paymentItemModel.setCheque_no(res.getString(res.getColumnIndex(CHEQUE_NO)));
            paymentItemModel.setCheque_date(res.getString(res.getColumnIndex(CHEQUE_DATE)));
            paymentItemModel.setBank_id(res.getString(res.getColumnIndex(BANK_ID)));
            paymentItemModel.setBank_branch(res.getString(res.getColumnIndex(BANK_BRANCH)));
            paymentItemModel.setDisc_val1(res.getFloat(res.getColumnIndex(DISC_VAL1)));
            paymentItemModel.setDisc_val2(res.getFloat(res.getColumnIndex(DISC_VAL2)));
            paymentItemModel.setDisc_val3(res.getFloat(res.getColumnIndex(DISC_VAL3)));
            paymentItemModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
            paymentItemModel.setConfirmed_by(res.getString(res.getColumnIndex(CONFIRMED_BY)));
            paymentItemModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            paymentItemModel.setPayment_ref(res.getString(res.getColumnIndex(PAYMENT_REF)));
            paymentItemModel.setPay_by_date(res.getString(res.getColumnIndex(PAY_BY_DATE)));
            paymentItemModel.setRealized_date(res.getString(res.getColumnIndex(REALIZED_DATE)));
            paymentItemModel.setAppr_status(res.getInt(res.getColumnIndex(APPR_STATUS)));
            paymentItemModel.setAppr_id(res.getLong(res.getColumnIndex(APPR_ID)));
            paymentItemModel.setInvoice_id(res.getLong(res.getColumnIndex(INVOICE_ID)));
            paymentItemModel.setInv_ref(res.getString(res.getColumnIndex(INV_REF)));
            paymentItemModel.setComments(res.getString(res.getColumnIndex(COMMENTS)));
            paymentItemModel.setState(res.getInt(res.getColumnIndex(STATE)));
            paymentItemModel.setIp(res.getString(res.getColumnIndex(IP)));
            paymentItemModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return paymentItemModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updatePaymentItem(PaymentItemModel paymentItemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PAYMENT_ID, paymentItemModel.getPayment_id());
        contentValues.put(AMOUNT, paymentItemModel.getAmount());
        contentValues.put(PAY_TYPE, paymentItemModel.getPay_type());
        contentValues.put(CHEQUE_NO, paymentItemModel.getCheque_no());
        contentValues.put(CHEQUE_DATE, paymentItemModel.getCheque_date());
        contentValues.put(BANK_ID, paymentItemModel.getBank_id());
        contentValues.put(BANK_BRANCH, paymentItemModel.getBank_branch());
        contentValues.put(DISC_VAL1, paymentItemModel.getDisc_val1());
        contentValues.put(DISC_VAL2, paymentItemModel.getDisc_val2());
        contentValues.put(DISC_VAL3, paymentItemModel.getDisc_val3());
        contentValues.put(STATUS, paymentItemModel.getStatus());
        contentValues.put(CONFIRMED_BY, paymentItemModel.getConfirmed_by());
        contentValues.put(CREATED_BY, paymentItemModel.getCreated_by());
        contentValues.put(PAYMENT_REF, paymentItemModel.getPayment_ref());
        contentValues.put(PAY_BY_DATE, paymentItemModel.getPay_by_date());
        contentValues.put(REALIZED_DATE, paymentItemModel.getRealized_date());
        contentValues.put(APPR_STATUS, paymentItemModel.getAppr_status());
        contentValues.put(APPR_ID, paymentItemModel.getAppr_id());
        contentValues.put(INVOICE_ID, paymentItemModel.getInvoice_id());
        contentValues.put(INV_REF, paymentItemModel.getInv_ref());
        contentValues.put(COMMENTS, paymentItemModel.getComments());
        contentValues.put(STATE, paymentItemModel.getState());
        contentValues.put(IP, paymentItemModel.getIp());
        contentValues.put(U_TS, paymentItemModel.getU_ts());
        db.update(TABLE_NAME, contentValues, PAY_ITEM_ID + "= ? ", new String[]{Long.toString(paymentItemModel.getPay_item_id())});
        db.close();
        return true;
    }

    public Integer deletePaymentItemById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, PAY_ITEM_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<PaymentItemModel> getAllPaymentItem() {
        ArrayList<PaymentItemModel> array_list = new ArrayList<PaymentItemModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                PaymentItemModel paymentItemModel = new PaymentItemModel();
                paymentItemModel.setPay_item_id(res.getLong(res.getColumnIndex(PAY_ITEM_ID)));
                paymentItemModel.setPayment_id(res.getString(res.getColumnIndex(PAYMENT_ID)));
                paymentItemModel.setAmount(res.getFloat(res.getColumnIndex(AMOUNT)));
                paymentItemModel.setPay_type(res.getString(res.getColumnIndex(PAY_TYPE)));
                paymentItemModel.setCheque_no(res.getString(res.getColumnIndex(CHEQUE_NO)));
                paymentItemModel.setCheque_date(res.getString(res.getColumnIndex(CHEQUE_DATE)));
                paymentItemModel.setBank_id(res.getString(res.getColumnIndex(BANK_ID)));
                paymentItemModel.setBank_branch(res.getString(res.getColumnIndex(BANK_BRANCH)));
                paymentItemModel.setDisc_val1(res.getFloat(res.getColumnIndex(DISC_VAL1)));
                paymentItemModel.setDisc_val2(res.getFloat(res.getColumnIndex(DISC_VAL2)));
                paymentItemModel.setDisc_val3(res.getFloat(res.getColumnIndex(DISC_VAL3)));
                paymentItemModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
                paymentItemModel.setConfirmed_by(res.getString(res.getColumnIndex(CONFIRMED_BY)));
                paymentItemModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                paymentItemModel.setPayment_ref(res.getString(res.getColumnIndex(PAYMENT_REF)));
                paymentItemModel.setPay_by_date(res.getString(res.getColumnIndex(PAY_BY_DATE)));
                paymentItemModel.setRealized_date(res.getString(res.getColumnIndex(REALIZED_DATE)));
                paymentItemModel.setAppr_status(res.getInt(res.getColumnIndex(APPR_STATUS)));
                paymentItemModel.setAppr_id(res.getLong(res.getColumnIndex(APPR_ID)));
                paymentItemModel.setInvoice_id(res.getLong(res.getColumnIndex(INVOICE_ID)));
                paymentItemModel.setInv_ref(res.getString(res.getColumnIndex(INV_REF)));
                paymentItemModel.setComments(res.getString(res.getColumnIndex(COMMENTS)));
                paymentItemModel.setState(res.getInt(res.getColumnIndex(STATE)));
                paymentItemModel.setIp(res.getString(res.getColumnIndex(IP)));
                paymentItemModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(paymentItemModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}