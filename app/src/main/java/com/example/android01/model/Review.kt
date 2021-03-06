package com.example.android01.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Review(
    @PrimaryKey
    val id: String,
    val name: String,
    val review: String? ):Serializable