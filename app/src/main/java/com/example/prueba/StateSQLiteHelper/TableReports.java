package com.example.prueba.StateSQLiteHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TableReports {
    private String idReport = "idReport";
    private String idUser = "idUser";
    private String name = "name";
    private String nameAlias = "nameAlias";
    private String image_ = "image_";
    String table_reports = "table_reports";
    String sql = "CREATE TABLE IF NOT EXISTS " + table_reports + " (" + idReport + " TEXT," + idUser + " TEXT," + name + " TEXT," + nameAlias + " TEXT," + image_ + " TEXT)";

    public String getSql() {
        return sql;
    }

    public void AddInformationsLogin(SQLiteDatabase db, String idReport, String idUser, String name, String nameAlias, String image_) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(this.idReport, idReport);
        contentValues.put(this.idUser, idUser);
        contentValues.put(this.name, name);
        contentValues.put(this.nameAlias, nameAlias);
        contentValues.put(this.image_, image_);

        db.insert(table_reports, null, contentValues);
        Log.d("DataBase procesado", "una fila insertada");

    }

    public String upDateInformation(SQLiteDatabase db, String idReport) {
        return "UPDATE table_reports SET " + this.idReport + "=" + idReport;
    }
}
