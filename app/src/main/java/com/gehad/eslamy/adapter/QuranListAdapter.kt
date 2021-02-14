package com.gehad.eslamy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gehad.eslamy.R

class QuranListAdapter(private var list:List<String>?) :RecyclerView.Adapter<QuranListAdapter.QuranViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {

        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quran,parent,false)

        return QuranViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list?.size?:0
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {

        val item=list?.get(position)

        holder.souraName.text = item

        if (onItemClickListener != null)
          holder.itemView.setOnClickListener {
              onItemClickListener?.onItemClick(position, item)
          }

    }

    var onItemClickListener:OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick( position:Int , itemQuran:String?)
    }

    class QuranViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

         var souraName:TextView = itemView.findViewById(R.id.soura_name)
    }
}