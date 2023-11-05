package com.anhpt.chplay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TypeAppAdapter(private val categories: ArrayList<TypeAppModel>) :
    RecyclerView.Adapter<TypeAppAdapter.MyViewHolder>() {
    lateinit var context: Context

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val revApps = row.findViewById<RecyclerView>(R.id.rev_list_app)
        val tvName = row.findViewById<TextView>(R.id.tv_category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        context = parent.context
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val category = categories[position]
        val appAdapter = AppAdapter(category.apps)
        holder.revApps.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.revApps.adapter = appAdapter
        holder.tvName.text = category.name
    }

    override fun getItemCount(): Int {
        return categories.size
    }


}