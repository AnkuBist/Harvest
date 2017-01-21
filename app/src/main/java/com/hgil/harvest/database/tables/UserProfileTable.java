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

import com.hgil.harvest.database.dbModels.UserProfileModel;

import java.util.ArrayList;

public class UserProfileTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_user_profile";
    private static final String USER_PROFILE_ID = "user_profile_id";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String USER_CODE = "user_code";
    private static final String USER_TYPE = "user_type";
    private static final String DEVICE_ID = "device_id";
    private static final String DEVICE_TYPE = "device_type";
    private static final String DEVICE_ID_1 = "device_id_1";
    private static final String DEVICE_TYPE_1 = "device_type_1";
    private static final String DEVICE_ID_2 = "device_id_2";
    private static final String DEVICE_TYPE_2 = "device_type_2";
    private static final String ADDRESS = "address";
    private static final String CITY_NAME = "city_name";
    private static final String ORDERS_SELF = "orders_self";
    private static final String ORDERS_OTHERS = "orders_others";
    private static final String IMG_URL_1 = "img_url_1";
    private static final String NO_LOGIN = "no_login";
    private static final String PHONE_1 = "phone_1";
    private static final String PHONE_2 = "phone_2";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public UserProfileTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + USER_PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + EMAIL + " TEXT UNIQUE NOT NULL, " + NAME + " TEXT NOT NULL, " + DESCRIPTION + " TEXT NULL, "
                + USER_CODE + " TEXT NULL, " + USER_TYPE + " TEXT NULL, " + DEVICE_ID + " TEXT NULL, "
                + DEVICE_TYPE + " TEXT NULL, " + DEVICE_ID_1 + " TEXT NULL, " + DEVICE_TYPE_1 + " TEXT NULL, "
                + DEVICE_ID_2 + " TEXT NULL, " + DEVICE_TYPE_2 + " TEXT NULL, " + ADDRESS + " TEXT NULL, "
                + CITY_NAME + " TEXT NULL, " + ORDERS_SELF + " TEXT NULL, " + ORDERS_OTHERS + " TEXT NULL, "
                + IMG_URL_1 + " TEXT NULL, " + NO_LOGIN + " TEXT NULL, " + PHONE_1 + " TEXT NULL, "
                + PHONE_2 + " TEXT NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUserProfile(UserProfileModel userProfileModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_PROFILE_ID, userProfileModel.getUser_profile_id());
        contentValues.put(EMAIL, userProfileModel.getEmail());
        contentValues.put(NAME, userProfileModel.getName());
        contentValues.put(DESCRIPTION, userProfileModel.getDescription());
        contentValues.put(USER_CODE, userProfileModel.getUser_code());
        contentValues.put(USER_TYPE, userProfileModel.getUser_type());
        contentValues.put(DEVICE_ID, userProfileModel.getDevice_id());
        contentValues.put(DEVICE_TYPE, userProfileModel.getDevice_type());
        contentValues.put(DEVICE_ID_1, userProfileModel.getDevice_id_1());
        contentValues.put(DEVICE_TYPE_1, userProfileModel.getDevice_type_1());
        contentValues.put(DEVICE_ID_2, userProfileModel.getDevice_id_2());
        contentValues.put(DEVICE_TYPE_2, userProfileModel.getDevice_type_2());
        contentValues.put(CITY_NAME, userProfileModel.getCity_name());
        contentValues.put(ORDERS_SELF, userProfileModel.getOrders_self());
        contentValues.put(ORDERS_OTHERS, userProfileModel.getOrders_others());
        contentValues.put(IMG_URL_1, userProfileModel.getImg_url_1());
        contentValues.put(NO_LOGIN, userProfileModel.getNo_login());
        contentValues.put(PHONE_1, userProfileModel.getPhone_1());
        contentValues.put(PHONE_2, userProfileModel.getPhone_2());
        contentValues.put(IP, userProfileModel.getIp());
        contentValues.put(U_TS, userProfileModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public UserProfileModel getUserProfileById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + USER_PROFILE_ID + "=" + id, null);

        UserProfileModel userProfileModel = new UserProfileModel();
        if (res.moveToFirst()) {
            userProfileModel.setUser_profile_id(res.getInt(res.getColumnIndex(USER_PROFILE_ID)));
            userProfileModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
            userProfileModel.setName(res.getString(res.getColumnIndex(NAME)));
            userProfileModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
            userProfileModel.setUser_code(res.getString(res.getColumnIndex(USER_CODE)));
            userProfileModel.setUser_type(res.getString(res.getColumnIndex(USER_TYPE)));
            userProfileModel.setDevice_id(res.getString(res.getColumnIndex(DEVICE_ID)));
            userProfileModel.setDevice_type(res.getString(res.getColumnIndex(DEVICE_TYPE)));
            userProfileModel.setDevice_id_1(res.getString(res.getColumnIndex(DEVICE_ID_1)));
            userProfileModel.setDevice_type_1(res.getString(res.getColumnIndex(DEVICE_TYPE_1)));
            userProfileModel.setDevice_id_2(res.getString(res.getColumnIndex(DEVICE_ID_2)));
            userProfileModel.setDevice_type_2(res.getString(res.getColumnIndex(DEVICE_TYPE_2)));
            userProfileModel.setAddress(res.getString(res.getColumnIndex(ADDRESS)));
            userProfileModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
            userProfileModel.setOrders_self(res.getString(res.getColumnIndex(ORDERS_SELF)));
            userProfileModel.setOrders_others(res.getString(res.getColumnIndex(ORDERS_OTHERS)));
            userProfileModel.setImg_url_1(res.getString(res.getColumnIndex(IMG_URL_1)));
            userProfileModel.setNo_login(res.getInt(res.getColumnIndex(NO_LOGIN)));
            userProfileModel.setPhone_1(res.getString(res.getColumnIndex(PHONE_1)));
            userProfileModel.setPhone_2(res.getString(res.getColumnIndex(PHONE_2)));
            userProfileModel.setIp(res.getString(res.getColumnIndex(IP)));
            userProfileModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return userProfileModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateUserProfile(UserProfileModel userProfileModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, userProfileModel.getEmail());
        contentValues.put(NAME, userProfileModel.getName());
        contentValues.put(DESCRIPTION, userProfileModel.getDescription());
        contentValues.put(USER_CODE, userProfileModel.getUser_code());
        contentValues.put(USER_TYPE, userProfileModel.getUser_type());
        contentValues.put(DEVICE_ID, userProfileModel.getDevice_id());
        contentValues.put(DEVICE_TYPE, userProfileModel.getDevice_type());
        contentValues.put(DEVICE_ID_1, userProfileModel.getDevice_id_1());
        contentValues.put(DEVICE_TYPE_1, userProfileModel.getDevice_type_1());
        contentValues.put(DEVICE_ID_2, userProfileModel.getDevice_id_2());
        contentValues.put(DEVICE_TYPE_2, userProfileModel.getDevice_type_2());
        contentValues.put(CITY_NAME, userProfileModel.getCity_name());
        contentValues.put(ORDERS_SELF, userProfileModel.getOrders_self());
        contentValues.put(ORDERS_OTHERS, userProfileModel.getOrders_others());
        contentValues.put(IMG_URL_1, userProfileModel.getImg_url_1());
        contentValues.put(NO_LOGIN, userProfileModel.getNo_login());
        contentValues.put(PHONE_1, userProfileModel.getPhone_1());
        contentValues.put(PHONE_2, userProfileModel.getPhone_2());
        contentValues.put(IP, userProfileModel.getIp());
        contentValues.put(U_TS, userProfileModel.getU_ts());
        db.update(TABLE_NAME, contentValues, USER_PROFILE_ID + "= ? ", new String[]{Integer.toString(userProfileModel.getUser_profile_id())});
        db.close();
        return true;
    }

    public Integer deleteUserProfileById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, USER_PROFILE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<UserProfileModel> getAllUserProfile() {
        ArrayList<UserProfileModel> array_list = new ArrayList<UserProfileModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                UserProfileModel userProfileModel = new UserProfileModel();
                userProfileModel.setUser_profile_id(res.getInt(res.getColumnIndex(USER_PROFILE_ID)));
                userProfileModel.setEmail(res.getString(res.getColumnIndex(EMAIL)));
                userProfileModel.setName(res.getString(res.getColumnIndex(NAME)));
                userProfileModel.setDescription(res.getString(res.getColumnIndex(DESCRIPTION)));
                userProfileModel.setUser_code(res.getString(res.getColumnIndex(USER_CODE)));
                userProfileModel.setUser_type(res.getString(res.getColumnIndex(USER_TYPE)));
                userProfileModel.setDevice_id(res.getString(res.getColumnIndex(DEVICE_ID)));
                userProfileModel.setDevice_type(res.getString(res.getColumnIndex(DEVICE_TYPE)));
                userProfileModel.setDevice_id_1(res.getString(res.getColumnIndex(DEVICE_ID_1)));
                userProfileModel.setDevice_type_1(res.getString(res.getColumnIndex(DEVICE_TYPE_1)));
                userProfileModel.setDevice_id_2(res.getString(res.getColumnIndex(DEVICE_ID_2)));
                userProfileModel.setDevice_type_2(res.getString(res.getColumnIndex(DEVICE_TYPE_2)));
                userProfileModel.setAddress(res.getString(res.getColumnIndex(ADDRESS)));
                userProfileModel.setCity_name(res.getString(res.getColumnIndex(CITY_NAME)));
                userProfileModel.setOrders_self(res.getString(res.getColumnIndex(ORDERS_SELF)));
                userProfileModel.setOrders_others(res.getString(res.getColumnIndex(ORDERS_OTHERS)));
                userProfileModel.setImg_url_1(res.getString(res.getColumnIndex(IMG_URL_1)));
                userProfileModel.setNo_login(res.getInt(res.getColumnIndex(NO_LOGIN)));
                userProfileModel.setPhone_1(res.getString(res.getColumnIndex(PHONE_1)));
                userProfileModel.setPhone_2(res.getString(res.getColumnIndex(PHONE_2)));
                userProfileModel.setIp(res.getString(res.getColumnIndex(IP)));
                userProfileModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(userProfileModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}