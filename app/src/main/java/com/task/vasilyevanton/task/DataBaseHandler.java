package com.task.vasilyevanton.task;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.task.vasilyevanton.task.pojos.FileModel;

import java.util.ArrayList;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "filesManager";
    private static final String TABLE_FILES = "files";
    private static final String KEY_ID = "_id";
    private static final String KEY_FILE_NAME = "fileName";
    private static final String KEY_IS_FOLDER = "isFolder";
    private static final String KEY_DATE = "date";
    private static final String KEY_FILE_TYPE = "fileType";
    private static final String KEY_IS_ORANGE = "isOrange";
    private static final String KEY_IS_BLUE = "isBlue";
    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_FILES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FILE_NAME + " TEXT,"
                + KEY_IS_FOLDER + " INTEGER,"
                + KEY_DATE + " TEXT,"
                + KEY_FILE_TYPE + " TEXT,"
                + KEY_IS_ORANGE + " INTEGER,"
                + KEY_IS_BLUE + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FILES);

        onCreate(db);
    }

    public void addFiles(ArrayList<FileModel> fileModels) {
        deleteAll();
        SQLiteDatabase db = this.getWritableDatabase();
        for (FileModel data : fileModels) {
            ContentValues values = new ContentValues();
            values.put(KEY_FILE_NAME, data.getFilename());
            values.put(KEY_IS_FOLDER, data.getIsFolder());
            values.put(KEY_DATE, data.getModDate());
            values.put(KEY_FILE_TYPE, data.getFileType());
            values.put(KEY_IS_ORANGE, data.getIsOrange());
            values.put(KEY_IS_BLUE, data.getIsBlue());

            db.insert(TABLE_FILES, null, values);
        }
        db.close();
    }

    public ArrayList<FileModel> getFiles() {
        ArrayList<FileModel> fileModelArrayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_FILES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FileModel fileModel = new FileModel();
                fileModel.setFilename(cursor.getString(1));
                fileModel.setIsFolder(Integer.valueOf(cursor.getString(2)));
                fileModel.setModDate(cursor.getString(3));
                fileModel.setFileType(cursor.getString(4));
                fileModel.setIsOrange(Integer.valueOf(cursor.getString(5)));
                fileModel.setIsBlue(Integer.valueOf(cursor.getString(6)));
                fileModelArrayList.add(fileModel);
            } while (cursor.moveToNext());
        }
        return fileModelArrayList;
    }


    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FILES, null, null);
        db.close();
    }

    public int getFilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FILES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}

