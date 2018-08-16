package com.example.thispc.mbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ProfileDatabase extends SQLiteOpenHelper {
    final String TABLENAME = "HISTORY";
    final String COL_ACCOUNTNO = "paccount";
    final String COL_DATE = "pdate";
    final String COL_TrType = "ptype";
    final String COL_TrAmt = "pAmount";
    final String COL_CURRENTBAL = "pcurbal";
    final String COL_toacc = "pto";


    public ProfileDatabase(Context context) {
        super(context, "profile_database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS HISTORY(pdate Text,paccount Text,ptype Text,pAmount Text,pcurbal Text,pto Text)");
        db.execSQL("CREATE TABLE IF NOT EXISTS HISTORY1(pdate Text,paccount Text,ptype Text,pAmount Text,pcurbal Text,pto Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PROFILE");
        onCreate(db);
    }

    public void addTransaction(TransactionInfo info) {
        ContentValues values = new ContentValues();
        values.put(COL_ACCOUNTNO, info.getFrom());
        values.put(COL_DATE, info.getDate());
        values.put(COL_TrType, info.getType());
        values.put(COL_TrAmt, info.getAmount());
        values.put(COL_CURRENTBAL, info.getNewbal());
        values.put(COL_toacc, info.getTo());


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLENAME, null, values);
    }

    public void addTransaction2(TransactionInfo info) {
        ContentValues values = new ContentValues();
        values.put(COL_ACCOUNTNO, info.getFrom());
        values.put(COL_DATE, info.getDate());
        values.put(COL_TrType, info.getType());
        values.put(COL_TrAmt, info.getAmount());
        values.put(COL_CURRENTBAL, info.getNewbal());
        values.put(COL_toacc, info.getTo());


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("HISTORY1", null, values);
    }

    public ArrayList<TransactionInfo> showtransaction(String accountno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLENAME, null, "paccount=?", new String[]{accountno}, null, null, null);
        cursor.moveToFirst();
        ArrayList<TransactionInfo> infos = new ArrayList<>();
        do {
            String paccount = cursor.getString(cursor.getColumnIndex(COL_ACCOUNTNO));
            String pdate = cursor.getString(cursor.getColumnIndex(COL_DATE));
            String ptype = cursor.getString(cursor.getColumnIndex(COL_TrType));
            String pbalcre = cursor.getString(cursor.getColumnIndex(COL_TrAmt));
            String pcurbal = cursor.getString(cursor.getColumnIndex(COL_CURRENTBAL));
            String toacc = cursor.getString(cursor.getColumnIndex(COL_toacc));
            TransactionInfo info = new TransactionInfo(paccount, toacc, pbalcre, pdate, ptype, pcurbal);
            infos.add(info);
        } while (cursor.moveToNext());
        return infos;
    }

}
