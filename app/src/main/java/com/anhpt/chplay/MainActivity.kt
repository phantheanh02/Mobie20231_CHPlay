package com.anhpt.chplay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var categories: ArrayList<TypeAppModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apps: ArrayList<AppModel> = ArrayList()
        repeat(28) {
            val index = it + 1
            apps.add(
                AppModel(
                    name = "App $index",
                    resources.getIdentifier("thumb$index", "drawable", packageName),
                    rate = 5.0
                )
            )
        }

        categories = ArrayList()
        repeat(10) {
            val index = it + 1
            categories.add(TypeAppModel(name = "Type App $index", apps = apps))
        }

        val categoryRcv = findViewById<RecyclerView>(R.id.rev_list_category)
        categoryRcv.layoutManager = LinearLayoutManager(this)
        categoryRcv.adapter = TypeAppAdapter(categories)
    }

}