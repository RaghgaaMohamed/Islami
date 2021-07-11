package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import kotlinx.android.synthetic.main.azkar_item.*

class azkarlistAdapter (val item :List<String>): RecyclerView.Adapter<azkarlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.azkar_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val zekrName =item.get(position)
        holder.zekr_name.setText(zekrName)
        if(onzekrClick!=null)
            holder.itemView.setOnClickListener{
                onzekrClick?.onItemClick(position,zekrName)
            }
    }

var onzekrClick: OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick(position: Int,zekr :String)
    }
    class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val zekr_name :TextView=itemView.findViewById(R.id.zekrname)

    }
}