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

import com.hgil.harvest.database.dbModels.ActivityModel;

import java.util.ArrayList;

public class ActivityTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_activity";
    private static final String ACTIVITY_ID = "activity_id";
    private static final String ACTIVITY_NAME = "name";
    private static final String PAR_ACTIVITY = "par_activity";
    private static final String DEF_START_TIME = "def_start_time";
    private static final String DEF_END_TIME = "def_end_time";
    private static final String DEF_DAR_TIME = "def_dar_time";
    private static final String MAX_DAR_TIME = "max_dar_time";
    private static final String VAL_FIELDS = "val_fields";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public ActivityTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + ACTIVITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + ACTIVITY_NAME + " TEXT NULL, " + PAR_ACTIVITY + " INTEGER NULL, " + DEF_START_TIME + " INTEGER NULL, " + DEF_END_TIME + " INTEGER NULL, "
                + DEF_DAR_TIME + " INTEGER NULL, " + MAX_DAR_TIME + " INTEGER NULL, " + VAL_FIELDS + " TEXT NULL, " + STATE + " INTEGER NULL, "
                + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertActivity(ActivityModel activityModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACTIVITY_ID, activityModel.getActivity_id());
        contentValues.put(ACTIVITY_NAME, activityModel.getName());
        contentValues.put(PAR_ACTIVITY, activityModel.getPar_activity());
        contentValues.put(DEF_START_TIME, activityModel.getDef_start_time());
        contentValues.put(DEF_END_TIME, activityModel.getDef_end_time());
        contentValues.put(DEF_DAR_TIME, activityModel.getDef_dar_time());
        contentValues.put(MAX_DAR_TIME, activityModel.getMax_dar_time());
        contentValues.put(VAL_FIELDS, activityModel.getVal_fields());
        contentValues.put(STATE, activityModel.getState());
        contentValues.put(IP, activityModel.getIp());
        contentValues.put(U_TS, activityModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public ActivityModel getActivityById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ACTIVITY_ID + "=" + id, null);

        ActivityModel activityModel = new ActivityModel();
        if (res.moveToFirst()) {
            activityModel.setActivity_id(res.getInt(res.getColumnIndex(ACTIVITY_ID)));
            activityModel.setName(res.getString(res.getColumnIndex(ACTIVITY_NAME)));
            activityModel.setPar_activity(res.getInt(res.getColumnIndex(PAR_ACTIVITY)));
            activityModel.setDef_start_time(res.getInt(res.getColumnIndex(DEF_START_TIME)));
            activityModel.setDef_end_time(res.getInt(res.getColumnIndex(DEF_END_TIME)));
            activityModel.setDef_dar_time(res.getInt(res.getColumnIndex(DEF_DAR_TIME)));
            activityModel.setMax_dar_time(res.getInt(res.getColumnIndex(MAX_DAR_TIME)));
            activityModel.setVal_fields(res.getString(res.getColumnIndex(VAL_FIELDS)));
            activityModel.setState(res.getInt(res.getColumnIndex(STATE)));
            activityModel.setIp(res.getString(res.getColumnIndex(IP)));
            activityModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return activityModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateActivity(ActivityModel activityModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACTIVITY_NAME, activityModel.getName());
        contentValues.put(PAR_ACTIVITY, activityModel.getPar_activity());
        contentValues.put(DEF_START_TIME, activityModel.getDef_start_time());
        contentValues.put(DEF_END_TIME, activityModel.getDef_end_time());
        contentValues.put(DEF_DAR_TIME, activityModel.getDef_dar_time());
        contentValues.put(MAX_DAR_TIME, activityModel.getMax_dar_time());
        contentValues.put(VAL_FIELDS, activityModel.getVal_fields());
        contentValues.put(STATE, activityModel.getState());
        contentValues.put(IP, activityModel.getIp());
        contentValues.put(U_TS, activityModel.getU_ts());
        db.update(TABLE_NAME, contentValues, ACTIVITY_ID + "= ? ", new String[]{Integer.toString(activityModel.getActivity_id())});
        db.close();
        return true;
    }

    public Integer deleteActivityById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ACTIVITY_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<ActivityModel> getAllActivity() {
        ArrayList<ActivityModel> array_list = new ArrayList<ActivityModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                ActivityModel activityModel = new ActivityModel();
                activityModel.setActivity_id(res.getInt(res.getColumnIndex(ACTIVITY_ID)));
                activityModel.setName(res.getString(res.getColumnIndex(ACTIVITY_NAME)));
                activityModel.setPar_activity(res.getInt(res.getColumnIndex(PAR_ACTIVITY)));
                activityModel.setDef_start_time(res.getInt(res.getColumnIndex(DEF_START_TIME)));
                activityModel.setDef_end_time(res.getInt(res.getColumnIndex(DEF_END_TIME)));
                activityModel.setDef_dar_time(res.getInt(res.getColumnIndex(DEF_DAR_TIME)));
                activityModel.setMax_dar_time(res.getInt(res.getColumnIndex(MAX_DAR_TIME)));
                activityModel.setVal_fields(res.getString(res.getColumnIndex(VAL_FIELDS)));
                activityModel.setState(res.getInt(res.getColumnIndex(STATE)));
                activityModel.setIp(res.getString(res.getColumnIndex(IP)));
                activityModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(activityModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}