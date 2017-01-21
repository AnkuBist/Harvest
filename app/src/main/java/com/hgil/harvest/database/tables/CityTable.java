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
import android.os.CountDownTimer;

import com.hgil.harvest.database.dbModels.CityModel;

import java.util.ArrayList;

public class CityTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_city";
    private static final String CITY_ID = "city_id";
    private static final String CITY_NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String COUNTRY_NAME = "country_name";
    private static final String STATE_NAME = "state_name";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public CityTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + CITY_NAME + " TEXT UNIQUE NOT NULL, " + DESCRIPTION + " TEXT NULL, " + COUNTRY_NAME + " TEXT NULL, " + STATE_NAME + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertCity(CityModel activityModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CITY_ID, activityModel.getCity_id());
        contentValues.put(CITY_NAME, activityModel.getName());
        contentValues.put(DESCRIPTION, activityModel.getDescription());
        contentValues.put(COUNTRY_NAME, activityModel.getCountry_name());
        contentValues.put(STATE_NAME, activityModel.getState_name());
        contentValues.put(STATE, activityModel.getState());
        contentValues.put(IP, activityModel.getIp());
        contentValues.put(U_TS, activityModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public CityModel getCityById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + CITY_ID + "=" + id, null);

        CityModel activityModel = new CityModel();
        if (res.moveToFirst()) {
            activityModel.setCity_id(res.getInt(res.getColumnIndex(CITY_ID)));
            activityModel.setName(res.getString(res.getColumnIndex(CITY_NAME)));
            activityModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            activityModel.setCountry_name(res.getString(res.getColumnIndex(COUNTRY_NAME)));
            activityModel.setState_name(res.getString(res.getColumnIndex(STATE_NAME)));
            activityModel.setState(res.getInt(res.getColumnIndex(STATE)));
            activityModel.setIp(res.getString(res.getColumnIndex(IP)));
            activityModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return activityModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateCity(CityModel activityModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CITY_NAME, activityModel.getName());
        contentValues.put(DESCRIPTION, activityModel.getDescription());
        contentValues.put(COUNTRY_NAME, activityModel.getCountry_name());
        contentValues.put(STATE_NAME, activityModel.getState_name());
        contentValues.put(STATE, activityModel.getState());
        contentValues.put(IP, activityModel.getIp());
        contentValues.put(U_TS, activityModel.getU_ts());
        db.update(TABLE_NAME, contentValues, CITY_ID + "= ? ", new String[]{Integer.toString(activityModel.getCity_id())});
        db.close();
        return true;
    }

    public Integer deleteCityById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, CITY_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<CityModel> getAllCity() {
        ArrayList<CityModel> array_list = new ArrayList<CityModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                CityModel activityModel = new CityModel();
                activityModel.setCity_id(res.getInt(res.getColumnIndex(CITY_ID)));
                activityModel.setName(res.getString(res.getColumnIndex(CITY_NAME)));
                activityModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                activityModel.setCountry_name(res.getString(res.getColumnIndex(COUNTRY_NAME)));
                activityModel.setState_name(res.getString(res.getColumnIndex(STATE_NAME)));
                activityModel.setState(res.getInt(res.getColumnIndex(STATE)));
                activityModel.setIp(res.getString(res.getColumnIndex(IP)));
                activityModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(activityModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}