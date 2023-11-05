package com.anhpt.chplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(private val apps: ArrayList<AppModel>) :
    RecyclerView.Adapter<AppAdapter.MyViewHolder>() {
    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val name = row.findViewById<TextView>(R.id.tv_app_name)
        val rate = row.findViewById<TextView>(R.id.tv_app_rate)
        val appimg = row.findViewById<ImageView>(R.id.img_app)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.app_item, parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val app = apps[position]
        holder.name.text = app.name
        holder.rate.text = app.rate.toString()
        holder.appimg.setImageResource(app.image)
    }

    override fun getItemCount(): Int {
        return apps.size
    }


}