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

import com.hgil.harvest.database.dbModels.OrderSchemeModel;

import java.util.ArrayList;

public class OrderSchemeTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_order_scheme";
    private static final String ORDER_ID = "order_id";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String SCHEME_ID = "scheme_id";
    private static final String FREE_SCHEME_ID = "free_scheme_id";
    private static final String IS_INVOICE = "is_invoice";
    private static final String TYPE = "type";
    private static final String DISC_COUNT = "disc_count";
    private static final String DISC_VALUE = "disc_value";
    private static final String DISC_DESC = "disc_desc";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public OrderSchemeTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + ORDER_ID + " INTEGER UNIQUE NOT NULL, "
                + SKU_ID + " INTEGER UNIQUE NULL, " + SKU_CODE + " TEXT NULL, " + SCHEME_ID + " INTEGER UNIQUE NULL, " + FREE_SCHEME_ID + " INTEGER NULL, "
                + IS_INVOICE + " INTEGER UNIQUE NOT NULL, " + TYPE + " INTEGER NULL, " + DISC_COUNT + " REAL NULL, " + DISC_VALUE + " REAL NULL, "
                + DISC_DESC + " TEXT NULL, " + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOrderScheme(OrderSchemeModel orderSchemeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_ID, orderSchemeModel.getOrder_id());
        contentValues.put(SKU_ID, orderSchemeModel.getSku_id());
        contentValues.put(SKU_CODE, orderSchemeModel.getSku_code());
        contentValues.put(SCHEME_ID, orderSchemeModel.getScheme_id());
        contentValues.put(FREE_SCHEME_ID, orderSchemeModel.getFree_scheme_id());
        contentValues.put(IS_INVOICE, orderSchemeModel.getIs_invoice());
        contentValues.put(TYPE, orderSchemeModel.getType());
        contentValues.put(DISC_COUNT, orderSchemeModel.getDisc_count());
        contentValues.put(DISC_VALUE, orderSchemeModel.getDisc_value());
        contentValues.put(DISC_DESC, orderSchemeModel.getDisc_desc());
        contentValues.put(STATE, orderSchemeModel.getState());
        contentValues.put(IP, orderSchemeModel.getIp());
        contentValues.put(U_TS, orderSchemeModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OrderSchemeModel getOrderSchemeById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ORDER_ID + "=" + id, null);

        OrderSchemeModel orderSchemeModel = new OrderSchemeModel();
        if (res.moveToFirst()) {
            orderSchemeModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
            orderSchemeModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            orderSchemeModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            orderSchemeModel.setScheme_id(res.getInt(res.getColumnIndex(SCHEME_ID)));
            orderSchemeModel.setFree_scheme_id(res.getLong(res.getColumnIndex(FREE_SCHEME_ID)));
            orderSchemeModel.setIs_invoice(res.getInt(res.getColumnIndex(IS_INVOICE)));
            orderSchemeModel.setType(res.getInt(res.getColumnIndex(TYPE)));
            orderSchemeModel.setDisc_count(res.getFloat(res.getColumnIndex(DISC_COUNT)));
            orderSchemeModel.setDisc_value(res.getFloat(res.getColumnIndex(DISC_VALUE)));
            orderSchemeModel.setDisc_desc(res.getString(res.getColumnIndex(DISC_DESC)));
            orderSchemeModel.setState(res.getInt(res.getColumnIndex(STATE)));
            orderSchemeModel.setIp(res.getString(res.getColumnIndex(IP)));
            orderSchemeModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return orderSchemeModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOrderScheme(OrderSchemeModel orderSchemeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SKU_ID, orderSchemeModel.getSku_id());
        contentValues.put(SKU_CODE, orderSchemeModel.getSku_code());
        contentValues.put(SCHEME_ID, orderSchemeModel.getScheme_id());
        contentValues.put(FREE_SCHEME_ID, orderSchemeModel.getFree_scheme_id());
        contentValues.put(IS_INVOICE, orderSchemeModel.getIs_invoice());
        contentValues.put(TYPE, orderSchemeModel.getType());
        contentValues.put(DISC_COUNT, orderSchemeModel.getDisc_count());
        contentValues.put(DISC_VALUE, orderSchemeModel.getDisc_value());
        contentValues.put(DISC_DESC, orderSchemeModel.getDisc_desc());
        contentValues.put(STATE, orderSchemeModel.getState());
        contentValues.put(IP, orderSchemeModel.getIp());
        contentValues.put(U_TS, orderSchemeModel.getU_ts());
        db.update(TABLE_NAME, contentValues, ORDER_ID + "= ? ", new String[]{Long.toString(orderSchemeModel.getOrder_id())});
        db.close();
        return true;
    }

    public Integer deleteOrderSchemeById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ORDER_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OrderSchemeModel> getAllOrderScheme() {
        ArrayList<OrderSchemeModel> array_list = new ArrayList<OrderSchemeModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OrderSchemeModel orderSchemeModel = new OrderSchemeModel();
                orderSchemeModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
                orderSchemeModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                orderSchemeModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                orderSchemeModel.setScheme_id(res.getInt(res.getColumnIndex(SCHEME_ID)));
                orderSchemeModel.setFree_scheme_id(res.getLong(res.getColumnIndex(FREE_SCHEME_ID)));
                orderSchemeModel.setIs_invoice(res.getInt(res.getColumnIndex(IS_INVOICE)));
                orderSchemeModel.setType(res.getInt(res.getColumnIndex(TYPE)));
                orderSchemeModel.setDisc_count(res.getFloat(res.getColumnIndex(DISC_COUNT)));
                orderSchemeModel.setDisc_value(res.getFloat(res.getColumnIndex(DISC_VALUE)));
                orderSchemeModel.setDisc_desc(res.getString(res.getColumnIndex(DISC_DESC)));
                orderSchemeModel.setState(res.getInt(res.getColumnIndex(STATE)));
                orderSchemeModel.setIp(res.getString(res.getColumnIndex(IP)));
                orderSchemeModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(orderSchemeModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}