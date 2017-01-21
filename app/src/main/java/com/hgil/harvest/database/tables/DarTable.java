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

import com.hgil.harvest.database.dbModels.DarModel;

import java.util.ArrayList;

public class DarTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_dar";
    private static final String DAR_ID = "dar_id";
    private static final String ACTIVITY_ID = "activity_id";
    private static final String DAR_DATE = "dar_date";
    private static final String OWNER_ID = "owner_id";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";
    private static final String DAR_TIME = "dar_time";
    private static final String OUTLET_ID = "outlet_id";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String BEAT_ID = "beat_id";
    private static final String BEAT_CODE = "beat_code";
    private static final String DETAILS = "details";
    private static final String DETAILS_1 = "details_1";
    private static final String DETAILS_2 = "details_2";
    private static final String DETAILS_3 = "details_3";
    private static final String DETAILS_4 = "details_4";
    private static final String DETAILS_5 = "details_5";
    private static final String DETAILS_6 = "details_6";
    private static final String DETAILS_7 = "details_7";
    private static final String DETAILS_8 = "details_8";
    private static final String DETAILS_9 = "details_9";
    private static final String DETAILS_10 = "details_10";
    private static final String DETAILS_11 = "details_11";
    private static final String DETAILS_12 = "details_12";
    private static final String DETAILS_13 = "details_13";
    private static final String DETAILS_14 = "details_14";
    private static final String DETAILS_15 = "details_15";
    private static final String DETAILS_I1 = "details_i1";
    private static final String DETAILS_I2 = "details_i2";
    private static final String DETAILS_I3 = "details_i3";
    private static final String DETAILS_I4 = "details_i4";
    private static final String DETAILS_I5 = "details_i5";
    private static final String DETAILS_D1 = "details_d1";
    private static final String DETAILS_D2 = "details_d2";
    private static final String DETAILS_D3 = "details_d3";
    private static final String DETAILS_D4 = "details_d4";
    private static final String DETAILS_D5 = "details_d5";
    private static final String CREATED_BY = "created_by";
    private static final String STATUS = "status";
    private static final String GPS_LONG = "gps_long";
    private static final String GPS_LAT = "gps_lat";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public DarTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + DAR_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + ACTIVITY_ID + " INTEGER NULL, " + DAR_DATE + " TEXT NULL, " + OWNER_ID + " TEXT NULL, " + START_TIME + " INTEGER NULL, "
                + END_TIME + " INTEGER NULL, " + DAR_TIME + " INTEGER NULL, " + OUTLET_ID + " INTEGER NULL, "
                + OUTLET_CODE + " TEXT NULL, " + SKU_ID + " INTEGER NULL, " + SKU_CODE + " TEXT NULL, "
                + BEAT_ID + " INTEGER NULL, " + BEAT_CODE + " TEXT NULL, " + DETAILS + " TEXT NULL, "
                + DETAILS_1 + " TEXT NULL, " + DETAILS_2 + " TEXT NULL, " + DETAILS_3 + " TEXT NULL, "
                + DETAILS_4 + " TEXT NULL, " + DETAILS_5 + " TEXT NULL, " + DETAILS_6 + " TEXT NULL, "
                + DETAILS_7 + " TEXT NULL, " + DETAILS_8 + " TEXT NULL, " + DETAILS_9 + " TEXT NULL, "
                + DETAILS_10 + " TEXT NULL, " + DETAILS_11 + " TEXT NULL, " + DETAILS_12 + " TEXT NULL, "
                + DETAILS_13 + " TEXT NULL, " + DETAILS_14 + " TEXT NULL, " + DETAILS_15 + " TEXT NULL, "
                + DETAILS_I1 + " INTEGER NULL, " + DETAILS_I2 + " INTEGER NULL, " + DETAILS_I3 + " INTEGER NULL, "
                + DETAILS_I4 + " INTEGER NULL, " + DETAILS_I5 + " INTEGER NULL, " + DETAILS_D1 + " REAL NULL, "
                + DETAILS_D2 + " REAL NULL, " + DETAILS_D3 + " REAL NULL, " + DETAILS_D4 + " REAL NULL, "
                + DETAILS_D5 + " REAL NULL, " + CREATED_BY + " TEXT NULL, " + STATUS + " TEXT NULL, "
                + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertDar(DarModel darModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DAR_ID, darModel.getDar_id());
        contentValues.put(ACTIVITY_ID, darModel.getActivity_id());
        contentValues.put(DAR_DATE, darModel.getDar_date());
        contentValues.put(OWNER_ID, darModel.getOwner_id());
        contentValues.put(START_TIME, darModel.getStart_time());
        contentValues.put(END_TIME, darModel.getEnd_time());
        contentValues.put(DAR_TIME, darModel.getDar_time());
        contentValues.put(OUTLET_ID, darModel.getOutlet_id());
        contentValues.put(OUTLET_CODE, darModel.getOutlet_code());
        contentValues.put(SKU_ID, darModel.getSku_id());
        contentValues.put(SKU_CODE, darModel.getSku_code());
        contentValues.put(BEAT_ID, darModel.getBeat_id());
        contentValues.put(BEAT_CODE, darModel.getBeat_code());
        contentValues.put(DETAILS, darModel.getDetails());
        contentValues.put(DETAILS_1, darModel.getDetails_1());
        contentValues.put(DETAILS_2, darModel.getDetails_2());
        contentValues.put(DETAILS_3, darModel.getDetails_3());
        contentValues.put(DETAILS_4, darModel.getDetails_4());
        contentValues.put(DETAILS_5, darModel.getDetails_5());
        contentValues.put(DETAILS_6, darModel.getDetails_6());
        contentValues.put(DETAILS_7, darModel.getDetails_7());
        contentValues.put(DETAILS_8, darModel.getDetails_8());
        contentValues.put(DETAILS_9, darModel.getDetails_9());
        contentValues.put(DETAILS_10, darModel.getDetails_10());
        contentValues.put(DETAILS_11, darModel.getDetails_11());
        contentValues.put(DETAILS_12, darModel.getDetails_12());
        contentValues.put(DETAILS_13, darModel.getDetails_13());
        contentValues.put(DETAILS_14, darModel.getDetails_14());
        contentValues.put(DETAILS_15, darModel.getDetails_15());
        contentValues.put(DETAILS_I1, darModel.getDetails_i1());
        contentValues.put(DETAILS_I2, darModel.getDetails_i2());
        contentValues.put(DETAILS_I3, darModel.getDetails_i3());
        contentValues.put(DETAILS_I4, darModel.getDetails_i4());
        contentValues.put(DETAILS_I5, darModel.getDetails_i5());
        contentValues.put(DETAILS_D1, darModel.getDetails_d1());
        contentValues.put(DETAILS_D2, darModel.getDetails_d2());
        contentValues.put(DETAILS_D3, darModel.getDetails_d3());
        contentValues.put(DETAILS_D4, darModel.getDetails_d4());
        contentValues.put(DETAILS_D5, darModel.getDetails_d5());
        contentValues.put(CREATED_BY, darModel.getCreated_by());
        contentValues.put(STATUS, darModel.getStatus());
        contentValues.put(GPS_LONG, darModel.getGps_long());
        contentValues.put(GPS_LAT, darModel.getGps_lat());
        contentValues.put(STATE, darModel.getState());
        contentValues.put(IP, darModel.getIp());
        contentValues.put(U_TS, darModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public DarModel getDarById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ACTIVITY_ID + "=" + id, null);

        DarModel darModel = new DarModel();
        if (res.moveToFirst()) {
            darModel.setDar_id(res.getLong(res.getColumnIndex(DAR_ID)));
            darModel.setActivity_id(res.getInt(res.getColumnIndex(ACTIVITY_ID)));
            darModel.setDar_date(res.getString(res.getColumnIndex(DAR_DATE)));
            darModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            darModel.setStart_time(res.getInt(res.getColumnIndex(START_TIME)));
            darModel.setEnd_time(res.getInt(res.getColumnIndex(END_TIME)));
            darModel.setDar_time(res.getInt(res.getColumnIndex(DAR_TIME)));
            darModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
            darModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            darModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            darModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            darModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
            darModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            darModel.setDetails(res.getString(res.getColumnIndex(DETAILS)));
            darModel.setDetails_1(res.getString(res.getColumnIndex(DETAILS_1)));
            darModel.setDetails_2(res.getString(res.getColumnIndex(DETAILS_2)));
            darModel.setDetails_3(res.getString(res.getColumnIndex(DETAILS_3)));
            darModel.setDetails_4(res.getString(res.getColumnIndex(DETAILS_4)));
            darModel.setDetails_5(res.getString(res.getColumnIndex(DETAILS_5)));
            darModel.setDetails_6(res.getString(res.getColumnIndex(DETAILS_6)));
            darModel.setDetails_7(res.getString(res.getColumnIndex(DETAILS_7)));
            darModel.setDetails_8(res.getString(res.getColumnIndex(DETAILS_8)));
            darModel.setDetails_9(res.getString(res.getColumnIndex(DETAILS_9)));
            darModel.setDetails_10(res.getString(res.getColumnIndex(DETAILS_10)));
            darModel.setDetails_11(res.getString(res.getColumnIndex(DETAILS_11)));
            darModel.setDetails_12(res.getString(res.getColumnIndex(DETAILS_12)));
            darModel.setDetails_13(res.getString(res.getColumnIndex(DETAILS_13)));
            darModel.setDetails_14(res.getString(res.getColumnIndex(DETAILS_14)));
            darModel.setDetails_15(res.getString(res.getColumnIndex(DETAILS_15)));
            darModel.setDetails_i1(res.getInt(res.getColumnIndex(DETAILS_I1)));
            darModel.setDetails_i2(res.getInt(res.getColumnIndex(DETAILS_I2)));
            darModel.setDetails_i3(res.getInt(res.getColumnIndex(DETAILS_I3)));
            darModel.setDetails_i4(res.getInt(res.getColumnIndex(DETAILS_I4)));
            darModel.setDetails_i5(res.getInt(res.getColumnIndex(DETAILS_I5)));
            darModel.setDetails_d1(res.getFloat(res.getColumnIndex(DETAILS_D1)));
            darModel.setDetails_d2(res.getFloat(res.getColumnIndex(DETAILS_D2)));
            darModel.setDetails_d3(res.getFloat(res.getColumnIndex(DETAILS_D3)));
            darModel.setDetails_d4(res.getFloat(res.getColumnIndex(DETAILS_D4)));
            darModel.setDetails_d5(res.getFloat(res.getColumnIndex(DETAILS_D5)));
            darModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            darModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
            darModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
            darModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
            darModel.setState(res.getInt(res.getColumnIndex(STATE)));
            darModel.setIp(res.getString(res.getColumnIndex(IP)));
            darModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return darModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateDar(DarModel darModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACTIVITY_ID, darModel.getActivity_id());
        contentValues.put(DAR_DATE, darModel.getDar_date());
        contentValues.put(OWNER_ID, darModel.getOwner_id());
        contentValues.put(START_TIME, darModel.getStart_time());
        contentValues.put(END_TIME, darModel.getEnd_time());
        contentValues.put(DAR_TIME, darModel.getDar_time());
        contentValues.put(OUTLET_ID, darModel.getOutlet_id());
        contentValues.put(OUTLET_CODE, darModel.getOutlet_code());
        contentValues.put(SKU_ID, darModel.getSku_id());
        contentValues.put(SKU_CODE, darModel.getSku_code());
        contentValues.put(BEAT_ID, darModel.getBeat_id());
        contentValues.put(BEAT_CODE, darModel.getBeat_code());
        contentValues.put(DETAILS, darModel.getDetails());
        contentValues.put(DETAILS_1, darModel.getDetails_1());
        contentValues.put(DETAILS_2, darModel.getDetails_2());
        contentValues.put(DETAILS_3, darModel.getDetails_3());
        contentValues.put(DETAILS_4, darModel.getDetails_4());
        contentValues.put(DETAILS_5, darModel.getDetails_5());
        contentValues.put(DETAILS_6, darModel.getDetails_6());
        contentValues.put(DETAILS_7, darModel.getDetails_7());
        contentValues.put(DETAILS_8, darModel.getDetails_8());
        contentValues.put(DETAILS_9, darModel.getDetails_9());
        contentValues.put(DETAILS_10, darModel.getDetails_10());
        contentValues.put(DETAILS_11, darModel.getDetails_11());
        contentValues.put(DETAILS_12, darModel.getDetails_12());
        contentValues.put(DETAILS_13, darModel.getDetails_13());
        contentValues.put(DETAILS_14, darModel.getDetails_14());
        contentValues.put(DETAILS_15, darModel.getDetails_15());
        contentValues.put(DETAILS_I1, darModel.getDetails_i1());
        contentValues.put(DETAILS_I2, darModel.getDetails_i2());
        contentValues.put(DETAILS_I3, darModel.getDetails_i3());
        contentValues.put(DETAILS_I4, darModel.getDetails_i4());
        contentValues.put(DETAILS_I5, darModel.getDetails_i5());
        contentValues.put(DETAILS_D1, darModel.getDetails_d1());
        contentValues.put(DETAILS_D2, darModel.getDetails_d2());
        contentValues.put(DETAILS_D3, darModel.getDetails_d3());
        contentValues.put(DETAILS_D4, darModel.getDetails_d4());
        contentValues.put(DETAILS_D5, darModel.getDetails_d5());
        contentValues.put(CREATED_BY, darModel.getCreated_by());
        contentValues.put(STATUS, darModel.getStatus());
        contentValues.put(GPS_LONG, darModel.getGps_long());
        contentValues.put(GPS_LAT, darModel.getGps_lat());
        contentValues.put(STATE, darModel.getState());
        contentValues.put(IP, darModel.getIp());
        contentValues.put(U_TS, darModel.getU_ts());
        db.update(TABLE_NAME, contentValues, ACTIVITY_ID + "= ? ", new String[]{Long.toString(darModel.getDar_id())});
        db.close();
        return true;
    }

    public Integer deleteDarById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ACTIVITY_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<DarModel> getAllDar() {
        ArrayList<DarModel> array_list = new ArrayList<DarModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                DarModel darModel = new DarModel();
                darModel.setDar_id(res.getLong(res.getColumnIndex(DAR_ID)));
                darModel.setActivity_id(res.getInt(res.getColumnIndex(ACTIVITY_ID)));
                darModel.setDar_date(res.getString(res.getColumnIndex(DAR_DATE)));
                darModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                darModel.setStart_time(res.getInt(res.getColumnIndex(START_TIME)));
                darModel.setEnd_time(res.getInt(res.getColumnIndex(END_TIME)));
                darModel.setDar_time(res.getInt(res.getColumnIndex(DAR_TIME)));
                darModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
                darModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                darModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                darModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                darModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
                darModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                darModel.setDetails(res.getString(res.getColumnIndex(DETAILS)));
                darModel.setDetails_1(res.getString(res.getColumnIndex(DETAILS_1)));
                darModel.setDetails_2(res.getString(res.getColumnIndex(DETAILS_2)));
                darModel.setDetails_3(res.getString(res.getColumnIndex(DETAILS_3)));
                darModel.setDetails_4(res.getString(res.getColumnIndex(DETAILS_4)));
                darModel.setDetails_5(res.getString(res.getColumnIndex(DETAILS_5)));
                darModel.setDetails_6(res.getString(res.getColumnIndex(DETAILS_6)));
                darModel.setDetails_7(res.getString(res.getColumnIndex(DETAILS_7)));
                darModel.setDetails_8(res.getString(res.getColumnIndex(DETAILS_8)));
                darModel.setDetails_9(res.getString(res.getColumnIndex(DETAILS_9)));
                darModel.setDetails_10(res.getString(res.getColumnIndex(DETAILS_10)));
                darModel.setDetails_11(res.getString(res.getColumnIndex(DETAILS_11)));
                darModel.setDetails_12(res.getString(res.getColumnIndex(DETAILS_12)));
                darModel.setDetails_13(res.getString(res.getColumnIndex(DETAILS_13)));
                darModel.setDetails_14(res.getString(res.getColumnIndex(DETAILS_14)));
                darModel.setDetails_15(res.getString(res.getColumnIndex(DETAILS_15)));
                darModel.setDetails_i1(res.getInt(res.getColumnIndex(DETAILS_I1)));
                darModel.setDetails_i2(res.getInt(res.getColumnIndex(DETAILS_I2)));
                darModel.setDetails_i3(res.getInt(res.getColumnIndex(DETAILS_I3)));
                darModel.setDetails_i4(res.getInt(res.getColumnIndex(DETAILS_I4)));
                darModel.setDetails_i5(res.getInt(res.getColumnIndex(DETAILS_I5)));
                darModel.setDetails_d1(res.getFloat(res.getColumnIndex(DETAILS_D1)));
                darModel.setDetails_d2(res.getFloat(res.getColumnIndex(DETAILS_D2)));
                darModel.setDetails_d3(res.getFloat(res.getColumnIndex(DETAILS_D3)));
                darModel.setDetails_d4(res.getFloat(res.getColumnIndex(DETAILS_D4)));
                darModel.setDetails_d5(res.getFloat(res.getColumnIndex(DETAILS_D5)));
                darModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                darModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
                darModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
                darModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
                darModel.setState(res.getInt(res.getColumnIndex(STATE)));
                darModel.setIp(res.getString(res.getColumnIndex(IP)));
                darModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(darModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}