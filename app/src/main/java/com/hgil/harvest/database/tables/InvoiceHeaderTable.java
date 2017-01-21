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

import com.hgil.harvest.database.dbModels.InvoiceHeaderModel;

import java.util.ArrayList;

public class InvoiceHeaderTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_invoice_header";
    private static final String INVOICE_ID = "invoice_id";
    private static final String ORDER_ID = "order_id";
    private static final String OWNER_ID = "owner_id";
    private static final String BEAT_ID = "beat_id";
    private static final String BEAT_CODE = "beat_code";
    private static final String REF_ID = "ref_id";
    private static final String INV_ID = "inv_id";
    private static final String INV_DATE = "inv_date";
    private static final String INV_TO = "inv_to";
    private static final String ITEM_COUNT = "item_count";
    private static final String INV_AMOUNT = "inv_amount";
    private static final String PAID_AMOUNT = "paid_amount";
    private static final String UNPAID_AMOUNT = "unpaid_amount";
    private static final String TAX = "tax";
    private static final String TAX_CODE = "tax_code";
    private static final String TAX_NAME = "tax_name";
    private static final String TAX_2 = "tax_2";
    private static final String TAX_NAME_2 = "tax_name_2";
    private static final String TAX_3 = "tax_3";
    private static final String TAX_NAME_3 = "tax_name_3";
    private static final String TAX_4 = "tax_4";
    private static final String TAX_NAME_4 = "tax_name_4";
    private static final String ORDER_TYPE = "order_type";
    private static final String STATUS = "status";
    private static final String GPS_LONG = "gps_long";
    private static final String GPS_LAT = "gps_lat";
    private static final String STATE = "state";
    private static final String U_TS = "u_ts";

    public InvoiceHeaderTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + INVOICE_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + ORDER_ID + " INTEGER NULL, " + OWNER_ID + " TEXT NULL, " + BEAT_ID + " INTEGER NULL, "
                + BEAT_CODE + " TEXT NULL, " + REF_ID + " TEXT NULL, " + INV_ID + " TEXT NOT NULL, "
                + INV_DATE + " TEXT NULL, " + INV_TO + " TEXT NULL, " + ITEM_COUNT + " INTEGER NOT NULL, " + INV_AMOUNT + " REAL NOT NULL, "
                + PAID_AMOUNT + " REAL NULL, " + UNPAID_AMOUNT + " REAL NULL, " + TAX + " REAL NULL, " + TAX_CODE + " TEXT NULL, "
                + TAX_NAME + " TEXT NULL, " + TAX_2 + " REAL NULL, " + TAX_NAME_2 + " TEXT NULL, " + TAX_3 + " REAL NULL, "
                + TAX_NAME_3 + " TEXT NULL, " + TAX_4 + " REAL NULL, " + TAX_NAME_4 + " TEXT NULL, "
                + ORDER_TYPE + " TEXT NULL, " + STATUS + " TEXT NULL, " + GPS_LONG + " TEXT NULL, " + GPS_LAT + " TEXT NULL, "
                + STATE + " INTEGER NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertInvoiceHeader(InvoiceHeaderModel invoiceHeaderModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INVOICE_ID, invoiceHeaderModel.getInvoice_id());
        contentValues.put(ORDER_ID, invoiceHeaderModel.getOrder_id());
        contentValues.put(OWNER_ID, invoiceHeaderModel.getOwner_id());
        contentValues.put(BEAT_ID, invoiceHeaderModel.getBeat_id());
        contentValues.put(BEAT_CODE, invoiceHeaderModel.getBeat_code());
        contentValues.put(REF_ID, invoiceHeaderModel.getRef_id());
        contentValues.put(INV_ID, invoiceHeaderModel.getInv_id());
        contentValues.put(INV_DATE, invoiceHeaderModel.getInv_date());
        contentValues.put(INV_TO, invoiceHeaderModel.getInv_to());
        contentValues.put(ITEM_COUNT, invoiceHeaderModel.getItem_count());
        contentValues.put(INV_AMOUNT, invoiceHeaderModel.getInv_amount());
        contentValues.put(PAID_AMOUNT, invoiceHeaderModel.getPaid_amount());
        contentValues.put(UNPAID_AMOUNT, invoiceHeaderModel.getUnpaid_amount());
        contentValues.put(TAX, invoiceHeaderModel.getTax());
        contentValues.put(TAX_CODE, invoiceHeaderModel.getTax_code());
        contentValues.put(TAX_NAME, invoiceHeaderModel.getTax_name());
        contentValues.put(TAX_2, invoiceHeaderModel.getTax_2());
        contentValues.put(TAX_NAME_2, invoiceHeaderModel.getTax_name_2());
        contentValues.put(TAX_3, invoiceHeaderModel.getTax_3());
        contentValues.put(TAX_NAME_3, invoiceHeaderModel.getTax_name_3());
        contentValues.put(TAX_4, invoiceHeaderModel.getTax_4());
        contentValues.put(TAX_NAME_4, invoiceHeaderModel.getTax_name_4());
        contentValues.put(ORDER_TYPE, invoiceHeaderModel.getOrder_type());
        contentValues.put(STATUS, invoiceHeaderModel.getStatus());
        contentValues.put(GPS_LONG, invoiceHeaderModel.getGps_long());
        contentValues.put(GPS_LAT, invoiceHeaderModel.getGps_lat());
        contentValues.put(STATE, invoiceHeaderModel.getState());
        contentValues.put(U_TS, invoiceHeaderModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public InvoiceHeaderModel getInvoiceHeaderById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + INVOICE_ID + "=" + id, null);

        InvoiceHeaderModel invoiceHeaderModel = new InvoiceHeaderModel();
        if (res.moveToFirst()) {
            invoiceHeaderModel.setInvoice_id(res.getLong(res.getColumnIndex(INVOICE_ID)));
            invoiceHeaderModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
            invoiceHeaderModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
            invoiceHeaderModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
            invoiceHeaderModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
            invoiceHeaderModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
            invoiceHeaderModel.setInv_id(res.getString(res.getColumnIndex(INV_ID)));
            invoiceHeaderModel.setInv_date(res.getString(res.getColumnIndex(INV_DATE)));
            invoiceHeaderModel.setInv_to(res.getString(res.getColumnIndex(INV_TO)));
            invoiceHeaderModel.setItem_count(res.getInt(res.getColumnIndex(ITEM_COUNT)));
            invoiceHeaderModel.setInv_amount(res.getFloat(res.getColumnIndex(INV_AMOUNT)));
            invoiceHeaderModel.setPaid_amount(res.getFloat(res.getColumnIndex(PAID_AMOUNT)));
            invoiceHeaderModel.setUnpaid_amount(res.getFloat(res.getColumnIndex(UNPAID_AMOUNT)));
            invoiceHeaderModel.setTax(res.getFloat(res.getColumnIndex(TAX)));
            invoiceHeaderModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
            invoiceHeaderModel.setTax_name(res.getString(res.getColumnIndex(TAX_NAME)));
            invoiceHeaderModel.setTax_2(res.getFloat(res.getColumnIndex(TAX_2)));
            invoiceHeaderModel.setTax_name_2(res.getString(res.getColumnIndex(TAX_NAME_2)));
            invoiceHeaderModel.setTax_3(res.getFloat(res.getColumnIndex(TAX_3)));
            invoiceHeaderModel.setTax_name_3(res.getString(res.getColumnIndex(TAX_NAME_3)));
            invoiceHeaderModel.setTax_4(res.getFloat(res.getColumnIndex(TAX_4)));
            invoiceHeaderModel.setTax_name_4(res.getString(res.getColumnIndex(TAX_NAME_4)));
            invoiceHeaderModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
            invoiceHeaderModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
            invoiceHeaderModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
            invoiceHeaderModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
            invoiceHeaderModel.setState(res.getInt(res.getColumnIndex(STATE)));
            invoiceHeaderModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return invoiceHeaderModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateInvoiceHeader(InvoiceHeaderModel invoiceHeaderModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ORDER_ID, invoiceHeaderModel.getOrder_id());
        contentValues.put(OWNER_ID, invoiceHeaderModel.getOwner_id());
        contentValues.put(BEAT_ID, invoiceHeaderModel.getBeat_id());
        contentValues.put(BEAT_CODE, invoiceHeaderModel.getBeat_code());
        contentValues.put(REF_ID, invoiceHeaderModel.getRef_id());
        contentValues.put(INV_ID, invoiceHeaderModel.getInv_id());
        contentValues.put(INV_DATE, invoiceHeaderModel.getInv_date());
        contentValues.put(INV_TO, invoiceHeaderModel.getInv_to());
        contentValues.put(ITEM_COUNT, invoiceHeaderModel.getItem_count());
        contentValues.put(INV_AMOUNT, invoiceHeaderModel.getInv_amount());
        contentValues.put(PAID_AMOUNT, invoiceHeaderModel.getPaid_amount());
        contentValues.put(UNPAID_AMOUNT, invoiceHeaderModel.getUnpaid_amount());
        contentValues.put(TAX, invoiceHeaderModel.getTax());
        contentValues.put(TAX_CODE, invoiceHeaderModel.getTax_code());
        contentValues.put(TAX_NAME, invoiceHeaderModel.getTax_name());
        contentValues.put(TAX_2, invoiceHeaderModel.getTax_2());
        contentValues.put(TAX_NAME_2, invoiceHeaderModel.getTax_name_2());
        contentValues.put(TAX_3, invoiceHeaderModel.getTax_3());
        contentValues.put(TAX_NAME_3, invoiceHeaderModel.getTax_name_3());
        contentValues.put(TAX_4, invoiceHeaderModel.getTax_4());
        contentValues.put(TAX_NAME_4, invoiceHeaderModel.getTax_name_4());
        contentValues.put(ORDER_TYPE, invoiceHeaderModel.getOrder_type());
        contentValues.put(STATUS, invoiceHeaderModel.getStatus());
        contentValues.put(GPS_LONG, invoiceHeaderModel.getGps_long());
        contentValues.put(GPS_LAT, invoiceHeaderModel.getGps_lat());
        contentValues.put(STATE, invoiceHeaderModel.getState());
        contentValues.put(U_TS, invoiceHeaderModel.getU_ts());
        db.update(TABLE_NAME, contentValues, INVOICE_ID + "= ? ", new String[]{Long.toString(invoiceHeaderModel.getInvoice_id())});
        db.close();
        return true;
    }

    public Integer deleteInvoiceHeaderById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, INVOICE_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<InvoiceHeaderModel> getAllInvoiceHeader() {
        ArrayList<InvoiceHeaderModel> array_list = new ArrayList<InvoiceHeaderModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                InvoiceHeaderModel invoiceHeaderModel = new InvoiceHeaderModel();
                invoiceHeaderModel.setInvoice_id(res.getLong(res.getColumnIndex(INVOICE_ID)));
                invoiceHeaderModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
                invoiceHeaderModel.setOwner_id(res.getString(res.getColumnIndex(OWNER_ID)));
                invoiceHeaderModel.setBeat_id(res.getInt(res.getColumnIndex(BEAT_ID)));
                invoiceHeaderModel.setBeat_code(res.getString(res.getColumnIndex(BEAT_CODE)));
                invoiceHeaderModel.setRef_id(res.getString(res.getColumnIndex(REF_ID)));
                invoiceHeaderModel.setInv_id(res.getString(res.getColumnIndex(INV_ID)));
                invoiceHeaderModel.setInv_date(res.getString(res.getColumnIndex(INV_DATE)));
                invoiceHeaderModel.setInv_to(res.getString(res.getColumnIndex(INV_TO)));
                invoiceHeaderModel.setItem_count(res.getInt(res.getColumnIndex(ITEM_COUNT)));
                invoiceHeaderModel.setInv_amount(res.getFloat(res.getColumnIndex(INV_AMOUNT)));
                invoiceHeaderModel.setPaid_amount(res.getFloat(res.getColumnIndex(PAID_AMOUNT)));
                invoiceHeaderModel.setUnpaid_amount(res.getFloat(res.getColumnIndex(UNPAID_AMOUNT)));
                invoiceHeaderModel.setTax(res.getFloat(res.getColumnIndex(TAX)));
                invoiceHeaderModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
                invoiceHeaderModel.setTax_name(res.getString(res.getColumnIndex(TAX_NAME)));
                invoiceHeaderModel.setTax_2(res.getFloat(res.getColumnIndex(TAX_2)));
                invoiceHeaderModel.setTax_name_2(res.getString(res.getColumnIndex(TAX_NAME_2)));
                invoiceHeaderModel.setTax_3(res.getFloat(res.getColumnIndex(TAX_3)));
                invoiceHeaderModel.setTax_name_3(res.getString(res.getColumnIndex(TAX_NAME_3)));
                invoiceHeaderModel.setTax_4(res.getFloat(res.getColumnIndex(TAX_4)));
                invoiceHeaderModel.setTax_name_4(res.getString(res.getColumnIndex(TAX_NAME_4)));
                invoiceHeaderModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
                invoiceHeaderModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
                invoiceHeaderModel.setGps_long(res.getString(res.getColumnIndex(GPS_LONG)));
                invoiceHeaderModel.setGps_lat(res.getString(res.getColumnIndex(GPS_LAT)));
                invoiceHeaderModel.setState(res.getInt(res.getColumnIndex(STATE)));
                invoiceHeaderModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(invoiceHeaderModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}