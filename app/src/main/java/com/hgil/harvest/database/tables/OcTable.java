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

import com.hgil.harvest.database.dbModels.OcModel;

import java.util.ArrayList;

public class OcTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_oc";
    private static final String OC_ID = "oc_id";
    private static final String EMAIL = "email";
    private static final String DESIG = "desig";
    private static final String REP_TO = "rep_to";
    private static final String OC_CODE = "oc_code";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public OcTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + OC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + EMAIL + " TEXT UNIQUE NOT NULL, " + DESIG + " TEXT NULL, " + REP_TO + " TEXT UNIQUE NOT NULL, " + OC_CODE + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOc(OcModel ocModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OC_ID, ocModel.getOc_id());
        contentValues.put(EMAIL, ocModel.getEmail());
        contentValues.put(DESIG, ocModel.getDesig());
        contentValues.put(REP_TO, ocModel.getRep_to());
        contentValues.put(OC_CODE, ocModel.getOc_code());
        contentValues.put(STATE, ocModel.getState());
        contentValues.put(IP, ocModel.getIp());
        contentValues.put(U_TS, ocModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OcModel getOcById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + OC_ID + "=" + id, null);

        OcModel ocModel = new OcModel();
        if (res.moveToFirst()) {
            ocModel.setOc_id(res.getInt(res.getColumnIndex(OC_ID)));
            ocModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            ocModel.setDesig(res.getString(res.getColumnIndex(DESIG)));
            ocModel.setRep_to(res.getString(res.getColumnIndex(REP_TO)));
            ocModel.setOc_code(res.getString(res.getColumnIndex(OC_CODE)));
            ocModel.setState(res.getInt(res.getColumnIndex(STATE)));
            ocModel.setIp(res.getString(res.getColumnIndex(IP)));
            ocModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return ocModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOc(OcModel ocModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, ocModel.getEmail());
        contentValues.put(DESIG, ocModel.getDesig());
        contentValues.put(REP_TO, ocModel.getRep_to());
        contentValues.put(OC_CODE, ocModel.getOc_code());
        contentValues.put(STATE, ocModel.getState());
        contentValues.put(IP, ocModel.getIp());
        contentValues.put(U_TS, ocModel.getU_ts());
        db.update(TABLE_NAME, contentValues, OC_ID + "= ? ", new String[]{Integer.toString(ocModel.getOc_id())});
        db.close();
        return true;
    }

    public Integer deleteOcById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, OC_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OcModel> getAllOc() {
        ArrayList<OcModel> array_list = new ArrayList<OcModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OcModel ocModel = new OcModel();
                ocModel.setOc_id(res.getInt(res.getColumnIndex(OC_ID)));
                ocModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
                ocModel.setDesig(res.getString(res.getColumnIndex(DESIG)));
                ocModel.setRep_to(res.getString(res.getColumnIndex(REP_TO)));
                ocModel.setOc_code(res.getString(res.getColumnIndex(OC_CODE)));
                ocModel.setState(res.getInt(res.getColumnIndex(STATE)));
                ocModel.setIp(res.getString(res.getColumnIndex(IP)));
                ocModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(ocModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}