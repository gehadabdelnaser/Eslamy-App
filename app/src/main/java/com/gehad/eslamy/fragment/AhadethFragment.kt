package com.gehad.eslamy.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.gehad.eslamy.HadethDialog

import com.gehad.eslamy.R
import com.gehad.eslamy.adapter.ListAdapter
import com.gehad.base.BaseFragment
import com.gehad.eslamy.model.Constant
import kotlinx.android.synthetic.main.fragment_ahadeth.*


class AhadethFragment : BaseFragment() {

    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter= ListAdapter(createAhadethList())

        //to drow line in recycler view
        ahadeth_recycler_view.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.onItemCliclListener=
            object : ListAdapter.OnItemClickListener{
                override fun onItemClick(position: Int, itemQuran: String?) {

                    startAhadethActivity(position)
                }
            }

        ahadeth_recycler_view.adapter=adapter

        //snapHelper use in recyclerView to move as page...
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(ahadeth_recycler_view)
    }

    private fun createAhadethList(): List<String> {

        val list= mutableListOf<String>()
        for (soura in Constant.hadethName)
            list.add(soura)

        return list
    }

    fun startAhadethActivity(position:Int ){
        //position is number of hadeth...

        val args=Bundle()
        args.putInt(Constant.EXTRA_FILE_NAME_OF_HADETH,position+1)
        val dialogHadethFragment=HadethDialog()
        dialogHadethFragment.arguments=args
        dialogHadethFragment.show(childFragmentManager,"TAG")

    }




}
