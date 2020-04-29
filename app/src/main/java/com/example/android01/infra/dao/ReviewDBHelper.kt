package com.example.android01.infra.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ReviewDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {
        const val DATABASE_NAME = "review_database"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${ReviewTableInfo.TABLE_NAME} (" +
                " ${ReviewTableInfo.COLUMN_ID} TEXT PRIMARY KEY, " +
                " ${ReviewTableInfo.COLUMN_NAME} TEXT NOT NULL, " +
                " ${ReviewTableInfo.COLUMN_REVIEW} TEXT " +
                ")")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //como eh a versao 1, podemos simplesmente criar a database
        onCreate(db)
    }

}