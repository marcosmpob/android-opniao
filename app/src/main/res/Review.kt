//package com.androiddesenv.opiniaodetudo.model
package com.example.android01.model

data class Review(val id: String, val name: String, val review: String)

class ReviewRepository{
    private constructor()

    val repo = ReviewRepository.instance

    companion object {
        val instance : ReviewRepository = ReviewRepository()
    }
}
