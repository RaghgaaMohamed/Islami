package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuralistAdapter(val item :List<String>) :RecyclerView.Adapter<SuralistAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.sura_icon,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return  item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val suraName = item.get(position)
        holder.sura_name.setText(suraName)
        if(onSuranameClick!=null){
            holder.itemView.setOnClickListener {
             onSuranameClick?.onItemClick(position,suraName)
            }
        }
    }

var onSuranameClick : OnitemClickListener?=null
    interface OnitemClickListener{
        fun onItemClick(position: Int,name :String)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val sura_name : TextView = itemView.findViewById(R.id.sura_name)
    }
}
