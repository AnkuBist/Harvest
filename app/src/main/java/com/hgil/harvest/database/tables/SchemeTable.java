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

import com.hgil.harvest.database.dbModels.SchemeModel;

import java.util.ArrayList;

public class SchemeTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_scheme";
    private static final String SCHEME_ID = "scheme_id";
    private static final String LOCATION_CODE = "location_code";
    private static final String SKU_CODE = "sku_code";
    private static final String SCHEME_TYPE = "scheme_type";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String ITEM_START = "item_start";
    private static final String ITEM_END = "item_end";
    private static final String ITEM_DISC = "item_disc";
    private static final String FREE_SKU_ID = "free_sku_id";
    private static final String ITEM_DISC_MAX = "item_disc_max";
    private static final String ITEM_DISC_PER = "item_disc_per";
    private static final String SCOPE_OUTLET = "scope_outlet";
    private static final String SCOPE_OUTLET_CAT = "scope_outlet_cat";
    private static final String SCOPE_SKU_CAT = "scope_sku_cat";
    private static final String SCOPE_DIST_ID = "scope_dist_id";
    private static final String REF_ID = "ref_id";
    private static final String SCHEME_CODE = "scheme_code";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public SchemeTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + SCHEME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + LOCATION_CODE + " TEXT UNIQUE NULL, " + SKU_CODE + " TEXT UNIQUE NOT NULL, " + SCHEME_TYPE + " TEXT UNIQUE NOT NULL, "
                + START_DATE + " TEXT UNIQUE NULL, " + END_DATE + " TEXT NULL, " + ITEM_START + " INTEGER UNIQUE NULL, "
                + ITEM_END + " INTEGER NULL, " + ITEM_DISC + " REAL UNIQUE NULL, " + FREE_SKU_ID + " INTEGER NULL, "
                + ITEM_DISC_MAX + " REAL NULL, " + ITEM_DISC_PER + " REAL UNIQUE NULL, " + SCOPE_OUTLET + " TEXT UNIQUE NULL, "
                + SCOPE_OUTLET_CAT + " TEXT UNIQUE NULL, " + SCOPE_SKU_CAT + " TEXT UNIQUE NULL, " + SCOPE_DIST_ID + " TEXT UNIQUE NULL, "
                + REF_ID + " TEXT NULL, " + SCHEME_CODE + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertScheme(SchemeModel schemeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCHEME_ID, schemeModel.getScheme_id());
        contentValues.put(LOCATION_CODE, schemeModel.getLocation_code());
        contentValues.put(SKU_CODE, schemeModel.getSku_code());
        contentValues.put(SCHEME_TYPE, schemeModel.getScheme_type());
        contentValues.put(START_DATE, schemeModel.getStart_date());
        contentValues.put(END_DATE, schemeModel.getEnd_date());
        contentValues.put(ITEM_START, schemeModel.getItem_start());
        contentValues.put(ITEM_END, schemeModel.getItem_end());
        contentValues.put(ITEM_DISC, schemeModel.getItem_disc());
        contentValues.put(FREE_SKU_ID, schemeModel.getFree_sku_id());
        contentValues.put(ITEM_DISC_MAX, schemeModel.getItem_disc_max());
        contentValues.put(ITEM_DISC_PER, schemeModel.getItem_disc_per());
        contentValues.put(SCOPE_OUTLET, schemeModel.getScope_outlet());
        contentValues.put(SCOPE_OUTLET_CAT, schemeModel.getScope_outlet_cat());
        contentValues.put(SCOPE_SKU_CAT, schemeModel.getScope_sku_cat());
        contentValues.put(SCOPE_DIST_ID, schemeModel.getScope_dist_id());
        contentValues.put(REF_ID, schemeModel.getRef_id());
        contentValues.put(SCHEME_CODE, schemeModel.getScheme_code());
        contentValues.put(STATE, schemeModel.getState());
        contentValues.put(IP, schemeModel.getIp());
        contentValues.put(U_TS, schemeModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public SchemeModel getSchemeById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + SCHEME_ID + "=" + id, null);

        SchemeModel schemeModel = new SchemeModel();
        if (res.moveToFirst()) {
            schemeModel.setScheme_id(res.getInt(res.getColumnIndex(SCHEME_ID)));
            schemeModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
            schemeModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            schemeModel.setScheme_type(res.getString(res.getColumnIndex(SCHEME_TYPE)));
            schemeModel.setStart_date(res.getString(res.getColumnIndex(START_DATE)));
            schemeModel.setEnd_date(res.getString(res.getColumnIndex(END_DATE)));
            schemeModel.setItem_start(res.getInt(res.getColumnIndex(ITEM_START)));
            schemeModel.setItem_end(res.getInt(res.getColumnIndex(ITEM_END)));
            schemeModel.setItem_disc(res.getFloat(res.getColumnIndex(ITEM_DISC)));
            schemeModel.setFree_sku_id(res.getInt(res.getColumnIndex(FREE_SKU_ID)));
            schemeModel.setItem_disc_max(res.getFloat(res.getColumnIndex(ITEM_DISC_MAX)));
            schemeModel.setItem_disc_per(res.getFloat(res.getColumnIndex(ITEM_DISC_PER)));
            schemeModel.setScope_outlet(res.getString(res.getColumnIndex(SCOPE_OUTLET)));
            schemeModel.setScope_outlet_cat(res.getString(res.getColumnIndex(SCOPE_OUTLET_CAT)));
            schemeModel.setScope_sku_cat(res.getString(res.getColumnIndex(SCOPE_SKU_CAT)));
            schemeModel.setScope_dist_id(res.getString(res.getColumnIndex(SCOPE_DIST_ID)));
            schemeModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
            schemeModel.setScheme_code(res.getString(res.getColumnIndex(SCHEME_CODE)));
            schemeModel.setState(res.getInt(res.getColumnIndex(STATE)));
            schemeModel.setIp(res.getString(res.getColumnIndex(IP)));
            schemeModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return schemeModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateScheme(SchemeModel schemeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOCATION_CODE, schemeModel.getLocation_code());
        contentValues.put(SKU_CODE, schemeModel.getSku_code());
        contentValues.put(SCHEME_TYPE, schemeModel.getScheme_type());
        contentValues.put(START_DATE, schemeModel.getStart_date());
        contentValues.put(END_DATE, schemeModel.getEnd_date());
        contentValues.put(ITEM_START, schemeModel.getItem_start());
        contentValues.put(ITEM_END, schemeModel.getItem_end());
        contentValues.put(ITEM_DISC, schemeModel.getItem_disc());
        contentValues.put(FREE_SKU_ID, schemeModel.getFree_sku_id());
        contentValues.put(ITEM_DISC_MAX, schemeModel.getItem_disc_max());
        contentValues.put(ITEM_DISC_PER, schemeModel.getItem_disc_per());
        contentValues.put(SCOPE_OUTLET, schemeModel.getScope_outlet());
        contentValues.put(SCOPE_OUTLET_CAT, schemeModel.getScope_outlet_cat());
        contentValues.put(SCOPE_SKU_CAT, schemeModel.getScope_sku_cat());
        contentValues.put(SCOPE_DIST_ID, schemeModel.getScope_dist_id());
        contentValues.put(REF_ID, schemeModel.getRef_id());
        contentValues.put(SCHEME_CODE, schemeModel.getScheme_code());
        contentValues.put(STATE, schemeModel.getState());
        contentValues.put(IP, schemeModel.getIp());
        contentValues.put(U_TS, schemeModel.getU_ts());
        db.update(TABLE_NAME, contentValues, SCHEME_ID + "= ? ", new String[]{Integer.toString(schemeModel.getScheme_id())});
        db.close();
        return true;
    }

    public Integer deleteSchemeById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, SCHEME_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<SchemeModel> getAllScheme() {
        ArrayList<SchemeModel> array_list = new ArrayList<SchemeModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                SchemeModel schemeModel = new SchemeModel();
                schemeModel.setScheme_id(res.getInt(res.getColumnIndex(SCHEME_ID)));
                schemeModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
                schemeModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                schemeModel.setScheme_type(res.getString(res.getColumnIndex(SCHEME_TYPE)));
                schemeModel.setStart_date(res.getString(res.getColumnIndex(START_DATE)));
                schemeModel.setEnd_date(res.getString(res.getColumnIndex(END_DATE)));
                schemeModel.setItem_start(res.getInt(res.getColumnIndex(ITEM_START)));
                schemeModel.setItem_end(res.getInt(res.getColumnIndex(ITEM_END)));
                schemeModel.setItem_disc(res.getFloat(res.getColumnIndex(ITEM_DISC)));
                schemeModel.setFree_sku_id(res.getInt(res.getColumnIndex(FREE_SKU_ID)));
                schemeModel.setItem_disc_max(res.getFloat(res.getColumnIndex(ITEM_DISC_MAX)));
                schemeModel.setItem_disc_per(res.getFloat(res.getColumnIndex(ITEM_DISC_PER)));
                schemeModel.setScope_outlet(res.getString(res.getColumnIndex(SCOPE_OUTLET)));
                schemeModel.setScope_outlet_cat(res.getString(res.getColumnIndex(SCOPE_OUTLET_CAT)));
                schemeModel.setScope_sku_cat(res.getString(res.getColumnIndex(SCOPE_SKU_CAT)));
                schemeModel.setScope_dist_id(res.getString(res.getColumnIndex(SCOPE_DIST_ID)));
                schemeModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
                schemeModel.setScheme_code(res.getString(res.getColumnIndex(SCHEME_CODE)));
                schemeModel.setState(res.getInt(res.getColumnIndex(STATE)));
                schemeModel.setIp(res.getString(res.getColumnIndex(IP)));
                schemeModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(schemeModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}