package com.gehad.eslamy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gehad.eslamy.adapter.ListAdapter
import com.gehad.eslamy.model.Constant
import kotlinx.android.synthetic.main.activity_soura.*
import java.io.InputStream

class SouraActivity : AppCompatActivity() {


    private lateinit var adapter: ListAdapter
    private var numberOfSoura:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soura)
        numberOfSoura=intent.getIntExtra(Constant.EXTRA_FILE_NAME,-1)

        getSouraName()

        //to drow line in recycler view
        soura_recycler_view.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter= ListAdapter(readSouraLine())
        soura_recycler_view.adapter=adapter

    }

    private fun readSouraLine(): List<String> {


        val list= mutableListOf<String>()

        var i = 0

        val fileNameSoura:InputStream=assets.open("$numberOfSoura.txt")
        if(numberOfSoura ==1)
            fileNameSoura.bufferedReader().useLines { lines->lines.forEach {
                list.add(it+" {${i+1}}")
                    i++
            }
        }
        else
        fileNameSoura.bufferedReader().useLines { lines->lines.forEach {

            if(i==0) { list.add(it)
                i++}
            else {list.add("$it {$i}")
                i++}
        } }
        return list

        // anther way..
//        try{
//        val fileNameSoura:InputStream =assets.open(fileName+".txt")
//        val reader= BufferedReader(InputStreamReader(fileNameSoura))
//
//        var line:String?=reader.readLine()

//        while(line!=null){
//
//            list.add(Soura(line))
//            line=reader.readLine()
//        }}
//       catch(ioe:IOException){ioe.printStackTrace()}

    }

    private fun getSouraName(){
        val intent=intent
        val souraName:String=intent.getStringExtra(Constant.EXTRA_SOURA_NAME)
        hadeth_name_tv.text = souraName
    }



}
