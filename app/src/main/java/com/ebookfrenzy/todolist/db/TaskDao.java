package com.ebookfrenzy.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDao extends SQLiteOpenHelper {

    public TaskDao(Context context) {
        super(context, TaskStructure.DB_NAME, null, TaskStructure.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TaskStructure.TaskEntry.TABLE + " ( " +
                TaskStructure.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskStructure.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskStructure.TaskEntry.TABLE);
        onCreate(db);
    }
}