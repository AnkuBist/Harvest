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

import com.hgil.harvest.database.dbModels.CountryModel;

import java.util.ArrayList;

public class CountryTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_country";
    private static final String COUNTRY_ID = "country_id";
    private static final String COUNTRY_NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public CountryTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + COUNTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + COUNTRY_NAME + " TEXT UNIQUE NOT NULL, " + DESCRIPTION + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertCountry(CountryModel countryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COUNTRY_ID, countryModel.getCountry_id());
        contentValues.put(COUNTRY_NAME, countryModel.getName());
        contentValues.put(DESCRIPTION, countryModel.getDescription());
        contentValues.put(STATE, countryModel.getState());
        contentValues.put(IP, countryModel.getIp());
        contentValues.put(U_TS, countryModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public CountryModel getCountryById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COUNTRY_ID + "=" + id, null);

        CountryModel countryModel = new CountryModel();
        if (res.moveToFirst()) {
            countryModel.setCountry_id(res.getInt(res.getColumnIndex(COUNTRY_ID)));
            countryModel.setName(res.getString(res.getColumnIndex(COUNTRY_NAME)));
            countryModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            countryModel.setState(res.getInt(res.getColumnIndex(STATE)));
            countryModel.setIp(res.getString(res.getColumnIndex(IP)));
            countryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return countryModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateCountry(CountryModel countryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COUNTRY_NAME, countryModel.getName());
        contentValues.put(DESCRIPTION, countryModel.getDescription());
        contentValues.put(STATE, countryModel.getState());
        contentValues.put(IP, countryModel.getIp());
        contentValues.put(U_TS, countryModel.getU_ts());
        db.update(TABLE_NAME, contentValues, COUNTRY_ID + "= ? ", new String[]{Integer.toString(countryModel.getCountry_id())});
        db.close();
        return true;
    }

    public Integer deleteCountryById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COUNTRY_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<CountryModel> getAllCountry() {
        ArrayList<CountryModel> array_list = new ArrayList<CountryModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                CountryModel countryModel = new CountryModel();
                countryModel.setCountry_id(res.getInt(res.getColumnIndex(COUNTRY_ID)));
                countryModel.setName(res.getString(res.getColumnIndex(COUNTRY_NAME)));
                countryModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                countryModel.setState(res.getInt(res.getColumnIndex(STATE)));
                countryModel.setIp(res.getString(res.getColumnIndex(IP)));
                countryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(countryModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}