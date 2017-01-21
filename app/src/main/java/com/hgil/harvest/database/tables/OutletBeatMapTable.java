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

import com.hgil.harvest.database.dbModels.OutletBeatMapModel;

import java.util.ArrayList;

public class OutletBeatMapTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_outlet_beat_map";
    private static final String OUTLET_MAP_ID = "outlet_map_id";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String BEAT_NAME = "beat_name";
    private static final String MAP_ORDER = "map_order";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public OutletBeatMapTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + OUTLET_MAP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + OUTLET_CODE + " TEXT UNIQUE NOT NULL, " + BEAT_NAME + " TEXT NOT NULL, " + MAP_ORDER + " INTEGER NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOutletBeatMap(OutletBeatMapModel outletBeatMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OUTLET_MAP_ID, outletBeatMapModel.getOutlet_map_id());
        contentValues.put(OUTLET_CODE, outletBeatMapModel.getOutlet_code());
        contentValues.put(BEAT_NAME, outletBeatMapModel.getBeat_name());
        contentValues.put(MAP_ORDER, outletBeatMapModel.getMap_order());
        contentValues.put(STATE, outletBeatMapModel.getState());
        contentValues.put(IP, outletBeatMapModel.getIp());
        contentValues.put(U_TS, outletBeatMapModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OutletBeatMapModel getOutletBeatMapById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + OUTLET_MAP_ID + "=" + id, null);

        OutletBeatMapModel outletBeatMapModel = new OutletBeatMapModel();
        if (res.moveToFirst()) {
            outletBeatMapModel.setOutlet_map_id(res.getInt(res.getColumnIndex(OUTLET_MAP_ID)));
            outletBeatMapModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            outletBeatMapModel.setBeat_name(res.getString(res.getColumnIndex(BEAT_NAME)));
            outletBeatMapModel.setMap_order(res.getInt(res.getColumnIndex(MAP_ORDER)));
            outletBeatMapModel.setState(res.getInt(res.getColumnIndex(STATE)));
            outletBeatMapModel.setIp(res.getString(res.getColumnIndex(IP)));
            outletBeatMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return outletBeatMapModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOutletBeatMap(OutletBeatMapModel outletBeatMapModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OUTLET_CODE, outletBeatMapModel.getOutlet_code());
        contentValues.put(BEAT_NAME, outletBeatMapModel.getBeat_name());
        contentValues.put(MAP_ORDER, outletBeatMapModel.getMap_order());
        contentValues.put(STATE, outletBeatMapModel.getState());
        contentValues.put(IP, outletBeatMapModel.getIp());
        contentValues.put(U_TS, outletBeatMapModel.getU_ts());
        db.update(TABLE_NAME, contentValues, OUTLET_MAP_ID + "= ? ", new String[]{Integer.toString(outletBeatMapModel.getOutlet_map_id())});
        db.close();
        return true;
    }

    public Integer deleteOutletBeatMapById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, OUTLET_MAP_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OutletBeatMapModel> getAllOutletBeatMap() {
        ArrayList<OutletBeatMapModel> array_list = new ArrayList<OutletBeatMapModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OutletBeatMapModel outletBeatMapModel = new OutletBeatMapModel();
                outletBeatMapModel.setOutlet_map_id(res.getInt(res.getColumnIndex(OUTLET_MAP_ID)));
                outletBeatMapModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                outletBeatMapModel.setBeat_name(res.getString(res.getColumnIndex(BEAT_NAME)));
                outletBeatMapModel.setMap_order(res.getInt(res.getColumnIndex(MAP_ORDER)));
                outletBeatMapModel.setState(res.getInt(res.getColumnIndex(STATE)));
                outletBeatMapModel.setIp(res.getString(res.getColumnIndex(IP)));
                outletBeatMapModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(outletBeatMapModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}