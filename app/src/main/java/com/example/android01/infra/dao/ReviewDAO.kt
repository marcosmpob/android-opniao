package com.example.android01.infra.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android01.model.Review


@Dao
    interface ReviewDao {
        @Insert
        fun save(review: Review)
        @Query("SELECT * from ${ReviewTableInfo.TABLE_NAME}")
        fun listAll():List<Review>
        @Delete
        fun delete(item: Review)
}
