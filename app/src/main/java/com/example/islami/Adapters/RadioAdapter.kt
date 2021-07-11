package com.example.islami.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.RadiosChannel

class RadioAdapter(var items :List<RadiosChannel?>?):RecyclerView.Adapter<RadioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.radio_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.title.setText(item?.name)
        if (onPlayClick!=null){
            holder.play.setOnClickListener{
         onPlayClick?.OnItemClickListener(position,item!!)
            }
        }

        if (onStopClick!=null){
             holder.stop.setOnClickListener {
                 onStopClick?.OnItemClickListener(position, item!!)
             }
        }
    }

    var onPlayClick : OnItemClickListener?=null
    var onStopClick : OnItemClickListener?=null

    interface OnItemClickListener {
        fun OnItemClickListener (position: Int,radioUrl: RadiosChannel)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.radio_title)
        val play: ImageView = itemView.findViewById(R.id.play)
        val stop: ImageView = itemView.findViewById(R.id.stop)
    }

    fun changeData(items: List<RadiosChannel?>?){
        this.items=items
        notifyDataSetChanged()
    }
}