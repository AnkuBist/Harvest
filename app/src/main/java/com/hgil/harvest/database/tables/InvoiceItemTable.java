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

import com.hgil.harvest.database.dbModels.InvoiceItemModel;

import java.util.ArrayList;

public class InvoiceItemTable extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoDB";
    private static final String TABLE_NAME = "dbo.meap_invoice_item";
    private static final String INVOICE_ITEM_ID = "invoice_item_id";
    private static final String INVOICE_ID = "invoice_id";
    private static final String SKU_ID = "sku_id";
    private static final String SKU_CODE = "sku_code";
    private static final String SKU_NAME = "sku_name";
    private static final String MRP = "mrp";
    private static final String QTY = "qty";
    private static final String FREE_QTY = "free_qty";
    private static final String REP_QTY = "rep_qty";
    private static final String REP_PRICE = "rep_price";
    private static final String ITEM_DISC = "item_disc";
    private static final String ITEM_TIME = "item_time";
    private static final String ITEM_INFO = "item_info";
    private static final String AMOUNT = "amount";
    private static final String TAX = "tax";
    private static final String TAX_CODE = "tax_code";
    private static final String TAX_NAME = "tax_name";
    private static final String TAX_2 = "tax_2";
    private static final String TAX_NAME_2 = "tax_name_2";
    private static final String TAX_3 = "tax_3";
    private static final String TAX_NAME_3 = "tax_name_3";
    private static final String TAX_4 = "tax_4";
    private static final String TAX_NAME_4 = "tax_name_4";
    private static final String TAX_5 = "tax_5";
    private static final String TAX_NAME_5 = "tax_name_5";
    private static final String TAX_6 = "tax_6";
    private static final String TAX_NAME_6 = "tax_name_6";
    private static final String TAX_7 = "tax_7";
    private static final String TAX_NAME_7 = "tax_name_7";
    private static final String TAX_8 = "tax_8";
    private static final String TAX_NAME_8 = "tax_name_8";
    private static final String TAX_9 = "tax_9";
    private static final String TAX_NAME_9 = "tax_name_9";
    private static final String TAX_10 = "tax_10";
    private static final String TAX_NAME_10 = "tax_name_10";
    private static final String ORDER_TYPE = "order_type";
    private static final String ORDER_ID = "order_id";
    private static final String BATCH_NO = "batch_no";
    private static final String STATUS = "status";
    private static final String STATE = "state";
    private static final String U_TS = "u_ts";

    public InvoiceItemTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " IF NOT EXISTS (" + INVOICE_ITEM_ID + " INTEGER PRIMARY KEY NOT NULL, "
                + INVOICE_ID + " INTEGER NOT NULL, " + SKU_ID + " INTEGER NULL, " + SKU_CODE + " TEXT NULL, "
                + SKU_NAME + " TEXT NULL, " + MRP + " REAL NULL, " + QTY + " REAL NOT NULL, "
                + FREE_QTY + " REAL NULL, " + REP_QTY + " REAL NULL, " + REP_PRICE + " REAL NULL, " + ITEM_DISC + " REAL NULL, "
                + ITEM_TIME + " TEXT NULL, " + ITEM_INFO + " TEXT NULL, " + AMOUNT + " REAL NULL, " + TAX + " REAL NULL, " + TAX_CODE + " TEXT NULL, "
                + TAX_NAME + " TEXT NULL, " + TAX_2 + " REAL NULL, " + TAX_NAME_2 + " TEXT NULL, " + TAX_3 + " REAL NULL, "
                + TAX_NAME_3 + " TEXT NULL, " + TAX_4 + " REAL NULL, " + TAX_NAME_4 + " TEXT NULL, " + TAX_5 + " REAL NULL, " + TAX_NAME_5 + " TEXT NULL, "
                + TAX_6 + " REAL NULL, " + TAX_NAME_6 + " TEXT NULL, " + TAX_7 + " REAL NULL, " + TAX_NAME_7 + " TEXT NULL, "
                + TAX_8 + " REAL NULL, " + TAX_NAME_8 + " TEXT NULL, " + TAX_9 + " REAL NULL, " + TAX_NAME_9 + " TEXT NULL, "
                + TAX_10 + " REAL NULL, " + TAX_NAME_10 + " TEXT NULL, " + ORDER_TYPE + " TEXT NULL, " + ORDER_ID + " INTEGER NULL, "
                + BATCH_NO + " TEXT NULL, " + STATUS + " TEXT NULL, " + STATE + " INTEGER NULL, " + U_TS + " NUMERIC NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertInvoiceItem(InvoiceItemModel invoiceItemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INVOICE_ITEM_ID, invoiceItemModel.getInvoice_item_id());
        contentValues.put(INVOICE_ID, invoiceItemModel.getInvoice_id());
        contentValues.put(SKU_ID, invoiceItemModel.getSku_id());
        contentValues.put(SKU_CODE, invoiceItemModel.getSku_code());
        contentValues.put(SKU_NAME, invoiceItemModel.getSku_name());
        contentValues.put(MRP, invoiceItemModel.getMrp());
        contentValues.put(QTY, invoiceItemModel.getQty());
        contentValues.put(FREE_QTY, invoiceItemModel.getFree_qty());
        contentValues.put(REP_QTY, invoiceItemModel.getRep_qty());
        contentValues.put(REP_PRICE, invoiceItemModel.getRep_price());
        contentValues.put(ITEM_DISC, invoiceItemModel.getItem_disc());
        contentValues.put(ITEM_TIME, invoiceItemModel.getItem_time());
        contentValues.put(ITEM_INFO, invoiceItemModel.getItem_info());
        contentValues.put(AMOUNT, invoiceItemModel.getAmount());
        contentValues.put(TAX, invoiceItemModel.getTax());
        contentValues.put(TAX_CODE, invoiceItemModel.getTax_code());
        contentValues.put(TAX_NAME, invoiceItemModel.getTax_name());
        contentValues.put(TAX_2, invoiceItemModel.getTax_2());
        contentValues.put(TAX_NAME_2, invoiceItemModel.getTax_name_2());
        contentValues.put(TAX_3, invoiceItemModel.getTax_3());
        contentValues.put(TAX_NAME_3, invoiceItemModel.getTax_name_3());
        contentValues.put(TAX_4, invoiceItemModel.getTax_4());
        contentValues.put(TAX_NAME_4, invoiceItemModel.getTax_name_4());
        contentValues.put(TAX_5, invoiceItemModel.getTax_5());
        contentValues.put(TAX_NAME_5, invoiceItemModel.getTax_name_5());
        contentValues.put(TAX_6, invoiceItemModel.getTax_6());
        contentValues.put(TAX_NAME_6, invoiceItemModel.getTax_name_6());
        contentValues.put(TAX_7, invoiceItemModel.getTax_7());
        contentValues.put(TAX_NAME_7, invoiceItemModel.getTax_name_7());
        contentValues.put(TAX_8, invoiceItemModel.getTax_8());
        contentValues.put(TAX_NAME_8, invoiceItemModel.getTax_name_8());
        contentValues.put(TAX_9, invoiceItemModel.getTax_9());
        contentValues.put(TAX_NAME_9, invoiceItemModel.getTax_name_9());
        contentValues.put(TAX_10, invoiceItemModel.getTax_10());
        contentValues.put(TAX_NAME_10, invoiceItemModel.getTax_name_10());
        contentValues.put(ORDER_TYPE, invoiceItemModel.getOrder_type());
        contentValues.put(ORDER_ID, invoiceItemModel.getOrder_id());
        contentValues.put(BATCH_NO, invoiceItemModel.getBatch_no());
        contentValues.put(STATUS, invoiceItemModel.getStatus());
        contentValues.put(STATE, invoiceItemModel.getState());
        contentValues.put(U_TS, invoiceItemModel.getU_ts());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public InvoiceItemModel getInvoiceItemById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + INVOICE_ITEM_ID + "=" + id, null);

        InvoiceItemModel invoiceItemModel = new InvoiceItemModel();
        if (res.moveToFirst()) {
            invoiceItemModel.setInvoice_item_id(res.getLong(res.getColumnIndex(INVOICE_ITEM_ID)));
            invoiceItemModel.setInvoice_id(res.getLong(res.getColumnIndex(INVOICE_ID)));
            invoiceItemModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
            invoiceItemModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
            invoiceItemModel.setSku_name(res.getString(res.getColumnIndex(SKU_NAME)));
            invoiceItemModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
            invoiceItemModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
            invoiceItemModel.setFree_qty(res.getFloat(res.getColumnIndex(FREE_QTY)));
            invoiceItemModel.setRep_qty(res.getFloat(res.getColumnIndex(REP_QTY)));
            invoiceItemModel.setRep_price(res.getFloat(res.getColumnIndex(REP_PRICE)));
            invoiceItemModel.setItem_disc(res.getFloat(res.getColumnIndex(ITEM_DISC)));
            invoiceItemModel.setItem_time(res.getString(res.getColumnIndex(ITEM_TIME)));
            invoiceItemModel.setItem_info(res.getString(res.getColumnIndex(ITEM_INFO)));
            invoiceItemModel.setAmount(res.getFloat(res.getColumnIndex(AMOUNT)));
            invoiceItemModel.setTax(res.getFloat(res.getColumnIndex(TAX)));
            invoiceItemModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
            invoiceItemModel.setTax_name(res.getString(res.getColumnIndex(TAX_NAME)));
            invoiceItemModel.setTax_2(res.getFloat(res.getColumnIndex(TAX_2)));
            invoiceItemModel.setTax_name_2(res.getString(res.getColumnIndex(TAX_NAME_2)));
            invoiceItemModel.setTax_3(res.getFloat(res.getColumnIndex(TAX_3)));
            invoiceItemModel.setTax_name_3(res.getString(res.getColumnIndex(TAX_NAME_3)));
            invoiceItemModel.setTax_4(res.getFloat(res.getColumnIndex(TAX_4)));
            invoiceItemModel.setTax_name_4(res.getString(res.getColumnIndex(TAX_NAME_4)));
            invoiceItemModel.setTax_5(res.getFloat(res.getColumnIndex(TAX_5)));
            invoiceItemModel.setTax_name_5(res.getString(res.getColumnIndex(TAX_NAME_5)));
            invoiceItemModel.setTax_6(res.getFloat(res.getColumnIndex(TAX_6)));
            invoiceItemModel.setTax_name_6(res.getString(res.getColumnIndex(TAX_NAME_6)));
            invoiceItemModel.setTax_7(res.getFloat(res.getColumnIndex(TAX_7)));
            invoiceItemModel.setTax_name_7(res.getString(res.getColumnIndex(TAX_NAME_7)));
            invoiceItemModel.setTax_8(res.getFloat(res.getColumnIndex(TAX_8)));
            invoiceItemModel.setTax_name_8(res.getString(res.getColumnIndex(TAX_NAME_8)));
            invoiceItemModel.setTax_9(res.getFloat(res.getColumnIndex(TAX_9)));
            invoiceItemModel.setTax_name_9(res.getString(res.getColumnIndex(TAX_NAME_9)));
            invoiceItemModel.setTax_10(res.getFloat(res.getColumnIndex(TAX_10)));
            invoiceItemModel.setTax_name_10(res.getString(res.getColumnIndex(TAX_NAME_10)));
            invoiceItemModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
            invoiceItemModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
            invoiceItemModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
            invoiceItemModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
            invoiceItemModel.setState(res.getInt(res.getColumnIndex(STATE)));
            invoiceItemModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));
        }
        res.close();
        db.close();
        return invoiceItemModel;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateInvoiceItem(InvoiceItemModel invoiceItemModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INVOICE_ID, invoiceItemModel.getInvoice_id());
        contentValues.put(SKU_ID, invoiceItemModel.getSku_id());
        contentValues.put(SKU_CODE, invoiceItemModel.getSku_code());
        contentValues.put(SKU_NAME, invoiceItemModel.getSku_name());
        contentValues.put(MRP, invoiceItemModel.getMrp());
        contentValues.put(QTY, invoiceItemModel.getQty());
        contentValues.put(FREE_QTY, invoiceItemModel.getFree_qty());
        contentValues.put(REP_QTY, invoiceItemModel.getRep_qty());
        contentValues.put(REP_PRICE, invoiceItemModel.getRep_price());
        contentValues.put(ITEM_DISC, invoiceItemModel.getItem_disc());
        contentValues.put(ITEM_TIME, invoiceItemModel.getItem_time());
        contentValues.put(ITEM_INFO, invoiceItemModel.getItem_info());
        contentValues.put(AMOUNT, invoiceItemModel.getAmount());
        contentValues.put(TAX, invoiceItemModel.getTax());
        contentValues.put(TAX_CODE, invoiceItemModel.getTax_code());
        contentValues.put(TAX_NAME, invoiceItemModel.getTax_name());
        contentValues.put(TAX_2, invoiceItemModel.getTax_2());
        contentValues.put(TAX_NAME_2, invoiceItemModel.getTax_name_2());
        contentValues.put(TAX_3, invoiceItemModel.getTax_3());
        contentValues.put(TAX_NAME_3, invoiceItemModel.getTax_name_3());
        contentValues.put(TAX_4, invoiceItemModel.getTax_4());
        contentValues.put(TAX_NAME_4, invoiceItemModel.getTax_name_4());
        contentValues.put(TAX_5, invoiceItemModel.getTax_5());
        contentValues.put(TAX_NAME_5, invoiceItemModel.getTax_name_5());
        contentValues.put(TAX_6, invoiceItemModel.getTax_6());
        contentValues.put(TAX_NAME_6, invoiceItemModel.getTax_name_6());
        contentValues.put(TAX_7, invoiceItemModel.getTax_7());
        contentValues.put(TAX_NAME_7, invoiceItemModel.getTax_name_7());
        contentValues.put(TAX_8, invoiceItemModel.getTax_8());
        contentValues.put(TAX_NAME_8, invoiceItemModel.getTax_name_8());
        contentValues.put(TAX_9, invoiceItemModel.getTax_9());
        contentValues.put(TAX_NAME_9, invoiceItemModel.getTax_name_9());
        contentValues.put(TAX_10, invoiceItemModel.getTax_10());
        contentValues.put(TAX_NAME_10, invoiceItemModel.getTax_name_10());
        contentValues.put(ORDER_TYPE, invoiceItemModel.getOrder_type());
        contentValues.put(ORDER_ID, invoiceItemModel.getOrder_id());
        contentValues.put(BATCH_NO, invoiceItemModel.getBatch_no());
        contentValues.put(STATUS, invoiceItemModel.getStatus());
        contentValues.put(STATE, invoiceItemModel.getState());
        contentValues.put(U_TS, invoiceItemModel.getU_ts());
        db.update(TABLE_NAME, contentValues, INVOICE_ITEM_ID + "= ? ", new String[]{Long.toString(invoiceItemModel.getInvoice_item_id())});
        db.close();
        return true;
    }

    public Integer deleteInvoiceItemById(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, INVOICE_ITEM_ID + "= ? ", new String[]{Integer.toString(id)});
    }

    public ArrayList<InvoiceItemModel> getAllInvoiceItem() {
        ArrayList<InvoiceItemModel> array_list = new ArrayList<InvoiceItemModel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (res.moveToFirst()) {
            while (res.isAfterLast() == false) {
                InvoiceItemModel invoiceItemModel = new InvoiceItemModel();
                invoiceItemModel.setInvoice_item_id(res.getLong(res.getColumnIndex(INVOICE_ITEM_ID)));
                invoiceItemModel.setInvoice_id(res.getLong(res.getColumnIndex(INVOICE_ID)));
                invoiceItemModel.setSku_id(res.getInt(res.getColumnIndex(SKU_ID)));
                invoiceItemModel.setSku_code(res.getString(res.getColumnIndex(SKU_CODE)));
                invoiceItemModel.setSku_name(res.getString(res.getColumnIndex(SKU_NAME)));
                invoiceItemModel.setMrp(res.getFloat(res.getColumnIndex(MRP)));
                invoiceItemModel.setQty(res.getFloat(res.getColumnIndex(QTY)));
                invoiceItemModel.setFree_qty(res.getFloat(res.getColumnIndex(FREE_QTY)));
                invoiceItemModel.setRep_qty(res.getFloat(res.getColumnIndex(REP_QTY)));
                invoiceItemModel.setRep_price(res.getFloat(res.getColumnIndex(REP_PRICE)));
                invoiceItemModel.setItem_disc(res.getFloat(res.getColumnIndex(ITEM_DISC)));
                invoiceItemModel.setItem_time(res.getString(res.getColumnIndex(ITEM_TIME)));
                invoiceItemModel.setItem_info(res.getString(res.getColumnIndex(ITEM_INFO)));
                invoiceItemModel.setAmount(res.getFloat(res.getColumnIndex(AMOUNT)));
                invoiceItemModel.setTax(res.getFloat(res.getColumnIndex(TAX)));
                invoiceItemModel.setTax_code(res.getString(res.getColumnIndex(TAX_CODE)));
                invoiceItemModel.setTax_name(res.getString(res.getColumnIndex(TAX_NAME)));
                invoiceItemModel.setTax_2(res.getFloat(res.getColumnIndex(TAX_2)));
                invoiceItemModel.setTax_name_2(res.getString(res.getColumnIndex(TAX_NAME_2)));
                invoiceItemModel.setTax_3(res.getFloat(res.getColumnIndex(TAX_3)));
                invoiceItemModel.setTax_name_3(res.getString(res.getColumnIndex(TAX_NAME_3)));
                invoiceItemModel.setTax_4(res.getFloat(res.getColumnIndex(TAX_4)));
                invoiceItemModel.setTax_name_4(res.getString(res.getColumnIndex(TAX_NAME_4)));
                invoiceItemModel.setTax_5(res.getFloat(res.getColumnIndex(TAX_5)));
                invoiceItemModel.setTax_name_5(res.getString(res.getColumnIndex(TAX_NAME_5)));
                invoiceItemModel.setTax_6(res.getFloat(res.getColumnIndex(TAX_6)));
                invoiceItemModel.setTax_name_6(res.getString(res.getColumnIndex(TAX_NAME_6)));
                invoiceItemModel.setTax_7(res.getFloat(res.getColumnIndex(TAX_7)));
                invoiceItemModel.setTax_name_7(res.getString(res.getColumnIndex(TAX_NAME_7)));
                invoiceItemModel.setTax_8(res.getFloat(res.getColumnIndex(TAX_8)));
                invoiceItemModel.setTax_name_8(res.getString(res.getColumnIndex(TAX_NAME_8)));
                invoiceItemModel.setTax_9(res.getFloat(res.getColumnIndex(TAX_9)));
                invoiceItemModel.setTax_name_9(res.getString(res.getColumnIndex(TAX_NAME_9)));
                invoiceItemModel.setTax_10(res.getFloat(res.getColumnIndex(TAX_10)));
                invoiceItemModel.setTax_name_10(res.getString(res.getColumnIndex(TAX_NAME_10)));
                invoiceItemModel.setOrder_type(res.getString(res.getColumnIndex(ORDER_TYPE)));
                invoiceItemModel.setOrder_id(res.getLong(res.getColumnIndex(ORDER_ID)));
                invoiceItemModel.setBatch_no(res.getString(res.getColumnIndex(BATCH_NO)));
                invoiceItemModel.setStatus(res.getString(res.getColumnIndex(STATUS)));
                invoiceItemModel.setState(res.getInt(res.getColumnIndex(STATE)));
                invoiceItemModel.setU_ts(res.getString(res.getColumnIndex(U_TS)));

                array_list.add(invoiceItemModel);
                res.moveToNext();
            }
        }
        res.close();
        db.close();
        return array_list;
    }
}