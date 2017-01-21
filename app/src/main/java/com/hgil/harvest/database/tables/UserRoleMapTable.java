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

import com.hgil.harvest.database.dbModels.UserRoleMapModel;

import java.util.ArrayList;

public class UserRoleMapTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_user_role_map";
    private static final String USER_ROLE_ID = "user_role_id";
    private static final String EMAIL = "email";
    private static final String ROLE_ID = "role_id";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public UserRoleMapTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + USER_ROLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + EMAIL + " TEXT UNIQUE NOT NULL, " + ROLE_ID + " INTEGER UNIQUE NOT NULL, "
                + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUserRoleMap(UserRoleMapModel userRoleMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_ROLE_ID, userRoleMapModel.getUser_role_id());
        contentValues.put(EMAIL, userRoleMapModel.getEmail());
        contentValues.put(ROLE_ID, userRoleMapModel.getRole_id());
        contentValues.put(IP, userRoleMapModel.getIp());
        contentValues.put(U_TS, userRoleMapModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public UserRoleMapModel getUserRoleMapById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + USER_ROLE_ID + "=" + id, null);

        UserRoleMapModel userRoleMapModel = new UserRoleMapModel();
        if (res.moveToFirst()) {
            userRoleMapModel.setUser_role_id(res.getInt(res.getColumnIndex(USER_ROLE_ID)));
            userRoleMapModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            userRoleMapModel.setRole_id(res.getInt(res.getColumnIndex(ROLE_ID)));
            userRoleMapModel.setIp(res.getString(res.getColumnIndex(IP)));
            userRoleMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return userRoleMapModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateUserRoleMap(UserRoleMapModel userRoleMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, userRoleMapModel.getEmail());
        contentValues.put(ROLE_ID, userRoleMapModel.getRole_id());
        contentValues.put(IP, userRoleMapModel.getIp());
        contentValues.put(U_TS, userRoleMapModel.getU_ts());
        db.update(TABLE_NAME, contentValues, USER_ROLE_ID + "= ? ", new String[]{Integer.toString(userRoleMapModel.getUser_role_id())});
        db.close();
        return true;
    }

    public Integer deleteUserRoleMapById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, USER_ROLE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<UserRoleMapModel> getAllUserRoleMap() {
        ArrayList<UserRoleMapModel> array_list = new ArrayList<UserRoleMapModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                UserRoleMapModel userRoleMapModel = new UserRoleMapModel();
                userRoleMapModel.setUser_role_id(res.getInt(res.getColumnIndex(USER_ROLE_ID)));
                userRoleMapModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
                userRoleMapModel.setRole_id(res.getInt(res.getColumnIndex(ROLE_ID)));
                userRoleMapModel.setIp(res.getString(res.getColumnIndex(IP)));
                userRoleMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(userRoleMapModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}