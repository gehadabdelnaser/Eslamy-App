package com.gehad.eslamy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.gehad.eslamy.R
import com.gehad.eslamy.data.RadiosItem
import com.gehad.eslamy.model.Constant
import kotlinx.android.synthetic.main.fragment_radio.*
import kotlinx.android.synthetic.main.item_radio.view.*

class RadioChannelAdapter(private var list:List<RadiosItem?>?) :RecyclerView.Adapter<RadioChannelAdapter.RadioChannelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioChannelViewHolder {

        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radio,parent,false)

        return RadioChannelViewHolder(view)
    }

    override fun getItemCount(): Int {

        return list?.size?:0
    }

    var clicked:Boolean=false
    override fun onBindViewHolder(holder: RadioChannelViewHolder, position: Int) {

        val item=list?.get(position)

        holder.radioChannelName.text=item?.name

        if (clicked) {
            if (Constant.indexImage == position) {
                holder.play.setImageResource(R.drawable.ic_play1)
            } else {
                holder.play.setImageResource(R.drawable.ic_play)
            }
        }
        if(onPlayCliclListener!=null){
            holder.play.setOnClickListener {
                onPlayCliclListener?.onItemClick(position,item)
                clicked=true
                notifyDataSetChanged()
            }
        }

        if(onStopCliclListener!=null){
            holder.stop.setOnClickListener {
                onStopCliclListener?.onItemClick(position,item)
                holder.play.setImageResource(R.drawable.ic_play)
            }
        }
    }

    var onPlayCliclListener:OnItemClickListener?=null
    var onStopCliclListener:OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick(position:Int, item:RadiosItem?)
    }

    fun changeData(newList : List<RadiosItem?>?){
        this.list = newList
        notifyDataSetChanged()
    }

    class RadioChannelViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        var radioChannelName:TextView = itemView.findViewById(R.id.radio_channel_name_tv)
        var play:ImageView = itemView.findViewById(R.id.play_image)
        var stop:ImageView = itemView.findViewById(R.id.stop_image)

    }
}