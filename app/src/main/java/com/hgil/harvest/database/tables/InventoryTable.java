package com.hgil.harvest.database.tables;

/**
 * Created by mohan.giri on 05-01-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hgil.harvest.database.dbModels.InventoryModel;

import java.util.ArrayList;

public class InventoryTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_inventory_item";
    private static final String IVT_ID = "ivt_id";
    private static final String BEAT_ID = "beat_id";
    private static final String OUTLET_ID = "outlet_id";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String BEAT_CODE = "beat_code";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String RQTY = "rqty";
    private static final String DQTY = "dqty";
    private static final String SQTY = "sqty";
    private static final String LQTY = "lqty";
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
    private static final String IMG_ID = "img_id";
    private static final String IVT_DATE = "ivt_date";
    private static final String IVT_REF = "ivt_ref";
    private static final String PRICE = "price";
    private static final String SALE_PRICE = "sale_price";
    private static final String OWNER_ID = "owner_id";
    private static final String IVT_INFO = "ivt_info";
    private static final String GPS_LONG = "gps_long";
    private static final String GPS_LAT = "gps_lat";
    private static final String STATE = "state";
    private static final String U_TS = "u_ts";

    public InventoryTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + IVT_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + BEAT_ID + " INTEGER NOT NULL, " + OUTLET_ID + " TEXT NOT NULL, " + SKU_ID + " REAL NOT NULL, "
                + SKU_CODE + " TEXT NULL, " + BEAT_CODE + " TEXT NULL, " + OUTLET_CODE + " TEXT NULL, "
                + RQTY + " REAL NULL, " + DQTY + " REAL NULL, " + SQTY + " REAL NULL, " + LQTY + " REAL NULL, "
                + NUM_UNITS + " REAL NOT NULL, " + BLK1 + " REAL NULL, " + BLK2 + " REAL NULL, " + BLK3 + " REAL NULL, "
                + BLK4 + " REAL NULL, " + BLK5 + " REAL NULL, " + BLK6 + " REAL NULL, " + BLK7 + " REAL NULL, "
                + BLK8 + " REAL NULL, " + BLK9 + " REAL NULL, " + BLK10 + " REAL NULL, "
                + IMG_ID + " TEXT NULL, " + IVT_DATE + " TEXT NULL, " + IVT_REF + " TEXT NULL, "
                + PRICE + " REAL NULL, " + SALE_PRICE + " REAL NULL, " + OWNER_ID + " TEXT NULL, "
                + IVT_INFO + " TEXT NULL, " + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertInventory(InventoryModel inventoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IVT_ID, inventoryModel.getIvt_id());
        contentValues.put(BEAT_ID, inventoryModel.getBeat_id());
        contentValues.put(OUTLET_ID, inventoryModel.getBeat_code());
        contentValues.put(SKU_ID, inventoryModel.getSku_id());
        contentValues.put(SKU_CODE, inventoryModel.getSku_code());
        contentValues.put(BEAT_CODE, inventoryModel.getBeat_code());
        contentValues.put(OUTLET_CODE, inventoryModel.getOutlet_code());
        contentValues.put(RQTY, inventoryModel.getRqty());
        contentValues.put(DQTY, inventoryModel.getDqty());
        contentValues.put(SQTY, inventoryModel.getSqty());
        contentValues.put(LQTY, inventoryModel.getLqty());
        contentValues.put(NUM_UNITS, inventoryModel.getNum_units());
        contentValues.put(BEAT_CODE, inventoryModel.getBeat_code());
        contentValues.put(OUTLET_CODE, inventoryModel.getOutlet_code());
        contentValues.put(BLK1, inventoryModel.getBlk1());
        contentValues.put(BLK2, inventoryModel.getBlk2());
        contentValues.put(BLK3, inventoryModel.getBlk3());
        contentValues.put(BLK4, inventoryModel.getBlk4());
        contentValues.put(BLK5, inventoryModel.getBlk5());
        contentValues.put(BLK6, inventoryModel.getBlk6());
        contentValues.put(BLK7, inventoryModel.getBlk7());
        contentValues.put(BLK8, inventoryModel.getBlk8());
        contentValues.put(BLK9, inventoryModel.getBlk9());
        contentValues.put(BLK10, inventoryModel.getBlk10());
        contentValues.put(IMG_ID, inventoryModel.getImg_id());
        contentValues.put(IVT_DATE, inventoryModel.getIvt_date());
        contentValues.put(IVT_REF, inventoryModel.getIvt_ref());
        contentValues.put(PRICE, inventoryModel.getPrice());
        contentValues.put(SALE_PRICE, inventoryModel.getSale_price());
        contentValues.put(OWNER_ID, inventoryModel.getOwner_id());
        contentValues.put(IVT_INFO, inventoryModel.getIvt_info());
        contentValues.put(GPS_LONG, inventoryModel.getGps_long());
        contentValues.put(GPS_LAT, inventoryModel.getGps_lat());
        contentValues.put(STATE, inventoryModel.getState());
        contentValues.put(U_TS, inventoryModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public InventoryModel getInventoryById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + IVT_ID + "=" + id, null);

        InventoryModel inventoryModel = new InventoryModel();
        if (res.moveToFirst()) {
            inventoryModel.setIvt_id(res.getLong(res.getColumnIndex(IVT_ID)));
            inventoryModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
            inventoryModel.setOutlet_id(res.getString(res.getColumnIndex(OUTLET_ID)));
            inventoryModel.setSku_id(res.getFloat(res.getColumnIndex(SKU_ID)));
            inventoryModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            inventoryModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            inventoryModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            inventoryModel.setRqty(res.getFloat(res.getColumnIndex(RQTY)));
            inventoryModel.setDqty(res.getFloat(res.getColumnIndex(DQTY)));
            inventoryModel.setSqty(res.getFloat(res.getColumnIndex(SQTY)));
            inventoryModel.setLqty(res.getFloat(res.getColumnIndex(LQTY)));
            inventoryModel.setNum_units(res.getFloat(res.getColumnIndex(NUM_UNITS)));
            inventoryModel.setBlk1(res.getFloat(res.getColumnIndex(BLK1)));
            inventoryModel.setBlk2(res.getFloat(res.getColumnIndex(BLK2)));
            inventoryModel.setBlk3(res.getFloat(res.getColumnIndex(BLK3)));
            inventoryModel.setBlk4(res.getFloat(res.getColumnIndex(BLK4)));
            inventoryModel.setBlk5(res.getFloat(res.getColumnIndex(BLK5)));
            inventoryModel.setBlk6(res.getFloat(res.getColumnIndex(BLK6)));
            inventoryModel.setBlk7(res.getFloat(res.getColumnIndex(BLK7)));
            inventoryModel.setBlk8(res.getFloat(res.getColumnIndex(BLK8)));
            inventoryModel.setBlk9(res.getFloat(res.getColumnIndex(BLK9)));
            inventoryModel.setBlk10(res.getFloat(res.getColumnIndex(BLK10)));
            inventoryModel.setImg_id(res.getString(res.getColumnIndex(IMG_ID)));
            inventoryModel.setIvt_date(res.getString(res.getColumnIndex(IVT_DATE)));
            inventoryModel.setIvt_ref(res.getString(res.getColumnIndex(IVT_REF)));
            inventoryModel.setPrice(res.getFloat(res.getColumnIndex(PRICE)));
            inventoryModel.setSale_price(res.getFloat(res.getColumnIndex(SALE_PRICE)));
            inventoryModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            inventoryModel.setIvt_info(res.getString(res.getColumnIndex(IVT_INFO)));
            inventoryModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
            inventoryModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
            inventoryModel.setState(res.getInt(res.getColumnIndex(STATE)));
            inventoryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return inventoryModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateInventory(InventoryModel inventoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEAT_ID, inventoryModel.getBeat_id());
        contentValues.put(OUTLET_ID, inventoryModel.getBeat_code());
        contentValues.put(SKU_ID, inventoryModel.getSku_id());
        contentValues.put(SKU_CODE, inventoryModel.getSku_code());
        contentValues.put(BEAT_CODE, inventoryModel.getBeat_code());
        contentValues.put(OUTLET_CODE, inventoryModel.getOutlet_code());
        contentValues.put(RQTY, inventoryModel.getRqty());
        contentValues.put(DQTY, inventoryModel.getDqty());
        contentValues.put(SQTY, inventoryModel.getSqty());
        contentValues.put(LQTY, inventoryModel.getLqty());
        contentValues.put(NUM_UNITS, inventoryModel.getNum_units());
        contentValues.put(BEAT_CODE, inventoryModel.getBeat_code());
        contentValues.put(OUTLET_CODE, inventoryModel.getOutlet_code());
        contentValues.put(BLK1, inventoryModel.getBlk1());
        contentValues.put(BLK2, inventoryModel.getBlk2());
        contentValues.put(BLK3, inventoryModel.getBlk3());
        contentValues.put(BLK4, inventoryModel.getBlk4());
        contentValues.put(BLK5, inventoryModel.getBlk5());
        contentValues.put(BLK6, inventoryModel.getBlk6());
        contentValues.put(BLK7, inventoryModel.getBlk7());
        contentValues.put(BLK8, inventoryModel.getBlk8());
        contentValues.put(BLK9, inventoryModel.getBlk9());
        contentValues.put(BLK10, inventoryModel.getBlk10());
        contentValues.put(IMG_ID, inventoryModel.getImg_id());
        contentValues.put(IVT_DATE, inventoryModel.getIvt_date());
        contentValues.put(IVT_REF, inventoryModel.getIvt_ref());
        contentValues.put(PRICE, inventoryModel.getPrice());
        contentValues.put(SALE_PRICE, inventoryModel.getSale_price());
        contentValues.put(OWNER_ID, inventoryModel.getOwner_id());
        contentValues.put(IVT_INFO, inventoryModel.getIvt_info());
        contentValues.put(GPS_LONG, inventoryModel.getGps_long());
        contentValues.put(GPS_LAT, inventoryModel.getGps_lat());
        contentValues.put(STATE, inventoryModel.getState());
        contentValues.put(U_TS, inventoryModel.getU_ts());
        db.update(TABLE_NAME, contentValues, IVT_ID + "= ? ", new String[]{Long.toString(inventoryModel.getIvt_id())});
        db.close();
        return true;
    }

    public Integer deleteInventoryById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, IVT_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<InventoryModel> getAllInventory() {
        ArrayList<InventoryModel> array_list = new ArrayList<InventoryModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                InventoryModel inventoryModel = new InventoryModel();
                inventoryModel.setIvt_id(res.getLong(res.getColumnIndex(IVT_ID)));
                inventoryModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
                inventoryModel.setOutlet_id(res.getString(res.getColumnIndex(OUTLET_ID)));
                inventoryModel.setSku_id(res.getFloat(res.getColumnIndex(SKU_ID)));
                inventoryModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                inventoryModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                inventoryModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                inventoryModel.setRqty(res.getFloat(res.getColumnIndex(RQTY)));
                inventoryModel.setDqty(res.getFloat(res.getColumnIndex(DQTY)));
                inventoryModel.setSqty(res.getFloat(res.getColumnIndex(SQTY)));
                inventoryModel.setLqty(res.getFloat(res.getColumnIndex(LQTY)));
                inventoryModel.setNum_units(res.getFloat(res.getColumnIndex(NUM_UNITS)));
                inventoryModel.setBlk1(res.getFloat(res.getColumnIndex(BLK1)));
                inventoryModel.setBlk2(res.getFloat(res.getColumnIndex(BLK2)));
                inventoryModel.setBlk3(res.getFloat(res.getColumnIndex(BLK3)));
                inventoryModel.setBlk4(res.getFloat(res.getColumnIndex(BLK4)));
                inventoryModel.setBlk5(res.getFloat(res.getColumnIndex(BLK5)));
                inventoryModel.setBlk6(res.getFloat(res.getColumnIndex(BLK6)));
                inventoryModel.setBlk7(res.getFloat(res.getColumnIndex(BLK7)));
                inventoryModel.setBlk8(res.getFloat(res.getColumnIndex(BLK8)));
                inventoryModel.setBlk9(res.getFloat(res.getColumnIndex(BLK9)));
                inventoryModel.setBlk10(res.getFloat(res.getColumnIndex(BLK10)));
                inventoryModel.setImg_id(res.getString(res.getColumnIndex(IMG_ID)));
                inventoryModel.setIvt_date(res.getString(res.getColumnIndex(IVT_DATE)));
                inventoryModel.setIvt_ref(res.getString(res.getColumnIndex(IVT_REF)));
                inventoryModel.setPrice(res.getFloat(res.getColumnIndex(PRICE)));
                inventoryModel.setSale_price(res.getFloat(res.getColumnIndex(SALE_PRICE)));
                inventoryModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                inventoryModel.setIvt_info(res.getString(res.getColumnIndex(IVT_INFO)));
                inventoryModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
                inventoryModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
                inventoryModel.setState(res.getInt(res.getColumnIndex(STATE)));
                inventoryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(inventoryModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}