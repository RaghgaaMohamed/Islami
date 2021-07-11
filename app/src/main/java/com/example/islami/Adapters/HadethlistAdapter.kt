package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Hadeth
import com.example.islami.R
import kotlinx.android.synthetic.main.hadeth_item.*

class HadethlistAdapter (val items :List<String>):RecyclerView.Adapter<HadethlistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hadeth_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val titlehadeth = items.get(position)
        holder.title.setText(titlehadeth)
       if(OnHadethClick!=null){
            holder.itemView.setOnClickListener{
                OnHadethClick?.OnItemClick(position,titlehadeth)
            }
        }
    }

 var OnHadethClick : OnTitleHadethClickListener? =null


interface OnTitleHadethClickListener{
    fun  OnItemClick(position: Int, title:String)
}

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val title:TextView= itemView.findViewById(R.id.hadeth_title)
    }
}