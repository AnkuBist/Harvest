package com.hgil.harvest.database.tables;

/**
 * Created by mohan.giri on 07-01-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hgil.harvest.database.dbModels.StockModel;

import java.util.ArrayList;

public class StockTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_stock";
    private static final String STOCK_ID = "stock_id";
    private static final String SRC_ENTITY = "src_entity";
    private static final String DST_ENTITY = "dst_entity";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String QTY = "qty";
    private static final String MRP = "mrp";
    private static final String REF_MRP = "ref_mrp";
    private static final String REF_TYPE = "ref_type";
    private static final String REF_ID = "ref_id";
    private static final String TRIP_ID = "trip_id";
    private static final String TRIP_REF_ID = "trip_ref_id";
    private static final String DESCRIPTION = "description";
    private static final String STOCK_DATE = "stock_date";
    private static final String OWNER_ID = "owner_id";
    private static final String BEAT_ID = "beat_id";
    private static final String BATCH_NO = "batch_no";
    private static final String STATE = "state";
    private static final String U_TS = "u_ts";

    public StockTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + STOCK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + SRC_ENTITY + " TEXT UNIQUE NOT NULL, " + DST_ENTITY + " TEXT UNIQUE NOT NULL, " + SKU_ID + " INTEGER NOT NULL, "
                + SKU_CODE + " TEXT UNIQUE NOT NULL, " + QTY + " REAL NOT NULL, " + MRP + " REAL NOT NULL, "
                + REF_MRP + " REAL NOT NULL, " + REF_TYPE + " REAL UNIQUE NOT NULL, " + REF_ID + " TEXT UNIQUE NOT NULL, "
                + TRIP_ID + " TEXT NOT NULL, " + TRIP_REF_ID + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NULL, "
                + STOCK_DATE + " TEXT NULL, " + OWNER_ID + " TEXT NULL, " + BEAT_ID + " TEXT NULL, "
                + BATCH_NO + " TEXT NULL, " + STATE + " INTEGER NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertStock(StockModel stockModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STOCK_ID, stockModel.getStock_id());
        contentValues.put(SRC_ENTITY, stockModel.getSrc_entity());
        contentValues.put(DST_ENTITY, stockModel.getDst_entity());
        contentValues.put(SKU_ID, stockModel.getSku_id());
        contentValues.put(SKU_CODE, stockModel.getSku_code());
        contentValues.put(QTY, stockModel.getQty());
        contentValues.put(MRP, stockModel.getMrp());
        contentValues.put(REF_MRP, stockModel.getRef_mrp());
        contentValues.put(REF_TYPE, stockModel.getRef_type());
        contentValues.put(REF_ID, stockModel.getRef_id());
        contentValues.put(TRIP_ID, stockModel.getTrip_id());
        contentValues.put(TRIP_REF_ID, stockModel.getTrip_ref_id());
        contentValues.put(DESCRIPTION, stockModel.getDescription());
        contentValues.put(STOCK_DATE, stockModel.getStock_date());
        contentValues.put(OWNER_ID, stockModel.getOwner_id());
        contentValues.put(BEAT_ID, stockModel.getBeat_id());
        contentValues.put(BATCH_NO, stockModel.getBatch_no());
        contentValues.put(STATE, stockModel.getState());
        contentValues.put(U_TS, stockModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public StockModel getStockById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + STOCK_ID + "=" + id, null);

        StockModel stockModel = new StockModel();
        if (res.moveToFirst()) {
            stockModel.setStock_id(res.getLong(res.getColumnIndex(STOCK_ID)));
            stockModel.setSrc_entity(res.getString(res.getColumnIndex(SRC_ENTITY)));
            stockModel.setDst_entity(res.getString(res.getColumnIndex(DST_ENTITY)));
            stockModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            stockModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            stockModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
            stockModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
            stockModel.setRef_mrp(res.getFloat(res.getColumnIndex(REF_MRP)));
            stockModel.setRef_type(res.getFloat(res.getColumnIndex(REF_TYPE)));
            stockModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
            stockModel.setTrip_id(res.getString(res.getColumnIndex(TRIP_ID)));
            stockModel.setTrip_ref_id(res.getString(res.getColumnIndex(TRIP_REF_ID)));
            stockModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            stockModel.setStock_date(res.getString(res.getColumnIndex(STOCK_DATE)));
            stockModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            stockModel.setBeat_id(res.getString(res.getColumnIndex(BEAT_ID)));
            stockModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
            stockModel.setState(res.getInt(res.getColumnIndex(STATE)));
            stockModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return stockModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateStock(StockModel stockModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SRC_ENTITY, stockModel.getSrc_entity());
        contentValues.put(DST_ENTITY, stockModel.getDst_entity());
        contentValues.put(SKU_ID, stockModel.getSku_id());
        contentValues.put(SKU_CODE, stockModel.getSku_code());
        contentValues.put(QTY, stockModel.getQty());
        contentValues.put(MRP, stockModel.getMrp());
        contentValues.put(REF_MRP, stockModel.getRef_mrp());
        contentValues.put(REF_TYPE, stockModel.getRef_type());
        contentValues.put(REF_ID, stockModel.getRef_id());
        contentValues.put(TRIP_ID, stockModel.getTrip_id());
        contentValues.put(TRIP_REF_ID, stockModel.getTrip_ref_id());
        contentValues.put(DESCRIPTION, stockModel.getDescription());
        contentValues.put(STOCK_DATE, stockModel.getStock_date());
        contentValues.put(OWNER_ID, stockModel.getOwner_id());
        contentValues.put(BEAT_ID, stockModel.getBeat_id());
        contentValues.put(BATCH_NO, stockModel.getBatch_no());
        contentValues.put(STATE, stockModel.getState());
        contentValues.put(U_TS, stockModel.getU_ts());
        db.update(TABLE_NAME, contentValues, STOCK_ID + "= ? ", new String[]{Long.toString(stockModel.getStock_id())});
        db.close();
        return true;
    }

    public Integer deleteStockById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, STOCK_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<StockModel> getAllStock() {
        ArrayList<StockModel> array_list = new ArrayList<StockModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                StockModel stockModel = new StockModel();
                stockModel.setStock_id(res.getLong(res.getColumnIndex(STOCK_ID)));
                stockModel.setSrc_entity(res.getString(res.getColumnIndex(SRC_ENTITY)));
                stockModel.setDst_entity(res.getString(res.getColumnIndex(DST_ENTITY)));
                stockModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                stockModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                stockModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
                stockModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
                stockModel.setRef_mrp(res.getFloat(res.getColumnIndex(REF_MRP)));
                stockModel.setRef_type(res.getFloat(res.getColumnIndex(REF_TYPE)));
                stockModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
                stockModel.setTrip_id(res.getString(res.getColumnIndex(TRIP_ID)));
                stockModel.setTrip_ref_id(res.getString(res.getColumnIndex(TRIP_REF_ID)));
                stockModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                stockModel.setStock_date(res.getString(res.getColumnIndex(STOCK_DATE)));
                stockModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                stockModel.setBeat_id(res.getString(res.getColumnIndex(BEAT_ID)));
                stockModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
                stockModel.setState(res.getInt(res.getColumnIndex(STATE)));
                stockModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(stockModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}