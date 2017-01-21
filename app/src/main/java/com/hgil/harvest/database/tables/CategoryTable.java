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

import com.hgil.harvest.database.dbModels.CategoryModel;

import java.util.ArrayList;

public class CategoryTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_category";
    private static final String CATEGORY_ID = "category_id";
    private static final String CATEGORY_CODE = "category_code";
    private static final String CATEGORY_NAME = "name";
    private static final String PARENT_CAT = "parent_cat";
    private static final String POS = "pos";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public CategoryTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + CATEGORY_CODE + " TEXT UNIQUE NOT NULL, " + CATEGORY_NAME + " TEXT NOT NULL, " + PARENT_CAT + " INTEGER NULL, " + POS + " INTEGER NULL, "
                + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertCategory(CategoryModel categoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_ID, categoryModel.getCategory_id());
        contentValues.put(CATEGORY_CODE, categoryModel.getCategory_code());
        contentValues.put(CATEGORY_NAME, categoryModel.getName());
        contentValues.put(PARENT_CAT, categoryModel.getParent_cat());
        contentValues.put(POS, categoryModel.getPos());
        contentValues.put(STATE, categoryModel.getState());
        contentValues.put(IP, categoryModel.getIp());
        contentValues.put(U_TS, categoryModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public CategoryModel getCategoryById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + CATEGORY_ID + "=" + id, null);

        CategoryModel categoryModel = new CategoryModel();
        if (res.moveToFirst()) {
            categoryModel.setCategory_id(res.getInt(res.getColumnIndex(CATEGORY_ID)));
            categoryModel.setCategory_code(res.getString(res.getColumnIndex(CATEGORY_CODE)));
            categoryModel.setName(res.getString(res.getColumnIndex(CATEGORY_NAME)));
            categoryModel.setParent_cat(res.getInt(res.getColumnIndex(PARENT_CAT)));
            categoryModel.setPos(res.getInt(res.getColumnIndex(POS)));
            categoryModel.setState(res.getInt(res.getColumnIndex(STATE)));
            categoryModel.setIp(res.getString(res.getColumnIndex(IP)));
            categoryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return categoryModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateCategory(CategoryModel categoryModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_CODE, categoryModel.getCategory_code());
        contentValues.put(CATEGORY_NAME, categoryModel.getName());
        contentValues.put(PARENT_CAT, categoryModel.getParent_cat());
        contentValues.put(POS, categoryModel.getPos());
        contentValues.put(STATE, categoryModel.getState());
        contentValues.put(IP, categoryModel.getIp());
        contentValues.put(U_TS, categoryModel.getU_ts());
        db.update(TABLE_NAME, contentValues, CATEGORY_ID + "= ? ", new String[]{Integer.toString(categoryModel.getCategory_id())});
        db.close();
        return true;
    }

    public Integer deleteCategoryById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, CATEGORY_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<CategoryModel> getAllCategory() {
        ArrayList<CategoryModel> array_list = new ArrayList<CategoryModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setCategory_id(res.getInt(res.getColumnIndex(CATEGORY_ID)));
                categoryModel.setCategory_code(res.getString(res.getColumnIndex(CATEGORY_CODE)));
                categoryModel.setName(res.getString(res.getColumnIndex(CATEGORY_NAME)));
                categoryModel.setParent_cat(res.getInt(res.getColumnIndex(PARENT_CAT)));
                categoryModel.setPos(res.getInt(res.getColumnIndex(POS)));
                categoryModel.setState(res.getInt(res.getColumnIndex(STATE)));
                categoryModel.setIp(res.getString(res.getColumnIndex(IP)));
                categoryModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(categoryModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}