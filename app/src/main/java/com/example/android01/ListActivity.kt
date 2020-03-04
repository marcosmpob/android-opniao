package com.example.android01
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android01.model.Review
import com.example.android01.model.repository.ReviewRepository

class ListActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_review_layout)
        val listView = findViewById<ListView>(R.id.list_recyclerview)
        val reviews = ReviewRepository.instance.listAll()

        val adapter =  object : ArrayAdapter<Review>(this, -1, reviews ){
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val itemView = layoutInflater.inflate(R.layout.review_list_item_layout, null)
                val item = reviews[position]
                val textViewName = itemView.findViewById<TextView>(R.id.item_name)
                val textViewReview = itemView.findViewById<TextView>(R.id.item_review)
                textViewName.text = item.name
                textViewReview.text = item.review
                return itemView
            }
        }
        listView.adapter = adapter
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}