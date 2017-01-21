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

import com.hgil.harvest.database.dbModels.SchemeTypeModel;

import java.util.ArrayList;

public class SchemeTypeTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_scheme_type";
    private static final String SCHEME_TYPE_ID = "scheme_type_id";
    private static final String SCHEME_NAME = "name";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public SchemeTypeTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + SCHEME_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + SCHEME_NAME + " TEXT UNIQUE NOT NULL, " + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSchemeType(SchemeTypeModel schemeTypeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCHEME_TYPE_ID, schemeTypeModel.getScheme_type_id());
        contentValues.put(SCHEME_NAME, schemeTypeModel.getName());
        contentValues.put(STATE, schemeTypeModel.getState());
        contentValues.put(IP, schemeTypeModel.getIp());
        contentValues.put(U_TS, schemeTypeModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public SchemeTypeModel getSchemeTypeById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + SCHEME_TYPE_ID + "=" + id, null);

        SchemeTypeModel schemeTypeModel = new SchemeTypeModel();
        if (res.moveToFirst()) {
            schemeTypeModel.setScheme_type_id(res.getInt(res.getColumnIndex(SCHEME_TYPE_ID)));
            schemeTypeModel.setName(res.getString(res.getColumnIndex(SCHEME_NAME)));
            schemeTypeModel.setState(res.getInt(res.getColumnIndex(STATE)));
            schemeTypeModel.setIp(res.getString(res.getColumnIndex(IP)));
            schemeTypeModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return schemeTypeModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateSchemeType(SchemeTypeModel schemeTypeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCHEME_NAME, schemeTypeModel.getName());
        contentValues.put(STATE, schemeTypeModel.getState());
        contentValues.put(IP, schemeTypeModel.getIp());
        contentValues.put(U_TS, schemeTypeModel.getU_ts());
        db.update(TABLE_NAME, contentValues, SCHEME_TYPE_ID + "= ? ", new String[]{Integer.toString(schemeTypeModel.getScheme_type_id())});
        db.close();
        return true;
    }

    public Integer deleteSchemeTypeById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, SCHEME_TYPE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<SchemeTypeModel> getAllSchemeType() {
        ArrayList<SchemeTypeModel> array_list = new ArrayList<SchemeTypeModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                SchemeTypeModel schemeTypeModel = new SchemeTypeModel();
                schemeTypeModel.setScheme_type_id(res.getInt(res.getColumnIndex(SCHEME_TYPE_ID)));
                schemeTypeModel.setName(res.getString(res.getColumnIndex(SCHEME_NAME)));
                schemeTypeModel.setState(res.getInt(res.getColumnIndex(STATE)));
                schemeTypeModel.setIp(res.getString(res.getColumnIndex(IP)));
                schemeTypeModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(schemeTypeModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}