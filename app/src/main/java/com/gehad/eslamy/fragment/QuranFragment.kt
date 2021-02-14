package com.gehad.eslamy.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper

import com.gehad.eslamy.R
import com.gehad.eslamy.SouraActivity
import com.gehad.eslamy.adapter.QuranListAdapter
import com.gehad.base.BaseFragment
import com.gehad.eslamy.model.Constant
import kotlinx.android.synthetic.main.fragment_quran.*


class QuranFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }


    private lateinit var adapter: QuranListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter= QuranListAdapter(createQuranList())

        adapter.onItemClickListener=
            object :QuranListAdapter.OnItemClickListener{
                override fun onItemClick(position: Int, itemQuran: String?) {

                    startSouraActivity(position ,itemQuran)
                }
            }

        quran_recycler_view.adapter=adapter

        //snapHelper use in recyclerView to move as page...
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(quran_recycler_view)

    }


    private fun createQuranList(): List<String> {

        val list= mutableListOf<String>()
        for (soura in Constant.ArSuras)
            list.add(soura)

        return list
    }


    fun startSouraActivity(position:Int ,item:String?){
        //position is number of soura...

        val intent = Intent(context, SouraActivity::class.java)
        intent.putExtra(Constant.EXTRA_SOURA_NAME,item)
        intent.putExtra(Constant.EXTRA_FILE_NAME,position+1)
        startActivity(intent)

    }


}
