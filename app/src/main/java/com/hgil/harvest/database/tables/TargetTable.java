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

import com.hgil.harvest.database.dbModels.TargetModel;

import java.util.ArrayList;

public class TargetTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_target";
    private static final String TARGET_ID = "target_id";
    private static final String TARGET_DEF_ID = "target_def_id";
    private static final String USERID = "userid";
    private static final String PERIOD_TYPE = "period_type";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String TARGET_VALUE = "target_value";
    private static final String TARGET_ACHEIVED = "target_acheived";
    private static final String CREATED_BY = "created_by";
    private static final String TARGET_REPEAT = "target_repeat";
    private static final String PAR_TARGET_ID = "par_target_id";
    private static final String TARGET_STATUS = "target_status";
    private static final String SPILLED_OVER = "spilled_over";
    private static final String SPILL_OVER = "spill_over";
    private static final String STATE = "state";
    private static final String IP = "ip";
    private static final String U_TS = "u_ts";

    public TargetTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + TARGET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + TARGET_DEF_ID + " TEXT UNIQUE NOT NULL, " + USERID + " TEXT UNIQUE NOT NULL, " + PERIOD_TYPE + " INTEGER NOT NULL, "
                + START_DATE + " TEXT UNIQUE NOT NULL, " + END_DATE + " TEXT UNIQUE NOT NULL, " + TARGET_VALUE + " REAL NULL, "
                + TARGET_ACHEIVED + " REAL NULL, " + CREATED_BY + " TEXT NULL, " + TARGET_REPEAT + " INTEGER NULL, "
                + PAR_TARGET_ID + " INTEGER NULL, " + TARGET_STATUS + " INTEGER NULL, " + SPILLED_OVER + " REAL NULL, "
                + SPILL_OVER + " TEXT NULL, " + STATE + " INTEGER NULL, " + IP + " TEXT NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertTarget(TargetModel targetModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TARGET_ID, targetModel.getTarget_id());
        contentValues.put(TARGET_DEF_ID, targetModel.getTarget_def_id());
        contentValues.put(USERID, targetModel.getUserid());
        contentValues.put(PERIOD_TYPE, targetModel.getPeriod_type());
        contentValues.put(START_DATE, targetModel.getStart_date());
        contentValues.put(END_DATE, targetModel.getEnd_date());
        contentValues.put(TARGET_VALUE, targetModel.getTarget_value());
        contentValues.put(TARGET_ACHEIVED, targetModel.getTarget_acheived());
        contentValues.put(CREATED_BY, targetModel.getCreated_by());
        contentValues.put(TARGET_REPEAT, targetModel.getTarget_repeat());
        contentValues.put(PAR_TARGET_ID, targetModel.getPar_target_id());
        contentValues.put(TARGET_STATUS, targetModel.getTarget_status());
        contentValues.put(SPILLED_OVER, targetModel.getSpilled_over());
        contentValues.put(SPILL_OVER, targetModel.getSpill_over());
        contentValues.put(STATE, targetModel.getState());
        contentValues.put(IP, targetModel.getIp());
        contentValues.put(U_TS, targetModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public TargetModel getTargetById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + TARGET_ID + "=" + id, null);

        TargetModel targetModel = new TargetModel();
        if (res.moveToFirst()) {
            targetModel.setTarget_id(res.getInt(res.getColumnIndex(TARGET_ID)));
            targetModel.setTarget_def_id(res.getString(res.getColumnIndex(TARGET_DEF_ID)));
            targetModel.setUserid(res.getString(res.getColumnIndex(USERID)));
            targetModel.setPeriod_type(res.getInt(res.getColumnIndex(PERIOD_TYPE)));
            targetModel.setStart_date(res.getString(res.getColumnIndex(START_DATE)));
            targetModel.setEnd_date(res.getString(res.getColumnIndex(END_DATE)));
            targetModel.setTarget_value(res.getFloat(res.getColumnIndex(TARGET_VALUE)));
            targetModel.setTarget_acheived(res.getFloat(res.getColumnIndex(TARGET_ACHEIVED)));
            targetModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
            targetModel.setTarget_repeat(res.getInt(res.getColumnIndex(TARGET_REPEAT)));
            targetModel.setPar_target_id(res.getInt(res.getColumnIndex(PAR_TARGET_ID)));
            targetModel.setTarget_status(res.getInt(res.getColumnIndex(TARGET_STATUS)));
            targetModel.setSpilled_over(res.getFloat(res.getColumnIndex(SPILLED_OVER)));
            targetModel.setSpill_over(res.getString(res.getColumnIndex(SPILL_OVER)));
            targetModel.setState(res.getInt(res.getColumnIndex(STATE)));
            targetModel.setIp(res.getString(res.getColumnIndex(IP)));
            targetModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return targetModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateTarget(TargetModel targetModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TARGET_DEF_ID, targetModel.getTarget_def_id());
        contentValues.put(USERID, targetModel.getUserid());
        contentValues.put(PERIOD_TYPE, targetModel.getPeriod_type());
        contentValues.put(START_DATE, targetModel.getStart_date());
        contentValues.put(END_DATE, targetModel.getEnd_date());
        contentValues.put(TARGET_VALUE, targetModel.getTarget_value());
        contentValues.put(TARGET_ACHEIVED, targetModel.getTarget_acheived());
        contentValues.put(CREATED_BY, targetModel.getCreated_by());
        contentValues.put(TARGET_REPEAT, targetModel.getTarget_repeat());
        contentValues.put(PAR_TARGET_ID, targetModel.getPar_target_id());
        contentValues.put(TARGET_STATUS, targetModel.getTarget_status());
        contentValues.put(SPILLED_OVER, targetModel.getSpilled_over());
        contentValues.put(SPILL_OVER, targetModel.getSpill_over());
        contentValues.put(STATE, targetModel.getState());
        contentValues.put(IP, targetModel.getIp());
        contentValues.put(U_TS, targetModel.getU_ts());
        db.update(TABLE_NAME, contentValues, TARGET_ID + "= ? ", new String[]{Integer.toString(targetModel.getTarget_id())});
        db.close();
        return true;
    }

    public Integer deleteTargetById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, TARGET_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<TargetModel> getAllTarget() {
        ArrayList<TargetModel> array_list = new ArrayList<TargetModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                TargetModel targetModel = new TargetModel();
                targetModel.setTarget_id(res.getInt(res.getColumnIndex(TARGET_ID)));
                targetModel.setTarget_def_id(res.getString(res.getColumnIndex(TARGET_DEF_ID)));
                targetModel.setUserid(res.getString(res.getColumnIndex(USERID)));
                targetModel.setPeriod_type(res.getInt(res.getColumnIndex(PERIOD_TYPE)));
                targetModel.setStart_date(res.getString(res.getColumnIndex(START_DATE)));
                targetModel.setEnd_date(res.getString(res.getColumnIndex(END_DATE)));
                targetModel.setTarget_value(res.getFloat(res.getColumnIndex(TARGET_VALUE)));
                targetModel.setTarget_acheived(res.getFloat(res.getColumnIndex(TARGET_ACHEIVED)));
                targetModel.setCreated_by(res.getString(res.getColumnIndex(CREATED_BY)));
                targetModel.setTarget_repeat(res.getInt(res.getColumnIndex(TARGET_REPEAT)));
                targetModel.setPar_target_id(res.getInt(res.getColumnIndex(PAR_TARGET_ID)));
                targetModel.setTarget_status(res.getInt(res.getColumnIndex(TARGET_STATUS)));
                targetModel.setSpilled_over(res.getFloat(res.getColumnIndex(SPILLED_OVER)));
                targetModel.setSpill_over(res.getString(res.getColumnIndex(SPILL_OVER)));
                targetModel.setState(res.getInt(res.getColumnIndex(STATE)));
                targetModel.setIp(res.getString(res.getColumnIndex(IP)));
                targetModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(targetModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}