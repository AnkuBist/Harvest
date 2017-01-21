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

import com.hgil.harvest.database.dbModels.PaymentModel;

import java.util.ArrayList;

public class PaymentTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_payment";
    private static final String PAYMENT_ID = "payment_id";
    private static final String OWNER_ID = "owner_id";
    private static final String BEAT_ID = "beat_id";
    private static final String BEAT_CODE = "beat_code";
    private static final String OUTLET_ID = "outlet_id";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String TOTAL_AMOUNT = "total_amount";
    private static final String DISC_VAL1 = "disc_val1";
    private static final String DISC_VAL2 = "disc_val2";
    private static final String DISC_VAL3 = "disc_val3";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String GPS_LONG = "gps_long";
    private static final String GPS_LAT = "gps_lat";
    private static final String CREATED_BY = "created_by";
    private static final String PAYMENT_REF = "payment_ref";
    private static final String RECEIPT_NO = "receipt_no";
    private static final String PAY_DATE = "pay_date";
    private static final String CONFIRMED = "confirmed";
    private static final String CONFIRMED_BY = "confirmed_by";
    private static final String CONFIRMED_ON = "confirmed_on";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public PaymentTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + PAYMENT_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + OWNER_ID + " TEXT NULL, " + BEAT_ID + " INTEGER NULL, " + BEAT_CODE + " TEXT NULL, "
                + OUTLET_ID + " INTEGER NULL, " + OUTLET_CODE + " TEXT NULL, " + TOTAL_AMOUNT + " REAL NULL, "
                + DISC_VAL1 + " REAL NULL, " + DISC_VAL2 + " REAL NULL, " + DISC_VAL3 + " REAL NULL, "
                + PAYMENT_STATUS + " TEXT NULL, " + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, "
                + CREATED_BY + " TEXT NULL, " + PAYMENT_REF + " TEXT NULL, " + RECEIPT_NO + " TEXT NULL, "
                + PAY_DATE + " TEXT NULL, " + CONFIRMED + " INTEGER NULL, " + CONFIRMED_BY + " TEXT NULL, "
                + CONFIRMED_ON + " TEXT NULL, " + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertPayment(PaymentModel paymentModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PAYMENT_ID, paymentModel.getPayment_id());
        contentValues.put(OWNER_ID, paymentModel.getOwner_id());
        contentValues.put(BEAT_ID, paymentModel.getBeat_id());
        contentValues.put(BEAT_CODE, paymentModel.getBeat_code());
        contentValues.put(OUTLET_ID, paymentModel.getOutlet_id());
        contentValues.put(OUTLET_CODE, paymentModel.getOutlet_code());
        contentValues.put(TOTAL_AMOUNT, paymentModel.getTotal_amount());
        contentValues.put(DISC_VAL1, paymentModel.getDisc_val1());
        contentValues.put(DISC_VAL2, paymentModel.getDisc_val2());
        contentValues.put(DISC_VAL3, paymentModel.getDisc_val3());
        contentValues.put(PAYMENT_STATUS, paymentModel.getPayment_status());
        contentValues.put(GPS_LONG, paymentModel.getGps_long());
        contentValues.put(GPS_LAT, paymentModel.getGps_lat());
        contentValues.put(CREATED_BY, paymentModel.getCreated_by());
        contentValues.put(PAYMENT_REF, paymentModel.getPayment_ref());
        contentValues.put(RECEIPT_NO, paymentModel.getReceipt_no());
        contentValues.put(PAY_DATE, paymentModel.getPay_date());
        contentValues.put(CONFIRMED, paymentModel.getConfirmed());
        contentValues.put(CONFIRMED_BY, paymentModel.getConfirmed_by());
        contentValues.put(CONFIRMED_ON, paymentModel.getConfirmed_on());
        contentValues.put(STATE, paymentModel.getState());
        contentValues.put(IP, paymentModel.getIp());
        contentValues.put(U_TS, paymentModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public PaymentModel getPaymentById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + PAYMENT_ID + "=" + id, null);

        PaymentModel paymentModel = new PaymentModel();
        if (res.moveToFirst()) {
            paymentModel.setPayment_id(res.getLong(res.getColumnIndex(PAYMENT_ID)));
            paymentModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            paymentModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
            paymentModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            paymentModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
            paymentModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            paymentModel.setTotal_amount(res.getFloat(res.getColumnIndex(TOTAL_AMOUNT)));
            paymentModel.setDisc_val1(res.getFloat(res.getColumnIndex(DISC_VAL1)));
            paymentModel.setDisc_val2(res.getFloat(res.getColumnIndex(DISC_VAL2)));
            paymentModel.setDisc_val3(res.getFloat(res.getColumnIndex(DISC_VAL3)));
            paymentModel.setPayment_status(res.getString(res.getColumnIndex(PAYMENT_STATUS)));
            paymentModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
            paymentModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
            paymentModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            paymentModel.setPayment_ref(res.getString(res.getColumnIndex(PAYMENT_REF)));
            paymentModel.setReceipt_no(res.getString(res.getColumnIndex(RECEIPT_NO)));
            paymentModel.setPay_date(res.getString(res.getColumnIndex(PAY_DATE)));
            paymentModel.setConfirmed(res.getInt(res.getColumnIndex(CONFIRMED)));
            paymentModel.setConfirmed_by(res.getString(res.getColumnIndex(CONFIRMED_BY)));
            paymentModel.setConfirmed_on(res.getString(res.getColumnIndex(CONFIRMED_ON)));
            paymentModel.setState(res.getInt(res.getColumnIndex(STATE)));
            paymentModel.setIp(res.getString(res.getColumnIndex(IP)));
            paymentModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return paymentModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updatePayment(PaymentModel paymentModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OWNER_ID, paymentModel.getOwner_id());
        contentValues.put(BEAT_ID, paymentModel.getBeat_id());
        contentValues.put(BEAT_CODE, paymentModel.getBeat_code());
        contentValues.put(OUTLET_ID, paymentModel.getOutlet_id());
        contentValues.put(OUTLET_CODE, paymentModel.getOutlet_code());
        contentValues.put(TOTAL_AMOUNT, paymentModel.getTotal_amount());
        contentValues.put(DISC_VAL1, paymentModel.getDisc_val1());
        contentValues.put(DISC_VAL2, paymentModel.getDisc_val2());
        contentValues.put(DISC_VAL3, paymentModel.getDisc_val3());
        contentValues.put(PAYMENT_STATUS, paymentModel.getPayment_status());
        contentValues.put(GPS_LONG, paymentModel.getGps_long());
        contentValues.put(GPS_LAT, paymentModel.getGps_lat());
        contentValues.put(CREATED_BY, paymentModel.getCreated_by());
        contentValues.put(PAYMENT_REF, paymentModel.getPayment_ref());
        contentValues.put(RECEIPT_NO, paymentModel.getReceipt_no());
        contentValues.put(PAY_DATE, paymentModel.getPay_date());
        contentValues.put(CONFIRMED, paymentModel.getConfirmed());
        contentValues.put(CONFIRMED_BY, paymentModel.getConfirmed_by());
        contentValues.put(CONFIRMED_ON, paymentModel.getConfirmed_on());
        contentValues.put(STATE, paymentModel.getState());
        contentValues.put(IP, paymentModel.getIp());
        contentValues.put(U_TS, paymentModel.getU_ts());
        db.update(TABLE_NAME, contentValues, PAYMENT_ID + "= ? ", new String[]{Long.toString(paymentModel.getPayment_id())});
        db.close();
        return true;
    }

    public Integer deletePaymentById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, PAYMENT_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<PaymentModel> getAllPayment() {
        ArrayList<PaymentModel> array_list = new ArrayList<PaymentModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                PaymentModel paymentModel = new PaymentModel();
                paymentModel.setPayment_id(res.getLong(res.getColumnIndex(PAYMENT_ID)));
                paymentModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                paymentModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
                paymentModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                paymentModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
                paymentModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                paymentModel.setTotal_amount(res.getFloat(res.getColumnIndex(TOTAL_AMOUNT)));
                paymentModel.setDisc_val1(res.getFloat(res.getColumnIndex(DISC_VAL1)));
                paymentModel.setDisc_val2(res.getFloat(res.getColumnIndex(DISC_VAL2)));
                paymentModel.setDisc_val3(res.getFloat(res.getColumnIndex(DISC_VAL3)));
                paymentModel.setPayment_status(res.getString(res.getColumnIndex(PAYMENT_STATUS)));
                paymentModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
                paymentModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
                paymentModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                paymentModel.setPayment_ref(res.getString(res.getColumnIndex(PAYMENT_REF)));
                paymentModel.setReceipt_no(res.getString(res.getColumnIndex(RECEIPT_NO)));
                paymentModel.setPay_date(res.getString(res.getColumnIndex(PAY_DATE)));
                paymentModel.setConfirmed(res.getInt(res.getColumnIndex(CONFIRMED)));
                paymentModel.setConfirmed_by(res.getString(res.getColumnIndex(CONFIRMED_BY)));
                paymentModel.setConfirmed_on(res.getString(res.getColumnIndex(CONFIRMED_ON)));
                paymentModel.setState(res.getInt(res.getColumnIndex(STATE)));
                paymentModel.setIp(res.getString(res.getColumnIndex(IP)));
                paymentModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(paymentModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}