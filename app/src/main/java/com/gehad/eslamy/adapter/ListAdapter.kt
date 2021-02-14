package com.gehad.eslamy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gehad.eslamy.R

class ListAdapter(private var list:List<String>?) :RecyclerView.Adapter<ListAdapter.SouraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SouraViewHolder {

        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)

        return SouraViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list?.size?:0
    }

    override fun onBindViewHolder(holder: SouraViewHolder, position: Int) {

        val item=list?.get(position)

        holder.line.text = item

        if(onItemCliclListener!=null){
            
            holder.line.setOnClickListener{
                onItemCliclListener?.onItemClick(position,item)
            }
        }
    }

    var onItemCliclListener:OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick(position:Int , item:String?)
    }


    class SouraViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

         var line:TextView = itemView.findViewById(R.id.ayah_tv)
    }
}