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

import com.hgil.harvest.database.dbModels.TripHeaderModel;

import java.util.ArrayList;

public class TripHeaderTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_trip_header";
    private static final String TRIP_ID = "trip_id";
    private static final String OWNER_ID = "owner_id";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";
    private static final String VEHICLE_ID = "vehicle_id";
    private static final String VEHICLE_TYPE = "vehicle_type";
    private static final String VEHICLE_NAME = "vehicle_name";
    private static final String DRIVER_NAME = "driver_name";
    private static final String ALT_DRIVER_NAME = "alt_driver_name";
    private static final String START_METER = "start_meter";
    private static final String END_METER = "end_meter";
    private static final String VERIFIED_BY = "verified_by";
    private static final String TRIP_STATUS = "trip_status";
    private static final String VEHICLE_STATUS = "vehicle_status";
    private static final String REF_ID = "ref_id";
    private static final String LOADED_QTY = "loaded_qty";
    private static final String CURRENT_QTY = "current_qty";
    private static final String RETURNED_QTY = "returned_qty";
    private static final String DAMAGED_QTY = "damaged_qty";
    private static final String CLOSING_QTY = "closing_qty";
    private static final String SCHEME_QTY = "scheme_qty";
    private static final String D1 = "d1";
    private static final String D2 = "d2";
    private static final String D3 = "d3";
    private static final String D4 = "d4";
    private static final String D5 = "d5";
    private static final String D6 = "d6";
    private static final String T1 = "t1";
    private static final String T2 = "t2";
    private static final String T3 = "t3";
    private static final String T4 = "t4";
    private static final String T5 = "t5";
    private static final String T6 = "t6";
    private static final String CREATED_BY = "created_by";
    private static final String GPS_LAT = "gps_long";
    private static final String GPS_LONG = "gps_lat";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public TripHeaderTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + TRIP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + OWNER_ID + " TEXT NULL, " + START_TIME + " TEXT NULL, " + END_TIME + " TEXT NULL, "
                + VEHICLE_ID + " TEXT NULL, " + VEHICLE_TYPE + " TEXT NULL, " + VEHICLE_NAME + " TEXT NULL, "
                + DRIVER_NAME + " TEXT NULL, " + ALT_DRIVER_NAME + " TEXT NULL, " + START_METER + " REAL NULL, "
                + END_METER + " REAL NULL, " + VERIFIED_BY + " TEXT NULL, " + TRIP_STATUS + " TEXT NULL, "
                + VEHICLE_STATUS + " TEXT NULL, " + REF_ID + " TEXT NULL, " + LOADED_QTY + " REAL NULL, "
                + CURRENT_QTY + " REAL NULL, " + RETURNED_QTY + " REAL NULL, " + DAMAGED_QTY + " REAL NULL, "
                + CLOSING_QTY + " REAL NULL, " + SCHEME_QTY + " REAL NULL, " + D1 + " REAL NULL, " + D2 + " REAL NULL, "
                + D3 + " REAL NULL, " + D4 + " REAL NULL, " + D5 + " REAL NULL, " + D6 + " REAL NULL, " + T1 + " TEXT NULL, "
                + T2 + " TEXT NULL, " + T3 + " TEXT NULL, " + T4 + " TEXT NULL, " + T5 + " TEXT NULL, " + T6 + " TEXT NULL, "
                + CREATED_BY + " TEXT NULL, " + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertTripHeader(TripHeaderModel tripHeaderModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TRIP_ID, tripHeaderModel.getTrip_id());
        contentValues.put(OWNER_ID, tripHeaderModel.getOwner_id());
        contentValues.put(START_TIME, tripHeaderModel.getStart_time());
        contentValues.put(END_TIME, tripHeaderModel.getEnd_time());
        contentValues.put(VEHICLE_ID, tripHeaderModel.getVehicle_id());
        contentValues.put(VEHICLE_TYPE, tripHeaderModel.getVehicle_type());
        contentValues.put(VEHICLE_NAME, tripHeaderModel.getVehicle_name());
        contentValues.put(DRIVER_NAME, tripHeaderModel.getDriver_name());
        contentValues.put(ALT_DRIVER_NAME, tripHeaderModel.getAlt_driver_name());
        contentValues.put(START_METER, tripHeaderModel.getStart_meter());
        contentValues.put(END_METER, tripHeaderModel.getEnd_meter());
        contentValues.put(VERIFIED_BY, tripHeaderModel.getVerified_by());
        contentValues.put(TRIP_STATUS, tripHeaderModel.getTrip_status());
        contentValues.put(VEHICLE_STATUS, tripHeaderModel.getVehicle_status());
        contentValues.put(REF_ID, tripHeaderModel.getRef_id());
        contentValues.put(LOADED_QTY, tripHeaderModel.getLoaded_qty());
        contentValues.put(CURRENT_QTY, tripHeaderModel.getCurrent_qty());
        contentValues.put(RETURNED_QTY, tripHeaderModel.getReturned_qty());
        contentValues.put(DAMAGED_QTY, tripHeaderModel.getDamaged_qty());
        contentValues.put(CLOSING_QTY, tripHeaderModel.getClosing_qty());
        contentValues.put(SCHEME_QTY, tripHeaderModel.getScheme_qty());
        contentValues.put(D1, tripHeaderModel.getD1());
        contentValues.put(D2, tripHeaderModel.getD2());
        contentValues.put(D3, tripHeaderModel.getD3());
        contentValues.put(D4, tripHeaderModel.getD4());
        contentValues.put(D5, tripHeaderModel.getD5());
        contentValues.put(D6, tripHeaderModel.getD6());
        contentValues.put(T1, tripHeaderModel.getT1());
        contentValues.put(T2, tripHeaderModel.getT2());
        contentValues.put(T3, tripHeaderModel.getT3());
        contentValues.put(T4, tripHeaderModel.getT4());
        contentValues.put(T5, tripHeaderModel.getT5());
        contentValues.put(T6, tripHeaderModel.getT6());
        contentValues.put(CREATED_BY, tripHeaderModel.getCreated_by());
        contentValues.put(GPS_LAT, tripHeaderModel.getGps_lat());
        contentValues.put(GPS_LONG, tripHeaderModel.getGps_long());
        contentValues.put(STATE, tripHeaderModel.getState());
        contentValues.put(IP, tripHeaderModel.getIp());
        contentValues.put(U_TS, tripHeaderModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public TripHeaderModel getTripHeaderById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TRIP_ID + "=" + id, null);

        TripHeaderModel tripHeaderModel = new TripHeaderModel();
        if (res.moveToFirst()) {
            tripHeaderModel.setTrip_id(res.getLong(res.getColumnIndex(TRIP_ID)));
            tripHeaderModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            tripHeaderModel.setStart_time(res.getString(res.getColumnIndex(START_TIME)));
            tripHeaderModel.setEnd_time(res.getString(res.getColumnIndex(END_TIME)));
            tripHeaderModel.setVehicle_id(res.getString(res.getColumnIndex(VEHICLE_ID)));
            tripHeaderModel.setVehicle_type(res.getString(res.getColumnIndex(VEHICLE_TYPE)));
            tripHeaderModel.setVehicle_name(res.getString(res.getColumnIndex(VEHICLE_NAME)));
            tripHeaderModel.setDriver_name(res.getString(res.getColumnIndex(DRIVER_NAME)));
            tripHeaderModel.setAlt_driver_name(res.getString(res.getColumnIndex(ALT_DRIVER_NAME)));
            tripHeaderModel.setStart_meter(res.getFloat(res.getColumnIndex(START_METER)));
            tripHeaderModel.setEnd_meter(res.getFloat(res.getColumnIndex(END_METER)));
            tripHeaderModel.setVerified_by(res.getString(res.getColumnIndex(VERIFIED_BY)));
            tripHeaderModel.setTrip_status(res.getString(res.getColumnIndex(TRIP_STATUS)));
            tripHeaderModel.setVehicle_status(res.getString(res.getColumnIndex(VEHICLE_STATUS)));
            tripHeaderModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
            tripHeaderModel.setLoaded_qty(res.getFloat(res.getColumnIndex(LOADED_QTY)));
            tripHeaderModel.setCurrent_qty(res.getFloat(res.getColumnIndex(CURRENT_QTY)));
            tripHeaderModel.setReturned_qty(res.getFloat(res.getColumnIndex(RETURNED_QTY)));
            tripHeaderModel.setDamaged_qty(res.getFloat(res.getColumnIndex(DAMAGED_QTY)));
            tripHeaderModel.setClosing_qty(res.getFloat(res.getColumnIndex(CLOSING_QTY)));
            tripHeaderModel.setScheme_qty(res.getFloat(res.getColumnIndex(SCHEME_QTY)));
            tripHeaderModel.setD1(res.getFloat(res.getColumnIndex(D1)));
            tripHeaderModel.setD2(res.getFloat(res.getColumnIndex(D2)));
            tripHeaderModel.setD3(res.getFloat(res.getColumnIndex(D3)));
            tripHeaderModel.setD4(res.getFloat(res.getColumnIndex(D4)));
            tripHeaderModel.setD5(res.getFloat(res.getColumnIndex(D5)));
            tripHeaderModel.setD6(res.getFloat(res.getColumnIndex(D6)));
            tripHeaderModel.setT1(res.getString(res.getColumnIndex(T1)));
            tripHeaderModel.setT2(res.getString(res.getColumnIndex(T2)));
            tripHeaderModel.setT3(res.getString(res.getColumnIndex(T3)));
            tripHeaderModel.setT4(res.getString(res.getColumnIndex(T4)));
            tripHeaderModel.setT5(res.getString(res.getColumnIndex(T5)));
            tripHeaderModel.setT6(res.getString(res.getColumnIndex(T6)));
            tripHeaderModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            tripHeaderModel.setGps_long(res.getString(res.getColumnIndex(GPS_LAT)));
            tripHeaderModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LONG)));
            tripHeaderModel.setState(res.getInt(res.getColumnIndex(STATE)));
            tripHeaderModel.setIp(res.getString(res.getColumnIndex(IP)));
            tripHeaderModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return tripHeaderModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateTripHeader(TripHeaderModel tripHeaderModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OWNER_ID, tripHeaderModel.getOwner_id());
        contentValues.put(START_TIME, tripHeaderModel.getStart_time());
        contentValues.put(END_TIME, tripHeaderModel.getEnd_time());
        contentValues.put(VEHICLE_ID, tripHeaderModel.getVehicle_id());
        contentValues.put(VEHICLE_TYPE, tripHeaderModel.getVehicle_type());
        contentValues.put(VEHICLE_NAME, tripHeaderModel.getVehicle_name());
        contentValues.put(DRIVER_NAME, tripHeaderModel.getDriver_name());
        contentValues.put(ALT_DRIVER_NAME, tripHeaderModel.getAlt_driver_name());
        contentValues.put(START_METER, tripHeaderModel.getStart_meter());
        contentValues.put(END_METER, tripHeaderModel.getEnd_meter());
        contentValues.put(VERIFIED_BY, tripHeaderModel.getVerified_by());
        contentValues.put(TRIP_STATUS, tripHeaderModel.getTrip_status());
        contentValues.put(VEHICLE_STATUS, tripHeaderModel.getVehicle_status());
        contentValues.put(REF_ID, tripHeaderModel.getRef_id());
        contentValues.put(LOADED_QTY, tripHeaderModel.getLoaded_qty());
        contentValues.put(CURRENT_QTY, tripHeaderModel.getCurrent_qty());
        contentValues.put(RETURNED_QTY, tripHeaderModel.getReturned_qty());
        contentValues.put(DAMAGED_QTY, tripHeaderModel.getDamaged_qty());
        contentValues.put(CLOSING_QTY, tripHeaderModel.getClosing_qty());
        contentValues.put(SCHEME_QTY, tripHeaderModel.getScheme_qty());
        contentValues.put(D1, tripHeaderModel.getD1());
        contentValues.put(D2, tripHeaderModel.getD2());
        contentValues.put(D3, tripHeaderModel.getD3());
        contentValues.put(D4, tripHeaderModel.getD4());
        contentValues.put(D5, tripHeaderModel.getD5());
        contentValues.put(D6, tripHeaderModel.getD6());
        contentValues.put(T1, tripHeaderModel.getT1());
        contentValues.put(T2, tripHeaderModel.getT2());
        contentValues.put(T3, tripHeaderModel.getT3());
        contentValues.put(T4, tripHeaderModel.getT4());
        contentValues.put(T5, tripHeaderModel.getT5());
        contentValues.put(T6, tripHeaderModel.getT6());
        contentValues.put(CREATED_BY, tripHeaderModel.getCreated_by());
        contentValues.put(GPS_LAT, tripHeaderModel.getGps_lat());
        contentValues.put(GPS_LONG, tripHeaderModel.getGps_long());
        contentValues.put(STATE, tripHeaderModel.getState());
        contentValues.put(IP, tripHeaderModel.getIp());
        contentValues.put(U_TS, tripHeaderModel.getU_ts());
        db.update(TABLE_NAME, contentValues, TRIP_ID + "= ? ", new String[]{Long.toString(tripHeaderModel.getTrip_id())});
        db.close();
        return true;
    }

    public Integer deleteTripHeaderById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, TRIP_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<TripHeaderModel> getAllTripHeader() {
        ArrayList<TripHeaderModel> array_list = new ArrayList<TripHeaderModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                TripHeaderModel tripHeaderModel = new TripHeaderModel();
                tripHeaderModel.setTrip_id(res.getLong(res.getColumnIndex(TRIP_ID)));
                tripHeaderModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                tripHeaderModel.setStart_time(res.getString(res.getColumnIndex(START_TIME)));
                tripHeaderModel.setEnd_time(res.getString(res.getColumnIndex(END_TIME)));
                tripHeaderModel.setVehicle_id(res.getString(res.getColumnIndex(VEHICLE_ID)));
                tripHeaderModel.setVehicle_type(res.getString(res.getColumnIndex(VEHICLE_TYPE)));
                tripHeaderModel.setVehicle_name(res.getString(res.getColumnIndex(VEHICLE_NAME)));
                tripHeaderModel.setDriver_name(res.getString(res.getColumnIndex(DRIVER_NAME)));
                tripHeaderModel.setAlt_driver_name(res.getString(res.getColumnIndex(ALT_DRIVER_NAME)));
                tripHeaderModel.setStart_meter(res.getFloat(res.getColumnIndex(START_METER)));
                tripHeaderModel.setEnd_meter(res.getFloat(res.getColumnIndex(END_METER)));
                tripHeaderModel.setVerified_by(res.getString(res.getColumnIndex(VERIFIED_BY)));
                tripHeaderModel.setTrip_status(res.getString(res.getColumnIndex(TRIP_STATUS)));
                tripHeaderModel.setVehicle_status(res.getString(res.getColumnIndex(VEHICLE_STATUS)));
                tripHeaderModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
                tripHeaderModel.setLoaded_qty(res.getFloat(res.getColumnIndex(LOADED_QTY)));
                tripHeaderModel.setCurrent_qty(res.getFloat(res.getColumnIndex(CURRENT_QTY)));
                tripHeaderModel.setReturned_qty(res.getFloat(res.getColumnIndex(RETURNED_QTY)));
                tripHeaderModel.setDamaged_qty(res.getFloat(res.getColumnIndex(DAMAGED_QTY)));
                tripHeaderModel.setClosing_qty(res.getFloat(res.getColumnIndex(CLOSING_QTY)));
                tripHeaderModel.setScheme_qty(res.getFloat(res.getColumnIndex(SCHEME_QTY)));
                tripHeaderModel.setD1(res.getFloat(res.getColumnIndex(D1)));
                tripHeaderModel.setD2(res.getFloat(res.getColumnIndex(D2)));
                tripHeaderModel.setD3(res.getFloat(res.getColumnIndex(D3)));
                tripHeaderModel.setD4(res.getFloat(res.getColumnIndex(D4)));
                tripHeaderModel.setD5(res.getFloat(res.getColumnIndex(D5)));
                tripHeaderModel.setD6(res.getFloat(res.getColumnIndex(D6)));
                tripHeaderModel.setT1(res.getString(res.getColumnIndex(T1)));
                tripHeaderModel.setT2(res.getString(res.getColumnIndex(T2)));
                tripHeaderModel.setT3(res.getString(res.getColumnIndex(T3)));
                tripHeaderModel.setT4(res.getString(res.getColumnIndex(T4)));
                tripHeaderModel.setT5(res.getString(res.getColumnIndex(T5)));
                tripHeaderModel.setT6(res.getString(res.getColumnIndex(T6)));
                tripHeaderModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                tripHeaderModel.setGps_long(res.getString(res.getColumnIndex(GPS_LAT)));
                tripHeaderModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LONG)));
                tripHeaderModel.setState(res.getInt(res.getColumnIndex(STATE)));
                tripHeaderModel.setIp(res.getString(res.getColumnIndex(IP)));
                tripHeaderModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(tripHeaderModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}