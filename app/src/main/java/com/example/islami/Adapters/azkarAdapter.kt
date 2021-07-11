package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class azkarAdapter (val item :List<String>):RecyclerView.Adapter<azkarAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.zekr_icon,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val zekr = item.get(position)
        holder.zekr_contact.setText(zekr)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val zekr_contact : TextView = itemView.findViewById(R.id.zekr)
    }
}