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

import com.hgil.harvest.database.dbModels.LocationModel;

import java.util.ArrayList;

public class LocationTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_location";
    private static final String LOCATION_ID = "location_id";
    private static final String LOCATION_NAME = "name";
    private static final String LOCATION_CODE = "location_code";
    private static final String DESCRIPTION = "description";
    private static final String COUNTRY_NAME = "country_name";
    private static final String STATE_NAME = "state_name";
    private static final String CITY_NAME = "city_name";
    private static final String TAX_CODE = "tax_code";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public LocationTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + LOCATION_NAME + " TEXT UNIQUE NOT NULL, " + LOCATION_CODE + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NULL, " + COUNTRY_NAME + " TEXT NULL, "
                + STATE_NAME + " TEXT NULL, " + CITY_NAME + " TEXT NULL, " + TAX_CODE + " TEXT NULL, " + STATE + " INTEGER NULL, "
                + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertLocation(LocationModel locationModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOCATION_ID, locationModel.getLocation_id());
        contentValues.put(LOCATION_NAME, locationModel.getName());
        contentValues.put(LOCATION_CODE, locationModel.getLocation_code());
        contentValues.put(DESCRIPTION, locationModel.getDescription());
        contentValues.put(COUNTRY_NAME, locationModel.getCountry_name());
        contentValues.put(STATE_NAME, locationModel.getState_name());
        contentValues.put(CITY_NAME, locationModel.getCity_name());
        contentValues.put(TAX_CODE, locationModel.getTax_code());
        contentValues.put(STATE, locationModel.getState());
        contentValues.put(IP, locationModel.getIp());
        contentValues.put(U_TS, locationModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public LocationModel getLocationById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + LOCATION_ID + "=" + id, null);

        LocationModel locationModel = new LocationModel();
        if (res.moveToFirst()) {
            locationModel.setLocation_id(res.getInt(res.getColumnIndex(LOCATION_ID)));
            locationModel.setName(res.getString(res.getColumnIndex(LOCATION_NAME)));
            locationModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
            locationModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            locationModel.setCountry_name(res.getString(res.getColumnIndex(COUNTRY_NAME)));
            locationModel.setState_name(res.getString(res.getColumnIndex(STATE_NAME)));
            locationModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
            locationModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
            locationModel.setState(res.getInt(res.getColumnIndex(STATE)));
            locationModel.setIp(res.getString(res.getColumnIndex(IP)));
            locationModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return locationModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateLocation(LocationModel locationModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOCATION_NAME, locationModel.getName());
        contentValues.put(LOCATION_CODE, locationModel.getLocation_code());
        contentValues.put(DESCRIPTION, locationModel.getDescription());
        contentValues.put(COUNTRY_NAME, locationModel.getCountry_name());
        contentValues.put(STATE_NAME, locationModel.getState_name());
        contentValues.put(CITY_NAME, locationModel.getCity_name());
        contentValues.put(TAX_CODE, locationModel.getTax_code());
        contentValues.put(STATE, locationModel.getState());
        contentValues.put(IP, locationModel.getIp());
        contentValues.put(U_TS, locationModel.getU_ts());
        db.update(TABLE_NAME, contentValues, LOCATION_ID + "= ? ", new String[]{Integer.toString(locationModel.getLocation_id())});
        db.close();
        return true;
    }

    public Integer deleteLocationById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, LOCATION_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<LocationModel> getAllLocation() {
        ArrayList<LocationModel> array_list = new ArrayList<LocationModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                LocationModel locationModel = new LocationModel();
                locationModel.setLocation_id(res.getInt(res.getColumnIndex(LOCATION_ID)));
                locationModel.setName(res.getString(res.getColumnIndex(LOCATION_NAME)));
                locationModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
                locationModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                locationModel.setCountry_name(res.getString(res.getColumnIndex(COUNTRY_NAME)));
                locationModel.setState_name(res.getString(res.getColumnIndex(STATE_NAME)));
                locationModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
                locationModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
                locationModel.setState(res.getInt(res.getColumnIndex(STATE)));
                locationModel.setIp(res.getString(res.getColumnIndex(IP)));
                locationModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(locationModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}