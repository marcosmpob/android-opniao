package com.example.android01.infra.dao

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class SQLiteDatabaseTool(readableDatabase: SQLiteDatabase) {
    companion object {
        fun selectAll(db: SQLiteDatabase, tableName:String, columns:Array<String>): Cursor {
            return db.query(
                tableName,
                columns,
                null,
                null,
                null,
                null,
                null
            ) }
    }

    fun SQLiteDatabase.selectAll(tableName:String, columns:Array<String>): Cursor {
        return this.query(
            tableName,
            columns,
            null,
            null,
            null,
            null,
            null
        )
    }

    fun SQLiteDatabase.query(
        tableName:String,
        columns:Array<String>,
        selection:String? = null,
        selectionArgs:Array<String>? = null,
        groupBy:String? = null,
        having:String? = null,
        orderBy:String? = null): Cursor {
        return this.query(
            tableName,
            columns,
            selection,
            selectionArgs,
            groupBy,
            having,
            orderBy
        ) }



    val cursor:Cursor = readableDatabase.selectAll(
        ReviewTableInfo.TABLE_NAME,
        arrayOf(
                ReviewTableInfo.COLUMN_ID,
                ReviewTableInfo.COLUMN_NAME,
                ReviewTableInfo.COLUMN_REVIEW
            )
    )
}