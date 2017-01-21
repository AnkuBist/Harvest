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

import com.hgil.harvest.database.dbModels.BeatModel;

import java.util.ArrayList;

public class BeatTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_beat";
    private static final String BEAT_ID = "beat_id";
    private static final String BEAT_NAME = "name";
    private static final String PAR_BEAT_ID = "par_beat_id";
    private static final String BEAT_CODE = "beat_code";
    private static final String OUTLET_COUNT = "outlet_count";
    private static final String CITY_NAME = "city_name";
    private static final String LOCATION_CODE = "location_code";
    private static final String CREATED_BY = "created_by";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public BeatTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + BEAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + BEAT_NAME + " TEXT UNIQUE NOT NULL, " + PAR_BEAT_ID + " INTEGER NULL, " + BEAT_CODE + " TEXT NOT NULL, " + OUTLET_COUNT + " INTEGER NULL, "
                + CITY_NAME + " TEXT NULL, " + LOCATION_CODE + " TEXT NULL, " + CREATED_BY + " TEXT NULL, " + STATE + " INTEGER NULL, "
                + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertBeat(BeatModel beatModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEAT_ID, beatModel.getBeat_id());
        contentValues.put(BEAT_NAME, beatModel.getName());
        contentValues.put(PAR_BEAT_ID, beatModel.getPar_beat_id());
        contentValues.put(BEAT_CODE, beatModel.getBeat_code());
        contentValues.put(OUTLET_COUNT, beatModel.getOutlet_count());
        contentValues.put(CITY_NAME, beatModel.getCity_name());
        contentValues.put(LOCATION_CODE, beatModel.getLocation_code());
        contentValues.put(CREATED_BY, beatModel.getCreated_by());
        contentValues.put(STATE, beatModel.getState());
        contentValues.put(IP, beatModel.getIp());
        contentValues.put(U_TS, beatModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public BeatModel getBeatById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + BEAT_ID + "=" + id, null);

        BeatModel beatModel = new BeatModel();
        if (res.moveToFirst()) {
            beatModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
            beatModel.setName(res.getString(res.getColumnIndex(BEAT_NAME)));
            beatModel.setPar_beat_id(res.getInt(res.getColumnIndex(PAR_BEAT_ID)));
            beatModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            beatModel.setOutlet_count(res.getInt(res.getColumnIndex(OUTLET_COUNT)));
            beatModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
            beatModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
            beatModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            beatModel.setState(res.getInt(res.getColumnIndex(STATE)));
            beatModel.setIp(res.getString(res.getColumnIndex(IP)));
            beatModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return beatModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateBeat(BeatModel beatModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEAT_NAME, beatModel.getName());
        contentValues.put(PAR_BEAT_ID, beatModel.getPar_beat_id());
        contentValues.put(BEAT_CODE, beatModel.getBeat_code());
        contentValues.put(OUTLET_COUNT, beatModel.getOutlet_count());
        contentValues.put(CITY_NAME, beatModel.getCity_name());
        contentValues.put(LOCATION_CODE, beatModel.getLocation_code());
        contentValues.put(CREATED_BY, beatModel.getCreated_by());
        contentValues.put(STATE, beatModel.getState());
        contentValues.put(IP, beatModel.getIp());
        contentValues.put(U_TS, beatModel.getU_ts());
        db.update(TABLE_NAME, contentValues, BEAT_ID + "= ? ", new String[]{Integer.toString(beatModel.getBeat_id())});
        db.close();
        return true;
    }

    public Integer deleteBeatById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, BEAT_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<BeatModel> getAllBeat() {
        ArrayList<BeatModel> array_list = new ArrayList<BeatModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                BeatModel beatModel = new BeatModel();
                beatModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
                beatModel.setName(res.getString(res.getColumnIndex(BEAT_NAME)));
                beatModel.setPar_beat_id(res.getInt(res.getColumnIndex(PAR_BEAT_ID)));
                beatModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                beatModel.setOutlet_count(res.getInt(res.getColumnIndex(OUTLET_COUNT)));
                beatModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
                beatModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
                beatModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                beatModel.setState(res.getInt(res.getColumnIndex(STATE)));
                beatModel.setIp(res.getString(res.getColumnIndex(IP)));
                beatModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(beatModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}