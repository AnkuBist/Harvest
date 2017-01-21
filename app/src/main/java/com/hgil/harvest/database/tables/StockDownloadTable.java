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

import com.hgil.harvest.database.dbModels.StockDownloadModel;

import java.util.ArrayList;

public class StockDownloadTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_stock_download";
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

    public StockDownloadTable(Context context) {
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

    public boolean insertStockDownload(StockDownloadModel stockDownloadModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STOCK_ID, stockDownloadModel.getStock_id());
        contentValues.put(SRC_ENTITY, stockDownloadModel.getSrc_entity());
        contentValues.put(DST_ENTITY, stockDownloadModel.getDst_entity());
        contentValues.put(SKU_ID, stockDownloadModel.getSku_id());
        contentValues.put(SKU_CODE, stockDownloadModel.getSku_code());
        contentValues.put(QTY, stockDownloadModel.getQty());
        contentValues.put(MRP, stockDownloadModel.getMrp());
        contentValues.put(REF_MRP, stockDownloadModel.getRef_mrp());
        contentValues.put(REF_TYPE, stockDownloadModel.getRef_type());
        contentValues.put(REF_ID, stockDownloadModel.getRef_id());
        contentValues.put(TRIP_ID, stockDownloadModel.getTrip_id());
        contentValues.put(TRIP_REF_ID, stockDownloadModel.getTrip_ref_id());
        contentValues.put(DESCRIPTION, stockDownloadModel.getDescription());
        contentValues.put(STOCK_DATE, stockDownloadModel.getStock_date());
        contentValues.put(OWNER_ID, stockDownloadModel.getOwner_id());
        contentValues.put(BEAT_ID, stockDownloadModel.getBeat_id());
        contentValues.put(BATCH_NO, stockDownloadModel.getBatch_no());
        contentValues.put(STATE, stockDownloadModel.getState());
        contentValues.put(U_TS, stockDownloadModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public StockDownloadModel getStockDownloadById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + STOCK_ID + "=" + id, null);

        StockDownloadModel stockDownloadModel = new StockDownloadModel();
        if (res.moveToFirst()) {
            stockDownloadModel.setStock_id(res.getLong(res.getColumnIndex(STOCK_ID)));
            stockDownloadModel.setSrc_entity(res.getString(res.getColumnIndex(SRC_ENTITY)));
            stockDownloadModel.setDst_entity(res.getString(res.getColumnIndex(DST_ENTITY)));
            stockDownloadModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            stockDownloadModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            stockDownloadModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
            stockDownloadModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
            stockDownloadModel.setRef_mrp(res.getFloat(res.getColumnIndex(REF_MRP)));
            stockDownloadModel.setRef_type(res.getFloat(res.getColumnIndex(REF_TYPE)));
            stockDownloadModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
            stockDownloadModel.setTrip_id(res.getString(res.getColumnIndex(TRIP_ID)));
            stockDownloadModel.setTrip_ref_id(res.getString(res.getColumnIndex(TRIP_REF_ID)));
            stockDownloadModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            stockDownloadModel.setStock_date(res.getString(res.getColumnIndex(STOCK_DATE)));
            stockDownloadModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            stockDownloadModel.setBeat_id(res.getString(res.getColumnIndex(BEAT_ID)));
            stockDownloadModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
            stockDownloadModel.setState(res.getInt(res.getColumnIndex(STATE)));
            stockDownloadModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return stockDownloadModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateStockDownload(StockDownloadModel stockDownloadModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SRC_ENTITY, stockDownloadModel.getSrc_entity());
        contentValues.put(DST_ENTITY, stockDownloadModel.getDst_entity());
        contentValues.put(SKU_ID, stockDownloadModel.getSku_id());
        contentValues.put(SKU_CODE, stockDownloadModel.getSku_code());
        contentValues.put(QTY, stockDownloadModel.getQty());
        contentValues.put(MRP, stockDownloadModel.getMrp());
        contentValues.put(REF_MRP, stockDownloadModel.getRef_mrp());
        contentValues.put(REF_TYPE, stockDownloadModel.getRef_type());
        contentValues.put(REF_ID, stockDownloadModel.getRef_id());
        contentValues.put(TRIP_ID, stockDownloadModel.getTrip_id());
        contentValues.put(TRIP_REF_ID, stockDownloadModel.getTrip_ref_id());
        contentValues.put(DESCRIPTION, stockDownloadModel.getDescription());
        contentValues.put(STOCK_DATE, stockDownloadModel.getStock_date());
        contentValues.put(OWNER_ID, stockDownloadModel.getOwner_id());
        contentValues.put(BEAT_ID, stockDownloadModel.getBeat_id());
        contentValues.put(BATCH_NO, stockDownloadModel.getBatch_no());
        contentValues.put(STATE, stockDownloadModel.getState());
        contentValues.put(U_TS, stockDownloadModel.getU_ts());
        db.update(TABLE_NAME, contentValues, STOCK_ID + "= ? ", new String[]{Long.toString(stockDownloadModel.getStock_id())});
        db.close();
        return true;
    }

    public Integer deleteStockDownloadById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, STOCK_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<StockDownloadModel> getAllStockDownload() {
        ArrayList<StockDownloadModel> array_list = new ArrayList<StockDownloadModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                StockDownloadModel stockDownloadModel = new StockDownloadModel();
                stockDownloadModel.setStock_id(res.getLong(res.getColumnIndex(STOCK_ID)));
                stockDownloadModel.setSrc_entity(res.getString(res.getColumnIndex(SRC_ENTITY)));
                stockDownloadModel.setDst_entity(res.getString(res.getColumnIndex(DST_ENTITY)));
                stockDownloadModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                stockDownloadModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                stockDownloadModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
                stockDownloadModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
                stockDownloadModel.setRef_mrp(res.getFloat(res.getColumnIndex(REF_MRP)));
                stockDownloadModel.setRef_type(res.getFloat(res.getColumnIndex(REF_TYPE)));
                stockDownloadModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
                stockDownloadModel.setTrip_id(res.getString(res.getColumnIndex(TRIP_ID)));
                stockDownloadModel.setTrip_ref_id(res.getString(res.getColumnIndex(TRIP_REF_ID)));
                stockDownloadModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                stockDownloadModel.setStock_date(res.getString(res.getColumnIndex(STOCK_DATE)));
                stockDownloadModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                stockDownloadModel.setBeat_id(res.getString(res.getColumnIndex(BEAT_ID)));
                stockDownloadModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
                stockDownloadModel.setState(res.getInt(res.getColumnIndex(STATE)));
                stockDownloadModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(stockDownloadModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}