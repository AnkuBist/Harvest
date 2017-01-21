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

import com.hgil.harvest.database.dbModels.OrderHeaderDemandModel;

import java.util.ArrayList;

public class OrderHeaderDemandTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_order_header_demand";
    private static final String ORDER_ID = "order_id";
    private static final String BEAT_ID = "beat_id";
    private static final String OUTLET_ID = "outlet_id";
    private static final String BEAT_CODE = "beat_code";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String NET_AMOUNT = "net_amount";
    private static final String ITEM_COUNT = "item_count";
    private static final String ORDER_DATE = "order_date";
    private static final String OWNER_ID = "owner_id";
    private static final String DIST_ID = "dist_id";
    private static final String INVOICE_ID = "invoice_id";
    private static final String DELIVERY_STATUS = "delivery_status";
    private static final String ORDER_TYPE = "order_type";
    private static final String STATUS = "status";
    private static final String GPS_LONG = "gps_long";
    private static final String GPS_LAT = "gps_lat";
    private static final String ORDER_INFO = "order_info";
    private static final String CREATED_AT = "created_at";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";
    private static final String REF_ID = "ref_id";

    public OrderHeaderDemandTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + ORDER_ID + " INTEGER UNIQUE NOT NULL, "
                + BEAT_ID + " INTEGER NULL, " + OUTLET_ID + " INTEGER NULL, " + BEAT_CODE + " TEXT NULL, " + OUTLET_CODE + " TEXT NULL, "
                + NET_AMOUNT + " REAL NOT NULL, " + ITEM_COUNT + " INTEGER NULL, " + ORDER_DATE + " TEXT NULL, " + OWNER_ID + " TEXT NULL, "
                + DIST_ID + " TEXT NULL, " + INVOICE_ID + " TEXT NULL, " + DELIVERY_STATUS + " TEXT NULL, " + ORDER_TYPE + " TEXT NULL, "
                + STATUS + " TEXT NULL, " + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, " + ORDER_INFO + " TEXT NULL, " + CREATED_AT + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL, " + REF_ID + " INTEGER NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOrderHeaderDemand(OrderHeaderDemandModel orderHeaderDemandModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_ID, orderHeaderDemandModel.getOrder_id());
        contentValues.put(BEAT_ID, orderHeaderDemandModel.getBeat_id());
        contentValues.put(OUTLET_ID, orderHeaderDemandModel.getOutlet_id());
        contentValues.put(BEAT_CODE, orderHeaderDemandModel.getBeat_code());
        contentValues.put(OUTLET_CODE, orderHeaderDemandModel.getOutlet_code());
        contentValues.put(NET_AMOUNT, orderHeaderDemandModel.getNet_amount());
        contentValues.put(ITEM_COUNT, orderHeaderDemandModel.getItem_count());
        contentValues.put(ORDER_DATE, orderHeaderDemandModel.getOrder_date());
        contentValues.put(OWNER_ID, orderHeaderDemandModel.getOwner_id());
        contentValues.put(DIST_ID, orderHeaderDemandModel.getDist_id());
        contentValues.put(INVOICE_ID, orderHeaderDemandModel.getInvoice_id());
        contentValues.put(DELIVERY_STATUS, orderHeaderDemandModel.getDelivery_status());
        contentValues.put(ORDER_TYPE, orderHeaderDemandModel.getOrder_type());
        contentValues.put(STATUS, orderHeaderDemandModel.getStatus());
        contentValues.put(GPS_LONG, orderHeaderDemandModel.getGps_long());
        contentValues.put(GPS_LAT, orderHeaderDemandModel.getGps_lat());
        contentValues.put(ORDER_INFO, orderHeaderDemandModel.getOrder_info());
        contentValues.put(CREATED_AT, orderHeaderDemandModel.getCreated_at());
        contentValues.put(STATE, orderHeaderDemandModel.getState());
        contentValues.put(IP, orderHeaderDemandModel.getIp());
        contentValues.put(U_TS, orderHeaderDemandModel.getU_ts());
        contentValues.put(REF_ID, orderHeaderDemandModel.getRef_id());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OrderHeaderDemandModel getOrderHeaderDemandById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ORDER_ID + "=" + id, null);

        OrderHeaderDemandModel orderHeaderDemandModel = new OrderHeaderDemandModel();
        if (res.moveToFirst()) {
            orderHeaderDemandModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
            orderHeaderDemandModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
            orderHeaderDemandModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
            orderHeaderDemandModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            orderHeaderDemandModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            orderHeaderDemandModel.setNet_amount(res.getFloat(res.getColumnIndex(NET_AMOUNT)));
            orderHeaderDemandModel.setItem_count(res.getInt(res.getColumnIndex(ITEM_COUNT)));
            orderHeaderDemandModel.setOrder_date(res.getString(res.getColumnIndex(ORDER_DATE)));
            orderHeaderDemandModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            orderHeaderDemandModel.setDist_id(res.getString(res.getColumnIndex(DIST_ID)));
            orderHeaderDemandModel.setInvoice_id(res.getString(res.getColumnIndex(INVOICE_ID)));
            orderHeaderDemandModel.setDelivery_status(res.getString(res.getColumnIndex(DELIVERY_STATUS)));
            orderHeaderDemandModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
            orderHeaderDemandModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
            orderHeaderDemandModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
            orderHeaderDemandModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
            orderHeaderDemandModel.setOrder_info(res.getString(res.getColumnIndex(ORDER_INFO)));
            orderHeaderDemandModel.setCreated_at(res.getString(res.getColumnIndex(CREATED_AT)));
            orderHeaderDemandModel.setState(res.getInt(res.getColumnIndex(STATE)));
            orderHeaderDemandModel.setIp(res.getString(res.getColumnIndex(IP)));
            orderHeaderDemandModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
            orderHeaderDemandModel.setRef_id(res.getLong(res.getColumnIndex(REF_ID)));
        }
        res.close();
        db.close();
        return orderHeaderDemandModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOrderHeaderDemand(OrderHeaderDemandModel orderHeaderDemandModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEAT_ID, orderHeaderDemandModel.getBeat_id());
        contentValues.put(OUTLET_ID, orderHeaderDemandModel.getOutlet_id());
        contentValues.put(BEAT_CODE, orderHeaderDemandModel.getBeat_code());
        contentValues.put(OUTLET_CODE, orderHeaderDemandModel.getOutlet_code());
        contentValues.put(NET_AMOUNT, orderHeaderDemandModel.getNet_amount());
        contentValues.put(ITEM_COUNT, orderHeaderDemandModel.getItem_count());
        contentValues.put(ORDER_DATE, orderHeaderDemandModel.getOrder_date());
        contentValues.put(OWNER_ID, orderHeaderDemandModel.getOwner_id());
        contentValues.put(DIST_ID, orderHeaderDemandModel.getDist_id());
        contentValues.put(INVOICE_ID, orderHeaderDemandModel.getInvoice_id());
        contentValues.put(DELIVERY_STATUS, orderHeaderDemandModel.getDelivery_status());
        contentValues.put(ORDER_TYPE, orderHeaderDemandModel.getOrder_type());
        contentValues.put(STATUS, orderHeaderDemandModel.getStatus());
        contentValues.put(GPS_LONG, orderHeaderDemandModel.getGps_long());
        contentValues.put(GPS_LAT, orderHeaderDemandModel.getGps_lat());
        contentValues.put(ORDER_INFO, orderHeaderDemandModel.getOrder_info());
        contentValues.put(CREATED_AT, orderHeaderDemandModel.getCreated_at());
        contentValues.put(STATE, orderHeaderDemandModel.getState());
        contentValues.put(IP, orderHeaderDemandModel.getIp());
        contentValues.put(U_TS, orderHeaderDemandModel.getU_ts());
        contentValues.put(REF_ID, orderHeaderDemandModel.getRef_id());
        db.update(TABLE_NAME, contentValues, ORDER_ID + "= ? ", new String[]{Long.toString(orderHeaderDemandModel.getOrder_id())});
        db.close();
        return true;
    }

    public Integer deleteOrderHeaderDemandById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ORDER_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OrderHeaderDemandModel> getAllOrderHeaderDemand() {
        ArrayList<OrderHeaderDemandModel> array_list = new ArrayList<OrderHeaderDemandModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OrderHeaderDemandModel orderHeaderDemandModel = new OrderHeaderDemandModel();
                orderHeaderDemandModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
                orderHeaderDemandModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
                orderHeaderDemandModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
                orderHeaderDemandModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                orderHeaderDemandModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                orderHeaderDemandModel.setNet_amount(res.getFloat(res.getColumnIndex(NET_AMOUNT)));
                orderHeaderDemandModel.setItem_count(res.getInt(res.getColumnIndex(ITEM_COUNT)));
                orderHeaderDemandModel.setOrder_date(res.getString(res.getColumnIndex(ORDER_DATE)));
                orderHeaderDemandModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                orderHeaderDemandModel.setDist_id(res.getString(res.getColumnIndex(DIST_ID)));
                orderHeaderDemandModel.setInvoice_id(res.getString(res.getColumnIndex(INVOICE_ID)));
                orderHeaderDemandModel.setDelivery_status(res.getString(res.getColumnIndex(DELIVERY_STATUS)));
                orderHeaderDemandModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
                orderHeaderDemandModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
                orderHeaderDemandModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
                orderHeaderDemandModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
                orderHeaderDemandModel.setOrder_info(res.getString(res.getColumnIndex(ORDER_INFO)));
                orderHeaderDemandModel.setCreated_at(res.getString(res.getColumnIndex(CREATED_AT)));
                orderHeaderDemandModel.setState(res.getInt(res.getColumnIndex(STATE)));
                orderHeaderDemandModel.setIp(res.getString(res.getColumnIndex(IP)));
                orderHeaderDemandModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
                orderHeaderDemandModel.setRef_id(res.getLong(res.getColumnIndex(REF_ID)));

                array_list.add(orderHeaderDemandModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}