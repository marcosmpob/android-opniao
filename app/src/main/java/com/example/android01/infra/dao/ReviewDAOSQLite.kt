package com.example.android01.infra.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class ReviewDAOSQLite {

    private val dbHelper: SQLiteOpenHelper
    constructor(context: Context){
        dbHelper = ReviewDBHelper(context)
    }

    fun save(name: String, review: String) {
        val writableDatabase = dbHelper.writableDatabase
        writableDatabase.insert(ReviewTableInfo.TABLE_NAME, null, ContentValues().apply {
            put(ReviewTableInfo.COLUMN_ID, UUID.randomUUID().toString())
            put(ReviewTableInfo.COLUMN_NAME, name)
            put(ReviewTableInfo.COLUMN_REVIEW, review)
        })
        writableDatabase.close()
    }
}