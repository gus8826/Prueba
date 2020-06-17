package com.example.prueba.StateSQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String DB_name = "DataBase_reports.db";
    private SQLiteDatabase db;

    private TableReports tableReports = new TableReports();
    public TableReports getTableReports() {
        return tableReports;
    }

    public SQLHelper(Context context) {
        super(context, DB_name, null, version);
        // TODO Auto-generated constructor stub
        db = getWritableDatabase();
        db.execSQL(tableReports.sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableReports.sql);
        Log.d("base de datos operando", "tabla tableSession creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableReports.table_reports);
        db.execSQL(tableReports.getSql());
    }
}