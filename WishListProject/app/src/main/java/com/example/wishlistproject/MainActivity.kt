package com.example.wishlistproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

//lateinit var itemList: List<WishlistItem>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.Submit)
        val wishlist = mutableListOf<WishlistItem>()
        val name = findViewById<EditText>(R.id.ItemName)
        val price = findViewById<EditText>(R.id.Price)
        val url = findViewById<EditText>(R.id.UrlName)
        val recycler = findViewById<RecyclerView>(R.id.Items)
        val adapter = WishlistAdap(wishlist)
        recycler.adapter = adapter

        recycler.layoutManager = LinearLayoutManager(this)

        submit.setOnClickListener{
            val item = name.text.toString()
            val cost = price.text.toString()
            val link = url.text.toString()

            val newItem = WishlistItem(item,cost,link)
            wishlist.add(newItem)
            adapter.notifyItemInserted(wishlist.lastIndex)


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}