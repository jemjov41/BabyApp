package com.example.jemmy.babyapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jemmy.babyapp.entities.PanduanTest;

import java.util.ArrayList;
import java.util.List;

public class PanduanDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Baby.db";
    private static final String TABLE_NAME = "panduan";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "TEXT";
    private static final String COL_3 = "DONE_FLAG";
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " ( " +
            COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_2 + " TEXT, " +
            COL_3 + " BOOLEAN );";

    public PanduanDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean save_panduan(String text) {
        //table di tambah 1 kolom createdOn untuk menyimpan waktu penginsertan
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content_values = new ContentValues();
        content_values.put(COL_2, text);
        content_values.put(COL_3, false);
        long result = db.insert(TABLE_NAME, null, content_values);
        return result != -1;
    }

    public List<PanduanTest> getAllNotes() {
        List<PanduanTest> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PanduanTest note = new PanduanTest();
                note.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                note.setText(cursor.getString(cursor.getColumnIndex(COL_2)));
                note.setDone(cursor.getInt(cursor.getColumnIndex(COL_3))> 0);

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int updateNote(PanduanTest upPanduan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_3, true);

        // updating row
        return db.update(TABLE_NAME, values, COL_1 + " = ?",
                new String[]{String.valueOf(upPanduan.getId())});
    }
}
