package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.RecitersVerseItem
import okhttp3.internal.readFieldOrNull

class ayaAdapter(var item :List<String?>?) :RecyclerView.Adapter<ayaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_aya,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return  item?.size ?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aya = item?.get(position)
        holder.aya_contact.setText(aya +"{ "+(position+1)+" }")

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val aya_contact : TextView = itemView.findViewById(R.id.aya)
    }


}
