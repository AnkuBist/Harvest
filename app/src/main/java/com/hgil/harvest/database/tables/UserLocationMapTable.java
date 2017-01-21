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

import com.hgil.harvest.database.dbModels.UserLocationMapModel;

import java.util.ArrayList;

public class UserLocationMapTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_user_location_map";
    private static final String USER_LOCATION_ID = "user_location_id";
    private static final String EMAIL = "email";
    private static final String LOCATION_CODE = "location_code";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public UserLocationMapTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + USER_LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + EMAIL + " TEXT UNIQUE NOT NULL, " + LOCATION_CODE + " TEXT UNIQUE NOT NULL, "
                + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUserLocationMap(UserLocationMapModel userLocationMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_LOCATION_ID, userLocationMapModel.getUser_location_id());
        contentValues.put(EMAIL, userLocationMapModel.getEmail());
        contentValues.put(LOCATION_CODE, userLocationMapModel.getLocation_code());
        contentValues.put(IP, userLocationMapModel.getIp());
        contentValues.put(U_TS, userLocationMapModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public UserLocationMapModel getUserLocationMapById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + USER_LOCATION_ID + "=" + id, null);

        UserLocationMapModel userLocationMapModel = new UserLocationMapModel();
        if (res.moveToFirst()) {
            userLocationMapModel.setUser_location_id(res.getInt(res.getColumnIndex(USER_LOCATION_ID)));
            userLocationMapModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            userLocationMapModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
            userLocationMapModel.setIp(res.getString(res.getColumnIndex(IP)));
            userLocationMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return userLocationMapModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateUserLocationMap(UserLocationMapModel userLocationMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, userLocationMapModel.getEmail());
        contentValues.put(LOCATION_CODE, userLocationMapModel.getLocation_code());
        contentValues.put(IP, userLocationMapModel.getIp());
        contentValues.put(U_TS, userLocationMapModel.getU_ts());
        db.update(TABLE_NAME, contentValues, USER_LOCATION_ID + "= ? ", new String[]{Integer.toString(userLocationMapModel.getUser_location_id())});
        db.close();
        return true;
    }

    public Integer deleteUserLocationMapById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, USER_LOCATION_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<UserLocationMapModel> getAllUserLocationMap() {
        ArrayList<UserLocationMapModel> array_list = new ArrayList<UserLocationMapModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                UserLocationMapModel userLocationMapModel = new UserLocationMapModel();
                userLocationMapModel.setUser_location_id(res.getInt(res.getColumnIndex(USER_LOCATION_ID)));
                userLocationMapModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
                userLocationMapModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
                userLocationMapModel.setIp(res.getString(res.getColumnIndex(IP)));
                userLocationMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(userLocationMapModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}