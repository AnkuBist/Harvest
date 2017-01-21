package com.hgil.harvest.database.tables;

/**
 * Created by mohan.giri on 07-01-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hgil.harvest.database.dbModels.TargetDefModel;

import java.util.ArrayList;

public class TargetDefTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_target_def";
    private static final String TARGET_DEF_ID = "target_def_id";
    private static final String TARGET_NAME = "target_name";
    private static final String TARGET_SOURCE = "target_source";
    private static final String TARGET_VALUE = "target_value";
    private static final String TARGET_PARAM = "target_param";
    private static final String TARGET_TYPE = "target_type";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String BEAT_CODE = "beat_code";
    private static final String SKU_CODE = "sku_code";
    private static final String DIST_ID = "dist_id";
    private static final String USERID_COL = "userid_col";
    private static final String DATE_COL = "date_col";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public TargetDefTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + TARGET_DEF_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + TARGET_NAME + " TEXT UNIQUE NOT NULL, " + TARGET_SOURCE + " TEXT NOT NULL, " + TARGET_VALUE + " TEXT NOT NULL, "
                + TARGET_PARAM + " TEXT NULL, " + TARGET_TYPE + " TEXT NULL, " + OUTLET_CODE + " TEXT NULL, "
                + BEAT_CODE + " TEXT NOT NULL, " + SKU_CODE + " TEXT NOT NULL, " + DIST_ID + " INTEGER NULL, "
                + USERID_COL + " TEXT NULL, " + DATE_COL + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertTargetDef(TargetDefModel targetDefModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TARGET_DEF_ID, targetDefModel.getTarget_def_id());
        contentValues.put(TARGET_NAME, targetDefModel.getTarget_name());
        contentValues.put(TARGET_SOURCE, targetDefModel.getTarget_source());
        contentValues.put(TARGET_VALUE, targetDefModel.getTarget_value());
        contentValues.put(TARGET_PARAM, targetDefModel.getTarget_param());
        contentValues.put(TARGET_TYPE, targetDefModel.getTarget_type());
        contentValues.put(OUTLET_CODE, targetDefModel.getOutlet_code());
        contentValues.put(BEAT_CODE, targetDefModel.getBeat_code());
        contentValues.put(SKU_CODE, targetDefModel.getSku_code());
        contentValues.put(DIST_ID, targetDefModel.getDist_id());
        contentValues.put(USERID_COL, targetDefModel.getUserid_col());
        contentValues.put(DATE_COL, targetDefModel.getDate_col());
        contentValues.put(STATE, targetDefModel.getState());
        contentValues.put(IP, targetDefModel.getIp());
        contentValues.put(U_TS, targetDefModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public TargetDefModel getTargetDefById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TARGET_DEF_ID + "=" + id, null);

        TargetDefModel targetDefModel = new TargetDefModel();
        if (res.moveToFirst()) {
            targetDefModel.setTarget_def_id(res.getInt(res.getColumnIndex(TARGET_DEF_ID)));
            targetDefModel.setTarget_name(res.getString(res.getColumnIndex(TARGET_NAME)));
            targetDefModel.setTarget_source(res.getString(res.getColumnIndex(TARGET_SOURCE)));
            targetDefModel.setTarget_value(res.getString(res.getColumnIndex(TARGET_VALUE)));
            targetDefModel.setTarget_param(res.getString(res.getColumnIndex(TARGET_PARAM)));
            targetDefModel.setTarget_type(res.getString(res.getColumnIndex(TARGET_TYPE)));
            targetDefModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            targetDefModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            targetDefModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            targetDefModel.setDist_id(res.getInt(res.getColumnIndex(DIST_ID)));
            targetDefModel.setUserid_col(res.getString(res.getColumnIndex(USERID_COL)));
            targetDefModel.setDate_col(res.getString(res.getColumnIndex(DATE_COL)));
            targetDefModel.setState(res.getInt(res.getColumnIndex(STATE)));
            targetDefModel.setIp(res.getString(res.getColumnIndex(IP)));
            targetDefModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return targetDefModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateTargetDef(TargetDefModel targetDefModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TARGET_NAME, targetDefModel.getTarget_name());
        contentValues.put(TARGET_SOURCE, targetDefModel.getTarget_source());
        contentValues.put(TARGET_VALUE, targetDefModel.getTarget_value());
        contentValues.put(TARGET_PARAM, targetDefModel.getTarget_param());
        contentValues.put(TARGET_TYPE, targetDefModel.getTarget_type());
        contentValues.put(OUTLET_CODE, targetDefModel.getOutlet_code());
        contentValues.put(BEAT_CODE, targetDefModel.getBeat_code());
        contentValues.put(SKU_CODE, targetDefModel.getSku_code());
        contentValues.put(DIST_ID, targetDefModel.getDist_id());
        contentValues.put(USERID_COL, targetDefModel.getUserid_col());
        contentValues.put(DATE_COL, targetDefModel.getDate_col());
        contentValues.put(STATE, targetDefModel.getState());
        contentValues.put(IP, targetDefModel.getIp());
        contentValues.put(U_TS, targetDefModel.getU_ts());
        db.update(TABLE_NAME, contentValues, TARGET_DEF_ID + "= ? ", new String[]{Integer.toString(targetDefModel.getTarget_def_id())});
        db.close();
        return true;
    }

    public Integer deleteTargetDefById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, TARGET_DEF_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<TargetDefModel> getAllTargetDef() {
        ArrayList<TargetDefModel> array_list = new ArrayList<TargetDefModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                TargetDefModel targetDefModel = new TargetDefModel();
                targetDefModel.setTarget_def_id(res.getInt(res.getColumnIndex(TARGET_DEF_ID)));
                targetDefModel.setTarget_name(res.getString(res.getColumnIndex(TARGET_NAME)));
                targetDefModel.setTarget_source(res.getString(res.getColumnIndex(TARGET_SOURCE)));
                targetDefModel.setTarget_value(res.getString(res.getColumnIndex(TARGET_VALUE)));
                targetDefModel.setTarget_param(res.getString(res.getColumnIndex(TARGET_PARAM)));
                targetDefModel.setTarget_type(res.getString(res.getColumnIndex(TARGET_TYPE)));
                targetDefModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                targetDefModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                targetDefModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                targetDefModel.setDist_id(res.getInt(res.getColumnIndex(DIST_ID)));
                targetDefModel.setUserid_col(res.getString(res.getColumnIndex(USERID_COL)));
                targetDefModel.setDate_col(res.getString(res.getColumnIndex(DATE_COL)));
                targetDefModel.setState(res.getInt(res.getColumnIndex(STATE)));
                targetDefModel.setIp(res.getString(res.getColumnIndex(IP)));
                targetDefModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(targetDefModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}