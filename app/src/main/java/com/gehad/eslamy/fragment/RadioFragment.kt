package com.gehad.eslamy.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.PagerSnapHelper

import com.gehad.eslamy.R
import com.gehad.eslamy.adapter.RadioChannelAdapter
import com.gehad.eslamy.api.ApiManager
import com.gehad.base.BaseFragment
import com.gehad.eslamy.data.RadiosItem
import com.gehad.eslamy.data.RadiosResponse
import com.gehad.eslamy.model.Constant
import kotlinx.android.synthetic.main.fragment_radio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : BaseFragment() {

    var adapter = RadioChannelAdapter(null)
    private var mediaPlayer:MediaPlayer ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radio_channel_recycler_view.adapter=adapter
        PagerSnapHelper().attachToRecyclerView(radio_channel_recycler_view)

        getRadioChannelsFromApi()
        adapter.onPlayCliclListener=object :RadioChannelAdapter.OnItemClickListener{

            override fun onItemClick(position: Int, item: RadiosItem?) {
                playChannel(item?.uRL)
              Constant.indexImage= position
            }
        }

        adapter.onStopCliclListener=object :RadioChannelAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, item: RadiosItem?) {
                stopChannel()
            }
        }
    }

    private fun stopChannel() {
        if(mediaPlayer!=null) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer=null
        }
    }

    private fun playChannel(uRL: String?) {
        stopChannel()
        if (uRL==null) return
        mediaPlayer= MediaPlayer()
        mediaPlayer?.setDataSource(uRL)
        // OR
        // mediaPlayer?.setDataSource(activity, Uri.parse(uRL))
        mediaPlayer?.prepareAsync()
        mediaPlayer?.setOnPreparedListener{
            it.start()
        }
    }

    private fun getRadioChannelsFromApi() {
        ApiManager.getWebServices().getRadiosChannels()
            .enqueue(object :Callback<RadiosResponse>{
                override fun onFailure(call: Call<RadiosResponse>, t: Throwable) {

                    showMassage(getString(R.string.error),t.localizedMessage,
                        null,null,null,null,true)
                }
                override fun onResponse(
                    call: Call<RadiosResponse>, response: Response<RadiosResponse>) {

                    progress_bar.visibility=View.GONE
                    adapter.changeData(response.body()?.radios)
                }
            })
    }

    override fun onPause() {
        super.onPause()
        stopChannel()
    }
    
}
