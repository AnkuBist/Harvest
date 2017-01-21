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

import com.hgil.harvest.database.dbModels.UserBeatMapModel;

import java.util.ArrayList;

public class UserBeatMapTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_user_beat_map";
    private static final String USER_BEAT_ID = "user_beat_id";
    private static final String EMAIL = "email";
    private static final String BEAT_ID = "beat_id";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public UserBeatMapTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + USER_BEAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + EMAIL + " TEXT UNIQUE NOT NULL, " + BEAT_ID + " TEXT UNIQUE NOT NULL, "
                + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUserBeatMap(UserBeatMapModel userBeatMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_BEAT_ID, userBeatMapModel.getUser_beat_id());
        contentValues.put(EMAIL, userBeatMapModel.getEmail());
        contentValues.put(BEAT_ID, userBeatMapModel.getBeat_id());
        contentValues.put(IP, userBeatMapModel.getIp());
        contentValues.put(U_TS, userBeatMapModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public UserBeatMapModel getUserBeatMapById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + USER_BEAT_ID + "=" + id, null);

        UserBeatMapModel userBeatMapModel = new UserBeatMapModel();
        if (res.moveToFirst()) {
            userBeatMapModel.setUser_beat_id(res.getInt(res.getColumnIndex(USER_BEAT_ID)));
            userBeatMapModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            userBeatMapModel.setBeat_id(res.getString(res.getColumnIndex(BEAT_ID)));
            userBeatMapModel.setIp(res.getString(res.getColumnIndex(IP)));
            userBeatMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return userBeatMapModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateUserBeatMap(UserBeatMapModel userBeatMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, userBeatMapModel.getEmail());
        contentValues.put(BEAT_ID, userBeatMapModel.getBeat_id());
        contentValues.put(IP, userBeatMapModel.getIp());
        contentValues.put(U_TS, userBeatMapModel.getU_ts());
        db.update(TABLE_NAME, contentValues, USER_BEAT_ID + "= ? ", new String[]{Integer.toString(userBeatMapModel.getUser_beat_id())});
        db.close();
        return true;
    }

    public Integer deleteUserBeatMapById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, USER_BEAT_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<UserBeatMapModel> getAllUserBeatMap() {
        ArrayList<UserBeatMapModel> array_list = new ArrayList<UserBeatMapModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                UserBeatMapModel userBeatMapModel = new UserBeatMapModel();
                userBeatMapModel.setUser_beat_id(res.getInt(res.getColumnIndex(USER_BEAT_ID)));
                userBeatMapModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
                userBeatMapModel.setBeat_id(res.getString(res.getColumnIndex(BEAT_ID)));
                userBeatMapModel.setIp(res.getString(res.getColumnIndex(IP)));
                userBeatMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(userBeatMapModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}