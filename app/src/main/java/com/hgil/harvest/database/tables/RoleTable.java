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

import com.hgil.harvest.database.dbModels.RoleModel;

import java.util.ArrayList;

public class RoleTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_role";
    private static final String ROLE_ID = "role_id";
    private static final String ROLE_NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public RoleTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + ROLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + ROLE_NAME + " TEXT UNIQUE NULL, " + DESCRIPTION + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertRole(RoleModel roleModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLE_ID, roleModel.getRole_id());
        contentValues.put(ROLE_NAME, roleModel.getName());
        contentValues.put(DESCRIPTION, roleModel.getDescription());
        contentValues.put(STATE, roleModel.getState());
        contentValues.put(IP, roleModel.getIp());
        contentValues.put(U_TS, roleModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public RoleModel getRoleById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ROLE_ID + "=" + id, null);

        RoleModel roleModel = new RoleModel();
        if (res.moveToFirst()) {
            roleModel.setRole_id(res.getInt(res.getColumnIndex(ROLE_ID)));
            roleModel.setName(res.getString(res.getColumnIndex(ROLE_NAME)));
            roleModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            roleModel.setState(res.getInt(res.getColumnIndex(STATE)));
            roleModel.setIp(res.getString(res.getColumnIndex(IP)));
            roleModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return roleModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateRole(RoleModel roleModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLE_NAME, roleModel.getName());
        contentValues.put(DESCRIPTION, roleModel.getDescription());
        contentValues.put(STATE, roleModel.getState());
        contentValues.put(IP, roleModel.getIp());
        contentValues.put(U_TS, roleModel.getU_ts());
        db.update(TABLE_NAME, contentValues, ROLE_ID + "= ? ", new String[]{Integer.toString(roleModel.getRole_id())});
        db.close();
        return true;
    }

    public Integer deleteRoleById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ROLE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<RoleModel> getAllRole() {
        ArrayList<RoleModel> array_list = new ArrayList<RoleModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                RoleModel roleModel = new RoleModel();
                roleModel.setRole_id(res.getInt(res.getColumnIndex(ROLE_ID)));
                roleModel.setName(res.getString(res.getColumnIndex(ROLE_NAME)));
                roleModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                roleModel.setState(res.getInt(res.getColumnIndex(STATE)));
                roleModel.setIp(res.getString(res.getColumnIndex(IP)));
                roleModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(roleModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}