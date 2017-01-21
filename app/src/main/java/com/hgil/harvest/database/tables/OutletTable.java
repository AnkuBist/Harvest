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

import com.hgil.harvest.database.dbModels.OutletModel;

import java.util.ArrayList;

public class OutletTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_outlet";
    private static final String OUTLET_ID = "outlet_id";
    private static final String OUTLET_CODE = "outlet_code";
    private static final String OUTLET_NAME = "name";
    private static final String OUTLET_CAT = "outlet_cat";
    private static final String OUTLET_CAT1 = "outlet_cat1";
    private static final String OUTLET_CAT2 = "outlet_cat2";
    private static final String OUTLET_CAT3 = "outlet_cat3";
    private static final String OUTLET_TYPE = "outlet_type";
    private static final String MOBILE_NO = "mobile_no";
    private static final String PHONE_NO = "phone_no";
    private static final String EMAIL_ID = "email_id";
    private static final String ADDRESS = "address";
    private static final String CITY_NAME = "city_name";
    private static final String PIN_CODE = "pin_code";
    private static final String LOCATION_CODE = "location_code";
    private static final String CR_LIMIT = "cr_limit";
    private static final String OUTSTANDING = "outstanding";
    private static final String OUTLET_GROUP_ID = "outlet_group_id";
    private static final String GPS_LONG = "gps_long";
    private static final String GPS_LAT = "gps_lat";
    private static final String SERVICE_BRANCH = "service_branch";
    private static final String SERVICE_REP = "service_rep";
    private static final String CREATED_BY = "created_by";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public OutletTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + OUTLET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + OUTLET_CODE + " TEXT NOT NULL, " + OUTLET_NAME + " TEXT NOT NULL, " + OUTLET_CAT + " TEXT NULL, "
                + OUTLET_CAT1 + " TEXT NULL, " + OUTLET_CAT2 + " TEXT NULL, " + OUTLET_CAT3 + " TEXT NULL, "
                + OUTLET_TYPE + " TEXT NULL, " + MOBILE_NO + " TEXT NULL, " + PHONE_NO + " TEXT NULL, "
                + EMAIL_ID + " TEXT NULL, " + ADDRESS + " TEXT NULL, " + CITY_NAME + " TEXT NULL, " + PIN_CODE + " TEXT NULL, "
                + LOCATION_CODE + " TEXT NULL, " + CR_LIMIT + " REAL NULL, " + OUTSTANDING + " REAL NOT NULL, "
                + OUTLET_GROUP_ID + " TEXT NULL, " + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, "
                + SERVICE_BRANCH + " TEXT NULL, " + SERVICE_REP + " TEXT NULL, " + CREATED_BY + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOutlet(OutletModel outletModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OUTLET_ID, outletModel.getOutlet_id());
        contentValues.put(OUTLET_CODE, outletModel.getOutlet_code());
        contentValues.put(OUTLET_NAME, outletModel.getName());
        contentValues.put(OUTLET_CAT, outletModel.getOutlet_cat());
        contentValues.put(OUTLET_CAT1, outletModel.getOutlet_cat1());
        contentValues.put(OUTLET_CAT2, outletModel.getOutlet_cat2());
        contentValues.put(OUTLET_CAT3, outletModel.getOutlet_cat3());
        contentValues.put(OUTLET_TYPE, outletModel.getOutlet_type());
        contentValues.put(MOBILE_NO, outletModel.getMobile_no());
        contentValues.put(PHONE_NO, outletModel.getPhone_no());
        contentValues.put(EMAIL_ID, outletModel.getEmail_id());
        contentValues.put(ADDRESS, outletModel.getAddress());
        contentValues.put(CITY_NAME, outletModel.getCity_name());
        contentValues.put(PIN_CODE, outletModel.getPin_code());
        contentValues.put(LOCATION_CODE, outletModel.getLocation_code());
        contentValues.put(CR_LIMIT, outletModel.getCr_limit());
        contentValues.put(OUTSTANDING, outletModel.getOutstanding());
        contentValues.put(OUTLET_GROUP_ID, outletModel.getOutlet_group_id());
        contentValues.put(GPS_LONG, outletModel.getGps_long());
        contentValues.put(GPS_LAT, outletModel.getGps_lat());
        contentValues.put(SERVICE_BRANCH, outletModel.getService_branch());
        contentValues.put(SERVICE_REP, outletModel.getService_rep());
        contentValues.put(CREATED_BY, outletModel.getCreated_by());
        contentValues.put(STATE, outletModel.getState());
        contentValues.put(IP, outletModel.getIp());
        contentValues.put(U_TS, outletModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OutletModel getOutletById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + OUTLET_ID + "=" + id, null);

        OutletModel outletModel = new OutletModel();
        if (res.moveToFirst()) {
            outletModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
            outletModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
            outletModel.setName(res.getString(res.getColumnIndex(OUTLET_NAME)));
            outletModel.setOutlet_cat(res.getString(res.getColumnIndex(OUTLET_CAT)));
            outletModel.setOutlet_cat1(res.getString(res.getColumnIndex(OUTLET_CAT1)));
            outletModel.setOutlet_cat2(res.getString(res.getColumnIndex(OUTLET_CAT2)));
            outletModel.setOutlet_cat3(res.getString(res.getColumnIndex(OUTLET_CAT3)));
            outletModel.setOutlet_type(res.getString(res.getColumnIndex(OUTLET_TYPE)));
            outletModel.setMobile_no(res.getString(res.getColumnIndex(MOBILE_NO)));
            outletModel.setPhone_no(res.getString(res.getColumnIndex(PHONE_NO)));
            outletModel.setEmail_id(res.getString(res.getColumnIndex(EMAIL_ID)));
            outletModel.setAddress(res.getString(res.getColumnIndex(ADDRESS)));
            outletModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
            outletModel.setPin_code(res.getString(res.getColumnIndex(PIN_CODE)));
            outletModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
            outletModel.setCr_limit(res.getFloat(res.getColumnIndex(CR_LIMIT)));
            outletModel.setOutstanding(res.getFloat(res.getColumnIndex(OUTSTANDING)));
            outletModel.setOutlet_group_id(res.getString(res.getColumnIndex(OUTLET_GROUP_ID)));
            outletModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
            outletModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
            outletModel.setService_branch(res.getString(res.getColumnIndex(SERVICE_BRANCH)));
            outletModel.setService_rep(res.getString(res.getColumnIndex(SERVICE_REP)));
            outletModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            outletModel.setState(res.getInt(res.getColumnIndex(STATE)));
            outletModel.setIp(res.getString(res.getColumnIndex(IP)));
            outletModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return outletModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOutlet(OutletModel outletModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OUTLET_CODE, outletModel.getOutlet_code());
        contentValues.put(OUTLET_NAME, outletModel.getName());
        contentValues.put(OUTLET_CAT, outletModel.getOutlet_cat());
        contentValues.put(OUTLET_CAT1, outletModel.getOutlet_cat1());
        contentValues.put(OUTLET_CAT2, outletModel.getOutlet_cat2());
        contentValues.put(OUTLET_CAT3, outletModel.getOutlet_cat3());
        contentValues.put(OUTLET_TYPE, outletModel.getOutlet_type());
        contentValues.put(MOBILE_NO, outletModel.getMobile_no());
        contentValues.put(PHONE_NO, outletModel.getPhone_no());
        contentValues.put(EMAIL_ID, outletModel.getEmail_id());
        contentValues.put(ADDRESS, outletModel.getAddress());
        contentValues.put(CITY_NAME, outletModel.getCity_name());
        contentValues.put(PIN_CODE, outletModel.getPin_code());
        contentValues.put(LOCATION_CODE, outletModel.getLocation_code());
        contentValues.put(CR_LIMIT, outletModel.getCr_limit());
        contentValues.put(OUTSTANDING, outletModel.getOutstanding());
        contentValues.put(OUTLET_GROUP_ID, outletModel.getOutlet_group_id());
        contentValues.put(GPS_LONG, outletModel.getGps_long());
        contentValues.put(GPS_LAT, outletModel.getGps_lat());
        contentValues.put(SERVICE_BRANCH, outletModel.getService_branch());
        contentValues.put(SERVICE_REP, outletModel.getService_rep());
        contentValues.put(CREATED_BY, outletModel.getCreated_by());
        contentValues.put(STATE, outletModel.getState());
        contentValues.put(IP, outletModel.getIp());
        contentValues.put(U_TS, outletModel.getU_ts());
        db.update(TABLE_NAME, contentValues, OUTLET_ID + "= ? ", new String[]{Integer.toString(outletModel.getOutlet_id())});
        db.close();
        return true;
    }

    public Integer deleteOutletById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, OUTLET_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OutletModel> getAllOutlet() {
        ArrayList<OutletModel> array_list = new ArrayList<OutletModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OutletModel outletModel = new OutletModel();
                outletModel.setOutlet_id(res.getInt(res.getColumnIndex(OUTLET_ID)));
                outletModel.setOutlet_code(res.getString(res.getColumnIndex(OUTLET_CODE)));
                outletModel.setName(res.getString(res.getColumnIndex(OUTLET_NAME)));
                outletModel.setOutlet_cat(res.getString(res.getColumnIndex(OUTLET_CAT)));
                outletModel.setOutlet_cat1(res.getString(res.getColumnIndex(OUTLET_CAT1)));
                outletModel.setOutlet_cat2(res.getString(res.getColumnIndex(OUTLET_CAT2)));
                outletModel.setOutlet_cat3(res.getString(res.getColumnIndex(OUTLET_CAT3)));
                outletModel.setOutlet_type(res.getString(res.getColumnIndex(OUTLET_TYPE)));
                outletModel.setMobile_no(res.getString(res.getColumnIndex(MOBILE_NO)));
                outletModel.setPhone_no(res.getString(res.getColumnIndex(PHONE_NO)));
                outletModel.setEmail_id(res.getString(res.getColumnIndex(EMAIL_ID)));
                outletModel.setAddress(res.getString(res.getColumnIndex(ADDRESS)));
                outletModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
                outletModel.setPin_code(res.getString(res.getColumnIndex(PIN_CODE)));
                outletModel.setLocation_code(res.getString(res.getColumnIndex(LOCATION_CODE)));
                outletModel.setCr_limit(res.getFloat(res.getColumnIndex(CR_LIMIT)));
                outletModel.setOutstanding(res.getFloat(res.getColumnIndex(OUTSTANDING)));
                outletModel.setOutlet_group_id(res.getString(res.getColumnIndex(OUTLET_GROUP_ID)));
                outletModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
                outletModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
                outletModel.setService_branch(res.getString(res.getColumnIndex(SERVICE_BRANCH)));
                outletModel.setService_rep(res.getString(res.getColumnIndex(SERVICE_REP)));
                outletModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                outletModel.setState(res.getInt(res.getColumnIndex(STATE)));
                outletModel.setIp(res.getString(res.getColumnIndex(IP)));
                outletModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(outletModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}