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

import com.hgil.harvest.database.dbModels.OutletCategoryModel;

import java.util.ArrayList;

public class OutletCategoryTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_outlet_category";
    private static final String CATEGORY_ID = "category_id";
    private static final String CATEGORY_NAME = "name";
    private static final String CR_LIMIT = "cr_limit";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public OutletCategoryTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + CATEGORY_NAME + " TEXT UNIQUE NOT NULL, " + CR_LIMIT + " INTEGER NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertOutletCategory(OutletCategoryModel outletCategoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_ID, outletCategoryModel.getCategory_id());
        contentValues.put(CATEGORY_NAME, outletCategoryModel.getName());
        contentValues.put(CR_LIMIT, outletCategoryModel.getCr_limit());
        contentValues.put(STATE, outletCategoryModel.getState());
        contentValues.put(IP, outletCategoryModel.getIp());
        contentValues.put(U_TS, outletCategoryModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public OutletCategoryModel getOutletCategoryById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + CATEGORY_ID + "=" + id, null);

        OutletCategoryModel outletCategoryModel = new OutletCategoryModel();
        if (res.moveToFirst()) {
            outletCategoryModel.setCategory_id(res.getInt(res.getColumnIndex(CATEGORY_ID)));
            outletCategoryModel.setName(res.getString(res.getColumnIndex(CATEGORY_NAME)));
            outletCategoryModel.setCr_limit(res.getInt(res.getColumnIndex(CR_LIMIT)));
            outletCategoryModel.setState(res.getInt(res.getColumnIndex(STATE)));
            outletCategoryModel.setIp(res.getString(res.getColumnIndex(IP)));
            outletCategoryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return outletCategoryModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateOutletCategory(OutletCategoryModel outletCategoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_NAME, outletCategoryModel.getName());
        contentValues.put(CR_LIMIT, outletCategoryModel.getCr_limit());
        contentValues.put(STATE, outletCategoryModel.getState());
        contentValues.put(IP, outletCategoryModel.getIp());
        contentValues.put(U_TS, outletCategoryModel.getU_ts());
        db.update(TABLE_NAME, contentValues, CATEGORY_ID + "= ? ", new String[]{Integer.toString(outletCategoryModel.getCategory_id())});
        db.close();
        return true;
    }

    public Integer deleteOutletCategoryById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, CATEGORY_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<OutletCategoryModel> getAllOutletCategory() {
        ArrayList<OutletCategoryModel> array_list = new ArrayList<OutletCategoryModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                OutletCategoryModel outletCategoryModel = new OutletCategoryModel();
                outletCategoryModel.setCategory_id(res.getInt(res.getColumnIndex(CATEGORY_ID)));
                outletCategoryModel.setName(res.getString(res.getColumnIndex(CATEGORY_NAME)));
                outletCategoryModel.setCr_limit(res.getInt(res.getColumnIndex(CR_LIMIT)));
                outletCategoryModel.setState(res.getInt(res.getColumnIndex(STATE)));
                outletCategoryModel.setIp(res.getString(res.getColumnIndex(IP)));
                outletCategoryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(outletCategoryModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}