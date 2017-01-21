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

import com.hgil.harvest.database.dbModels.SkuModel;

import java.util.ArrayList;

public class SkuTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_sku";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String SKU_NAME = "name";
    private static final String MRP = "mrp";
    private static final String UOM = "uom";
    private static final String VARIANT = "variant";
    private static final String SKU_DESC = "sku_desc";
    private static final String CAT = "cat";
    private static final String CAT1 = "cat1";
    private static final String CAT2 = "cat2";
    private static final String BLK1_SIZE = "blk1_size";
    private static final String BLK2_SIZE = "blk2_size";
    private static final String BLK3_SIZE = "blk3_size";
    private static final String BLK4_SIZE = "blk4_size";
    private static final String BLK5_SIZE = "blk5_size";
    private static final String BLK6_SIZE = "blk6_size";
    private static final String BLK7_SIZE = "blk7_size";
    private static final String BLK8_SIZE = "blk8_size";
    private static final String BLK9_SIZE = "blk9_size";
    private static final String BLK10_SIZE = "blk10_size";
    private static final String MAX_DISC = "max_disc";
    private static final String BAR_CODE = "bar_code";
    private static final String POS = "pos";
    private static final String TAX_CODE = "tax_code";
    private static final String CREATED_BY = "created_by";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public SkuTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + SKU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + SKU_CODE + " TEXT NOT NULL, " + SKU_NAME + " TEXT UNIQUE NOT NULL, " + MRP + " REAL NOT NULL, "
                + UOM + " TEXT UNIQUE NOT NULL, " + VARIANT + " TEXT UNIQUE NOT NULL, " + SKU_DESC + " TEXT NULL, "
                + CAT + " TEXT NULL, " + CAT1 + " TEXT NULL, " + CAT2 + " TEXT NULL, "
                + BLK1_SIZE + " TEXT NULL, " + BLK2_SIZE + " TEXT NULL, " + BLK3_SIZE + " TEXT NULL, "
                + BLK4_SIZE + " TEXT NULL, " + BLK5_SIZE + " TEXT NULL, " + BLK6_SIZE + " TEXT NULL, "
                + BLK7_SIZE + " TEXT NULL, " + BLK8_SIZE + " TEXT NULL, " + BLK9_SIZE + " TEXT NULL, "
                + BLK10_SIZE + " TEXT NULL, " + MAX_DISC + " REAL NULL, " + BAR_CODE + " TEXT NULL, "
                + POS + " INTEGER NULL, " + TAX_CODE + " TEXT NULL, " + CREATED_BY + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSku(SkuModel skuModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SKU_ID, skuModel.getSku_id());
        contentValues.put(SKU_CODE, skuModel.getSku_code());
        contentValues.put(SKU_NAME, skuModel.getName());
        contentValues.put(MRP, skuModel.getMrp());
        contentValues.put(UOM, skuModel.getUom());
        contentValues.put(VARIANT, skuModel.getVariant());
        contentValues.put(SKU_DESC, skuModel.getSku_desc());
        contentValues.put(CAT, skuModel.getCat());
        contentValues.put(CAT1, skuModel.getCat1());
        contentValues.put(CAT2, skuModel.getCat2());
        contentValues.put(BLK1_SIZE, skuModel.getBlk1_size());
        contentValues.put(BLK2_SIZE, skuModel.getBlk2_size());
        contentValues.put(BLK3_SIZE, skuModel.getBlk3_size());
        contentValues.put(BLK4_SIZE, skuModel.getBlk4_size());
        contentValues.put(BLK5_SIZE, skuModel.getBlk5_size());
        contentValues.put(BLK6_SIZE, skuModel.getBlk6_size());
        contentValues.put(BLK7_SIZE, skuModel.getBlk7_size());
        contentValues.put(BLK8_SIZE, skuModel.getBlk8_size());
        contentValues.put(BLK9_SIZE, skuModel.getBlk9_size());
        contentValues.put(BLK10_SIZE, skuModel.getBlk10_size());
        contentValues.put(MAX_DISC, skuModel.getMax_disc());
        contentValues.put(BAR_CODE, skuModel.getBar_code());
        contentValues.put(POS, skuModel.getPos());
        contentValues.put(TAX_CODE, skuModel.getTax_code());
        contentValues.put(CREATED_BY, skuModel.getCreated_by());
        contentValues.put(STATE, skuModel.getState());
        contentValues.put(IP, skuModel.getIp());
        contentValues.put(U_TS, skuModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public SkuModel getSkuById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + SKU_ID + "=" + id, null);

        SkuModel skuModel = new SkuModel();
        if (res.moveToFirst()) {
            skuModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            skuModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            skuModel.setName(res.getString(res.getColumnIndex(SKU_NAME)));
            skuModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
            skuModel.setUom(res.getString(res.getColumnIndex(UOM)));
            skuModel.setVariant(res.getString(res.getColumnIndex(VARIANT)));
            skuModel.setSku_desc(res.getString(res.getColumnIndex(SKU_DESC)));
            skuModel.setCat(res.getString(res.getColumnIndex(CAT)));
            skuModel.setCat1(res.getString(res.getColumnIndex(CAT1)));
            skuModel.setCat2(res.getString(res.getColumnIndex(CAT2)));
            skuModel.setBlk1_size(res.getFloat(res.getColumnIndex(BLK1_SIZE)));
            skuModel.setBlk2_size(res.getFloat(res.getColumnIndex(BLK2_SIZE)));
            skuModel.setBlk3_size(res.getFloat(res.getColumnIndex(BLK3_SIZE)));
            skuModel.setBlk4_size(res.getFloat(res.getColumnIndex(BLK4_SIZE)));
            skuModel.setBlk5_size(res.getFloat(res.getColumnIndex(BLK5_SIZE)));
            skuModel.setBlk6_size(res.getFloat(res.getColumnIndex(BLK6_SIZE)));
            skuModel.setBlk7_size(res.getFloat(res.getColumnIndex(BLK7_SIZE)));
            skuModel.setBlk8_size(res.getFloat(res.getColumnIndex(BLK8_SIZE)));
            skuModel.setBlk9_size(res.getFloat(res.getColumnIndex(BLK9_SIZE)));
            skuModel.setBlk10_size(res.getFloat(res.getColumnIndex(BLK10_SIZE)));
            skuModel.setMax_disc(res.getFloat(res.getColumnIndex(MAX_DISC)));
            skuModel.setBar_code(res.getString(res.getColumnIndex(BAR_CODE)));
            skuModel.setPos(res.getInt(res.getColumnIndex(POS)));
            skuModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
            skuModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            skuModel.setState(res.getInt(res.getColumnIndex(STATE)));
            skuModel.setIp(res.getString(res.getColumnIndex(IP)));
            skuModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return skuModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateSku(SkuModel skuModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SKU_CODE, skuModel.getSku_code());
        contentValues.put(SKU_NAME, skuModel.getName());
        contentValues.put(MRP, skuModel.getMrp());
        contentValues.put(UOM, skuModel.getUom());
        contentValues.put(VARIANT, skuModel.getVariant());
        contentValues.put(SKU_DESC, skuModel.getSku_desc());
        contentValues.put(CAT, skuModel.getCat());
        contentValues.put(CAT1, skuModel.getCat1());
        contentValues.put(CAT2, skuModel.getCat2());
        contentValues.put(BLK1_SIZE, skuModel.getBlk1_size());
        contentValues.put(BLK2_SIZE, skuModel.getBlk2_size());
        contentValues.put(BLK3_SIZE, skuModel.getBlk3_size());
        contentValues.put(BLK4_SIZE, skuModel.getBlk4_size());
        contentValues.put(BLK5_SIZE, skuModel.getBlk5_size());
        contentValues.put(BLK6_SIZE, skuModel.getBlk6_size());
        contentValues.put(BLK7_SIZE, skuModel.getBlk7_size());
        contentValues.put(BLK8_SIZE, skuModel.getBlk8_size());
        contentValues.put(BLK9_SIZE, skuModel.getBlk9_size());
        contentValues.put(BLK10_SIZE, skuModel.getBlk10_size());
        contentValues.put(MAX_DISC, skuModel.getMax_disc());
        contentValues.put(BAR_CODE, skuModel.getBar_code());
        contentValues.put(POS, skuModel.getPos());
        contentValues.put(TAX_CODE, skuModel.getTax_code());
        contentValues.put(CREATED_BY, skuModel.getCreated_by());
        contentValues.put(STATE, skuModel.getState());
        contentValues.put(IP, skuModel.getIp());
        contentValues.put(U_TS, skuModel.getU_ts());
        db.update(TABLE_NAME, contentValues, SKU_ID + "= ? ", new String[]{Integer.toString(skuModel.getSku_id())});
        db.close();
        return true;
    }

    public Integer deleteSkuById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, SKU_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<SkuModel> getAllSku() {
        ArrayList<SkuModel> array_list = new ArrayList<SkuModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                SkuModel skuModel = new SkuModel();
                skuModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                skuModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                skuModel.setName(res.getString(res.getColumnIndex(SKU_NAME)));
                skuModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
                skuModel.setUom(res.getString(res.getColumnIndex(UOM)));
                skuModel.setVariant(res.getString(res.getColumnIndex(VARIANT)));
                skuModel.setSku_desc(res.getString(res.getColumnIndex(SKU_DESC)));
                skuModel.setCat(res.getString(res.getColumnIndex(CAT)));
                skuModel.setCat1(res.getString(res.getColumnIndex(CAT1)));
                skuModel.setCat2(res.getString(res.getColumnIndex(CAT2)));
                skuModel.setBlk1_size(res.getFloat(res.getColumnIndex(BLK1_SIZE)));
                skuModel.setBlk2_size(res.getFloat(res.getColumnIndex(BLK2_SIZE)));
                skuModel.setBlk3_size(res.getFloat(res.getColumnIndex(BLK3_SIZE)));
                skuModel.setBlk4_size(res.getFloat(res.getColumnIndex(BLK4_SIZE)));
                skuModel.setBlk5_size(res.getFloat(res.getColumnIndex(BLK5_SIZE)));
                skuModel.setBlk6_size(res.getFloat(res.getColumnIndex(BLK6_SIZE)));
                skuModel.setBlk7_size(res.getFloat(res.getColumnIndex(BLK7_SIZE)));
                skuModel.setBlk8_size(res.getFloat(res.getColumnIndex(BLK8_SIZE)));
                skuModel.setBlk9_size(res.getFloat(res.getColumnIndex(BLK9_SIZE)));
                skuModel.setBlk10_size(res.getFloat(res.getColumnIndex(BLK10_SIZE)));
                skuModel.setMax_disc(res.getFloat(res.getColumnIndex(MAX_DISC)));
                skuModel.setBar_code(res.getString(res.getColumnIndex(BAR_CODE)));
                skuModel.setPos(res.getInt(res.getColumnIndex(POS)));
                skuModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
                skuModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                skuModel.setState(res.getInt(res.getColumnIndex(STATE)));
                skuModel.setIp(res.getString(res.getColumnIndex(IP)));
                skuModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(skuModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}