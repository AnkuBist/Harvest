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

import com.hgil.harvest.database.dbModels.StateModel;

import java.util.ArrayList;

public class StateTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_state";
    private static final String STATE_ID = "state_id";
    private static final String STATE_NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String COUNTRY_NAME = "country_name";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public StateTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + STATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + STATE_NAME + " TEXT UNIQUE NOT NULL, " + DESCRIPTION + " TEXT NULL, " + COUNTRY_NAME + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertState(StateModel stateModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STATE_ID, stateModel.getState_id());
        contentValues.put(STATE_NAME, stateModel.getName());
        contentValues.put(DESCRIPTION, stateModel.getDescription());
        contentValues.put(COUNTRY_NAME, stateModel.getCountry_name());
        contentValues.put(STATE, stateModel.getState());
        contentValues.put(IP, stateModel.getIp());
        contentValues.put(U_TS, stateModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public StateModel getStateById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + STATE_ID + "=" + id, null);

        StateModel stateModel = new StateModel();
        if (res.moveToFirst()) {
            stateModel.setState_id(res.getInt(res.getColumnIndex(STATE_ID)));
            stateModel.setName(res.getString(res.getColumnIndex(STATE_NAME)));
            stateModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            stateModel.setCountry_name(res.getString(res.getColumnIndex(COUNTRY_NAME)));
            stateModel.setState(res.getInt(res.getColumnIndex(STATE)));
            stateModel.setIp(res.getString(res.getColumnIndex(IP)));
            stateModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return stateModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateState(StateModel stateModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STATE_NAME, stateModel.getName());
        contentValues.put(DESCRIPTION, stateModel.getDescription());
        contentValues.put(COUNTRY_NAME, stateModel.getCountry_name());
        contentValues.put(STATE, stateModel.getState());
        contentValues.put(IP, stateModel.getIp());
        contentValues.put(U_TS, stateModel.getU_ts());
        db.update(TABLE_NAME, contentValues, STATE_ID + "= ? ", new String[]{Integer.toString(stateModel.getState_id())});
        db.close();
        return true;
    }

    public Integer deleteStateById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, STATE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<StateModel> getAllState() {
        ArrayList<StateModel> array_list = new ArrayList<StateModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                StateModel stateModel = new StateModel();
                stateModel.setState_id(res.getInt(res.getColumnIndex(STATE_ID)));
                stateModel.setName(res.getString(res.getColumnIndex(STATE_NAME)));
                stateModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                stateModel.setCountry_name(res.getString(res.getColumnIndex(COUNTRY_NAME)));
                stateModel.setState(res.getInt(res.getColumnIndex(STATE)));
                stateModel.setIp(res.getString(res.getColumnIndex(IP)));
                stateModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(stateModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}