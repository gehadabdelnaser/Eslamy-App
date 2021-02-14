package com.gehad.eslamy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.gehad.eslamy.adapter.ListAdapter
import com.gehad.eslamy.model.Constant
import java.io.InputStream

class HadethDialog: DialogFragment() {

    private lateinit var adapter:ListAdapter
    private lateinit var hadethRecyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.dialog_hadeth ,container,false)

        adapter=ListAdapter(readHadethLine())
        hadethRecyclerView = view.findViewById(R.id.hadeth_recycler_view)
        hadethRecyclerView.adapter=adapter
        return view
    }

    private fun readHadethLine(): List<String> {

        val list= mutableListOf<String>()
        val args: Bundle? =arguments
        val hadethFileName =args?.getInt(Constant.EXTRA_FILE_NAME_OF_HADETH,-1)
        val fileNameHadeth: InputStream =activity?.assets!!.open("h$hadethFileName.txt")
        fileNameHadeth.bufferedReader().useLines { lines->lines.forEach { list.add(it) } }
        return list

    }
}