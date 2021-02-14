package com.gehad.eslamy.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import com.gehad.eslamy.R
import com.gehad.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tasbeh.*


class TasbehFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbeh, container, false)
    }

     var tasbeha=0
     private var countTasbeh=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        doaa_item.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                tasbeha = 0
                tasbeha_tv.text = "0"
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        sabha_image.setOnClickListener{
            tasbeha++
            countTasbeh++
            tasbeha_tv.text = "$tasbeha"
            tasbeha_count_tv.text = "$countTasbeh"

        }
        refresh_image.setOnClickListener{
            tasbeha = 0
            countTasbeh = 0
            tasbeha_tv.text = "0"
            tasbeha_count_tv.text = "0"
        }
    }
}
