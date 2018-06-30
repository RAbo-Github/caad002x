package com.example.ratech.mytodolist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoListDBHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "todolist.db";

    public TodoListDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TODO_TABLE =
                "CREATE TABLE "
                        + TodoListContract.TodoEntry.TABLE_NAME
                        + " ("
                        + TodoListContract.TodoEntry._ID + "INTEGER PRIMARY KEY,"
                        + TodoListContract.TodoEntry.COLUMN_DATE + " TEXT NOT NULL, "
                        + TodoListContract.TodoEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
                        + TodoListContract.TodoEntry.COLUMN_DONE + " INTEGER, "
                        + "UNIQUE ("
                        + TodoListContract.TodoEntry.COLUMN_DATE
                        + ","
                        + TodoListContract.TodoEntry.COLUMN_DESCRIPTION
                        + ") ON "
                        + "CONFLICT IGNORE"
                        + " );"
                ;

        sqLiteDatabase.execSQL(SQL_CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TodoListContract.TodoEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
