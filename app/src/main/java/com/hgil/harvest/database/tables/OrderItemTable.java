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

import com.hgil.harvest.R;
import com.hgil.harvest.database.dbModels.OrderItemModel;

import java.util.ArrayList;

public class OrderItemTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_order_item";
    private static final String ORDER_ID = "order_id";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String QTY = "qty";
    private static final String FREE_QTY = "free_qty";
    private static final String ITEM_DISC = "item_disc";
    private static final String REP_QTY = "rep_qty";
    private static final String REP_PRICE = "rep_price";
    private static final String MRP = "mrp";
    private static final String ITEM_TIME = "item_time";
    private static final String ITEM_INFO = "item_info";
    private static final String ORDER_TYPE = "order_type";
    private static final String NUM_UNITS = "num_units";
    private static final String BLK1 = "blk1";
    private static final String BLK2 = "blk2";
    private static final String BLK3 = "blk3";
    private static final String BLK4 = "blk4";
    private static final String BLK5 = "blk5";
    private static final String BLK6 = "blk6";
    private static final String BLK7 = "blk7";
    private static final String BLK8 = "blk8";
    private static final String BLK9 = "blk9";
    private static final String BLK10 = "blk10";
    private static final String STATUS = "status";
    private static final String DIST_ID = "dist_id";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public OrderItemTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + ORDER_ID + " INTEGER UNIQUE NOT NULL, "
                + SKU_ID + " INTEGER UNIQUE NOT NULL, " + SKU_CODE + " TEXT NOT NULL, " + QTY + " REAL NOT NULL, " + FREE_QTY + " REAL NULL, "
                + ITEM_DISC + " REAL NOT NULL, " + REP_QTY + " REAL NOT NULL, " + REP_PRICE + " REAL NOT NULL, " + MRP + " REAL NOT NULL, "
                + ITEM_TIME + " TEXT NULL, " + ITEM_INFO + " TEXT NULL, " + ORDER_TYPE + " TEXT NULL, " + NUM_UNITS + " REAL NULL, "
                + BLK1 + " REAL NULL, " + BLK2 + " REAL NULL, " + BLK3 + " REAL NULL, " + BLK4 + " REAL NULL, " + BLK5 + " REAL NULL, "
                + BLK6 + " REAL NULL, " + BLK7 + " REAL NULL, " + BLK8 + " REAL NULL, " + BLK9 + " REAL NULL, " + BLK10 + " REAL NULL, "
                + STATUS + " TEXT NULL, " + DIST_ID + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOrderItem(OrderItemModel orderItemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_ID, orderItemModel.getOrder_id());
        contentValues.put(SKU_ID, orderItemModel.getSku_id());
        contentValues.put(SKU_CODE, orderItemModel.getSku_code());
        contentValues.put(QTY, orderItemModel.getQty());
        contentValues.put(FREE_QTY, orderItemModel.getFree_qty());
        contentValues.put(ITEM_DISC, orderItemModel.getItem_disc());
        contentValues.put(REP_QTY, orderItemModel.getRep_qty());
        contentValues.put(REP_PRICE, orderItemModel.getRep_price());
        contentValues.put(MRP, orderItemModel.getMrp());
        contentValues.put(ITEM_TIME, orderItemModel.getItem_time());
        contentValues.put(ITEM_INFO, orderItemModel.getItem_info());
        contentValues.put(ORDER_TYPE, orderItemModel.getOrder_type());
        contentValues.put(NUM_UNITS, orderItemModel.getNum_units());
        contentValues.put(BLK1, orderItemModel.getBlk1());
        contentValues.put(BLK2, orderItemModel.getBlk2());
        contentValues.put(BLK3, orderItemModel.getBlk3());
        contentValues.put(BLK4, orderItemModel.getBlk4());
        contentValues.put(BLK5, orderItemModel.getBlk5());
        contentValues.put(BLK6, orderItemModel.getBlk6());
        contentValues.put(BLK7, orderItemModel.getBlk7());
        contentValues.put(BLK8, orderItemModel.getBlk8());
        contentValues.put(BLK9, orderItemModel.getBlk9());
        contentValues.put(BLK10, orderItemModel.getBlk10());
        contentValues.put(STATUS, orderItemModel.getStatus());
        contentValues.put(STATE, orderItemModel.getState());
        contentValues.put(IP, orderItemModel.getIp());
        contentValues.put(U_TS, orderItemModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OrderItemModel getOrderItemById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ORDER_ID + "=" + id, null);

        OrderItemModel orderItemModel = new OrderItemModel();
        if (res.moveToFirst()) {
            orderItemModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
            orderItemModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            orderItemModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            orderItemModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
            orderItemModel.setFree_qty(res.getFloat(res.getColumnIndex(FREE_QTY)));
            orderItemModel.setItem_disc(res.getFloat(res.getColumnIndex(ITEM_DISC)));
            orderItemModel.setRep_qty(res.getFloat(res.getColumnIndex(REP_QTY)));
            orderItemModel.setRep_price(res.getFloat(res.getColumnIndex(REP_PRICE)));
            orderItemModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
            orderItemModel.setItem_time(res.getString(res.getColumnIndex(ITEM_TIME)));
            orderItemModel.setItem_info(res.getString(res.getColumnIndex(ITEM_INFO)));
            orderItemModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
            orderItemModel.setNum_units(res.getFloat(res.getColumnIndex(NUM_UNITS)));
            orderItemModel.setBlk1(res.getFloat(res.getColumnIndex(BLK1)));
            orderItemModel.setBlk2(res.getFloat(res.getColumnIndex(BLK2)));
            orderItemModel.setBlk3(res.getFloat(res.getColumnIndex(BLK3)));
            orderItemModel.setBlk4(res.getFloat(res.getColumnIndex(BLK4)));
            orderItemModel.setBlk5(res.getFloat(res.getColumnIndex(BLK5)));
            orderItemModel.setBlk6(res.getFloat(res.getColumnIndex(BLK6)));
            orderItemModel.setBlk7(res.getFloat(res.getColumnIndex(BLK7)));
            orderItemModel.setBlk8(res.getFloat(res.getColumnIndex(BLK8)));
            orderItemModel.setBlk9(res.getFloat(res.getColumnIndex(BLK9)));
            orderItemModel.setBlk10(res.getFloat(res.getColumnIndex(BLK10)));
            orderItemModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
            orderItemModel.setDist_id(res.getString(res.getColumnIndex(DIST_ID)));
            orderItemModel.setState(res.getInt(res.getColumnIndex(STATE)));
            orderItemModel.setIp(res.getString(res.getColumnIndex(IP)));
            orderItemModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return orderItemModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOrderItem(OrderItemModel orderItemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SKU_ID, orderItemModel.getSku_id());
        contentValues.put(SKU_CODE, orderItemModel.getSku_code());
        contentValues.put(QTY, orderItemModel.getQty());
        contentValues.put(FREE_QTY, orderItemModel.getFree_qty());
        contentValues.put(ITEM_DISC, orderItemModel.getItem_disc());
        contentValues.put(REP_QTY, orderItemModel.getRep_qty());
        contentValues.put(REP_PRICE, orderItemModel.getRep_price());
        contentValues.put(MRP, orderItemModel.getMrp());
        contentValues.put(ITEM_TIME, orderItemModel.getItem_time());
        contentValues.put(ITEM_INFO, orderItemModel.getItem_info());
        contentValues.put(ORDER_TYPE, orderItemModel.getOrder_type());
        contentValues.put(NUM_UNITS, orderItemModel.getNum_units());
        contentValues.put(BLK1, orderItemModel.getBlk1());
        contentValues.put(BLK2, orderItemModel.getBlk2());
        contentValues.put(BLK3, orderItemModel.getBlk3());
        contentValues.put(BLK4, orderItemModel.getBlk4());
        contentValues.put(BLK5, orderItemModel.getBlk5());
        contentValues.put(BLK6, orderItemModel.getBlk6());
        contentValues.put(BLK7, orderItemModel.getBlk7());
        contentValues.put(BLK8, orderItemModel.getBlk8());
        contentValues.put(BLK9, orderItemModel.getBlk9());
        contentValues.put(BLK10, orderItemModel.getBlk10());
        contentValues.put(STATUS, orderItemModel.getStatus());
        contentValues.put(STATE, orderItemModel.getState());
        contentValues.put(IP, orderItemModel.getIp());
        contentValues.put(U_TS, orderItemModel.getU_ts());
        db.update(TABLE_NAME, contentValues, ORDER_ID + "= ? ", new String[]{Long.toString(orderItemModel.getOrder_id())});
        db.close();
        return true;
    }

    public Integer deleteOrderItemById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ORDER_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OrderItemModel> getAllOrderItem() {
        ArrayList<OrderItemModel> array_list = new ArrayList<OrderItemModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OrderItemModel orderItemModel = new OrderItemModel();
                orderItemModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
                orderItemModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                orderItemModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                orderItemModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
                orderItemModel.setFree_qty(res.getFloat(res.getColumnIndex(FREE_QTY)));
                orderItemModel.setItem_disc(res.getFloat(res.getColumnIndex(ITEM_DISC)));
                orderItemModel.setRep_qty(res.getFloat(res.getColumnIndex(REP_QTY)));
                orderItemModel.setRep_price(res.getFloat(res.getColumnIndex(REP_PRICE)));
                orderItemModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
                orderItemModel.setItem_time(res.getString(res.getColumnIndex(ITEM_TIME)));
                orderItemModel.setItem_info(res.getString(res.getColumnIndex(ITEM_INFO)));
                orderItemModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
                orderItemModel.setNum_units(res.getFloat(res.getColumnIndex(NUM_UNITS)));
                orderItemModel.setBlk1(res.getFloat(res.getColumnIndex(BLK1)));
                orderItemModel.setBlk2(res.getFloat(res.getColumnIndex(BLK2)));
                orderItemModel.setBlk3(res.getFloat(res.getColumnIndex(BLK3)));
                orderItemModel.setBlk4(res.getFloat(res.getColumnIndex(BLK4)));
                orderItemModel.setBlk5(res.getFloat(res.getColumnIndex(BLK5)));
                orderItemModel.setBlk6(res.getFloat(res.getColumnIndex(BLK6)));
                orderItemModel.setBlk7(res.getFloat(res.getColumnIndex(BLK7)));
                orderItemModel.setBlk8(res.getFloat(res.getColumnIndex(BLK8)));
                orderItemModel.setBlk9(res.getFloat(res.getColumnIndex(BLK9)));
                orderItemModel.setBlk10(res.getFloat(res.getColumnIndex(BLK10)));
                orderItemModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
                orderItemModel.setDist_id(res.getString(res.getColumnIndex(DIST_ID)));
                orderItemModel.setState(res.getInt(res.getColumnIndex(STATE)));
                orderItemModel.setIp(res.getString(res.getColumnIndex(IP)));
                orderItemModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(orderItemModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}