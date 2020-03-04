package com.example.android01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.android01.model.repository.ReviewRepository

//package com.example.android01.model.repository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val repo = ReviewRepository.instance

        val buttonSave = findViewById<Button>(R.id.button_save)
        val textViewName = findViewById<TextView>(R.id.input_nome)
        val textViewReview = findViewById<TextView>(R.id.input_review)


        buttonSave.setOnClickListener {
            val name = textViewName.text
            val review = textViewReview.text
            Toast.makeText(this, "Nome:$name - Opinião:$review", Toast.LENGTH_LONG).show();
            ReviewRepository.instance.save(name.toString(), review.toString())

            startActivity(Intent(this, ListActivity::class.java))
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.menu_list_reviews){
            startActivity(Intent(this, ListActivity::class.java))
            return true }
        return false
    }




}

