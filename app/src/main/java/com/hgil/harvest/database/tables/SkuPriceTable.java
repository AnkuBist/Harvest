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

import com.hgil.harvest.database.dbModels.SkuPriceModel;

import java.util.ArrayList;

public class SkuPriceTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_sku_price";
    private static final String PRICE_ID = "price_id";
    private static final String SKU_CODE = "sku_code";
    private static final String LOCATION_CODE = "location_code";
    private static final String MRP = "mrp";
    private static final String MRP_MIN = "mrp_min";
    private static final String MRP_MAX = "mrp_max";
    private static final String START_QTY = "start_qty";
    private static final String END_QTY = "end_qty";
    private static final String MARGIN = "margin";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String TAX_CODE = "tax_code";
    private static final String BATCH_NO = "batch_no";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public SkuPriceTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + PRICE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + SKU_CODE + " TEXT UNIQUE NOT NULL, " + LOCATION_CODE + " TEXT UNIQUE NOT NULL, " + MRP + " REAL NULL, "
                + MRP_MIN + " REAL NULL, " + MRP_MAX + " REAL NULL, " + START_QTY + " REAL UNIQUE NULL, "
                + END_QTY + " REAL NULL, " + MARGIN + " REAL NULL, " + START_DATE + " TEXT UNIQUE NULL, "
                + END_DATE + " TEXT NULL, " + TAX_CODE + " TEXT NULL, " + BATCH_NO + " TEXT UNIQUE NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSkuPrice(SkuPriceModel skuPriceModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRICE_ID, skuPriceModel.getPrice_id());
        contentValues.put(SKU_CODE, skuPriceModel.getSku_code());
        contentValues.put(LOCATION_CODE, skuPriceModel.getLocation_code());
        contentValues.put(MRP, skuPriceModel.getMrp());
        contentValues.put(MRP_MIN, skuPriceModel.getMrp_min());
        contentValues.put(MRP_MAX, skuPriceModel.getMrp_max());
        contentValues.put(START_QTY, skuPriceModel.getStart_qty());
        contentValues.put(END_QTY, skuPriceModel.getEnd_qty());
        contentValues.put(MARGIN, skuPriceModel.getMargin());
        contentValues.put(START_DATE, skuPriceModel.getStart_date());
        contentValues.put(END_DATE, skuPriceModel.getEnd_date());
        contentValues.put(TAX_CODE, skuPriceModel.getTax_code());
        contentValues.put(BATCH_NO, skuPriceModel.getBatch_no());
        contentValues.put(STATE, skuPriceModel.getState());
        contentValues.put(IP, skuPriceModel.getIp());
        contentValues.put(U_TS, skuPriceModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public SkuPriceModel getSkuPriceById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + PRICE_ID + "=" + id, null);

        SkuPriceModel skuPriceModel = new SkuPriceModel();
        if (res.moveToFirst()) {
            skuPriceModel.setPrice_id(res.getInt(res.getColumnIndex(PRICE_ID)));
            skuPriceModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            skuPriceModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
            skuPriceModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
            skuPriceModel.setMrp_min(res.getFloat(res.getColumnIndex(MRP_MIN)));
            skuPriceModel.setMrp_max(res.getFloat(res.getColumnIndex(MRP_MAX)));
            skuPriceModel.setStart_qty(res.getFloat(res.getColumnIndex(START_QTY)));
            skuPriceModel.setEnd_qty(res.getFloat(res.getColumnIndex(END_QTY)));
            skuPriceModel.setMargin(res.getFloat(res.getColumnIndex(MARGIN)));
            skuPriceModel.setStart_date(res.getString(res.getColumnIndex(START_DATE)));
            skuPriceModel.setEnd_date(res.getString(res.getColumnIndex(END_DATE)));
            skuPriceModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
            skuPriceModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
            skuPriceModel.setState(res.getInt(res.getColumnIndex(STATE)));
            skuPriceModel.setIp(res.getString(res.getColumnIndex(IP)));
            skuPriceModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return skuPriceModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateSkuPrice(SkuPriceModel skuPriceModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SKU_CODE, skuPriceModel.getSku_code());
        contentValues.put(LOCATION_CODE, skuPriceModel.getLocation_code());
        contentValues.put(MRP, skuPriceModel.getMrp());
        contentValues.put(MRP_MIN, skuPriceModel.getMrp_min());
        contentValues.put(MRP_MAX, skuPriceModel.getMrp_max());
        contentValues.put(START_QTY, skuPriceModel.getStart_qty());
        contentValues.put(END_QTY, skuPriceModel.getEnd_qty());
        contentValues.put(MARGIN, skuPriceModel.getMargin());
        contentValues.put(START_DATE, skuPriceModel.getStart_date());
        contentValues.put(END_DATE, skuPriceModel.getEnd_date());
        contentValues.put(TAX_CODE, skuPriceModel.getTax_code());
        contentValues.put(BATCH_NO, skuPriceModel.getBatch_no());
        contentValues.put(STATE, skuPriceModel.getState());
        contentValues.put(IP, skuPriceModel.getIp());
        contentValues.put(U_TS, skuPriceModel.getU_ts());
        db.update(TABLE_NAME, contentValues, PRICE_ID + "= ? ", new String[]{Integer.toString(skuPriceModel.getPrice_id())});
        db.close();
        return true;
    }

    public Integer deleteSkuPriceById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, PRICE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<SkuPriceModel> getAllSkuPrice() {
        ArrayList<SkuPriceModel> array_list = new ArrayList<SkuPriceModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                SkuPriceModel skuPriceModel = new SkuPriceModel();
                skuPriceModel.setPrice_id(res.getInt(res.getColumnIndex(PRICE_ID)));
                skuPriceModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                skuPriceModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
                skuPriceModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
                skuPriceModel.setMrp_min(res.getFloat(res.getColumnIndex(MRP_MIN)));
                skuPriceModel.setMrp_max(res.getFloat(res.getColumnIndex(MRP_MAX)));
                skuPriceModel.setStart_qty(res.getFloat(res.getColumnIndex(START_QTY)));
                skuPriceModel.setEnd_qty(res.getFloat(res.getColumnIndex(END_QTY)));
                skuPriceModel.setMargin(res.getFloat(res.getColumnIndex(MARGIN)));
                skuPriceModel.setStart_date(res.getString(res.getColumnIndex(START_DATE)));
                skuPriceModel.setEnd_date(res.getString(res.getColumnIndex(END_DATE)));
                skuPriceModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
                skuPriceModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
                skuPriceModel.setState(res.getInt(res.getColumnIndex(STATE)));
                skuPriceModel.setIp(res.getString(res.getColumnIndex(IP)));
                skuPriceModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(skuPriceModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}