package com.example.android01.infra.dao
//package com.example.android01.model.repository

import android.content.Context
import com.example.android01.model.Review
import java.util.*
import com.example.android01.infra.dao.ReviewDao


class ReviewRepository{
    private val reviewDao: ReviewDao
    constructor(context: Context){
        val reviewDatabase = ReviewDatabase.getInstance(context)
        reviewDao = reviewDatabase.reviewDao()
    }
    fun save(name: String, review: String) {
        reviewDao.save(Review(UUID.randomUUID().toString(), name, review))
    }
    fun listAll(): List<Review> {
        return reviewDao.listAll()
    }

    fun delete(item: Review) {
        reviewDao.delete(item)
    }

    fun update(id: String, name: String, review: String) {
        reviewDao.update(Review(id, name, review))
    }
}