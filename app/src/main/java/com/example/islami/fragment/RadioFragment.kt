package com.example.islami.fragment

import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.islami.Adapters.RadioAdapter
import com.example.islami.R
import com.example.islami.RadioResponse
import com.example.islami.RadiosChannel
import com.example.islami.api.ApiManager
import com.example.islami.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_radio.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class RadioFragment : BaseFragment() {
lateinit var radioAdapter : RadioAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerview()
      ApiManager.getApis().getRadioChannel().enqueue(object :retrofit2.Callback<RadioResponse>{
          override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
              showDialoge(message = "internet issue "+t.localizedMessage,posActionName = "ok",
              posAction = DialogInterface.OnClickListener{
                  dialog, _ ->
                 // call.enqueue(this)
                  dialog.dismiss()
              },negActionName = "cancel",negAction = DialogInterface.OnClickListener{
                      dialog, _ ->
                      dialog.dismiss()
                  })


          }

          override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
              if(response.isSuccessful){
                  progress_bar.visibility=View.GONE
                val data =response.body()
                  Log.e("data", data.toString())
                  radioAdapter.changeData(data?.radios)
              }
          }
      })

    }

    private fun setRecyclerview() {
        radioAdapter= RadioAdapter(null)
        recycler_view_radio.adapter=radioAdapter
        radioAdapter.onPlayClick = object : RadioAdapter.OnItemClickListener{
            override fun OnItemClickListener(position: Int, radioUrl: RadiosChannel) {
                playMedia(radioUrl.radioUrl)
            }
        }
        radioAdapter.onStopClick = object : RadioAdapter.OnItemClickListener{
            override fun OnItemClickListener(position: Int, radioUrl: RadiosChannel) {
              stopMedia()
            }
        }
    }
    var mediaPlayer = MediaPlayer()
    private fun playMedia(radioUrl: String?) {
         stopMedia()
        mediaPlayer.setDataSource(activity!!, Uri.parse(radioUrl))
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener{
            it.start()
        }
    }

    private fun stopMedia() {
      if (mediaPlayer.isPlaying)
          mediaPlayer.stop()
        mediaPlayer.reset()
    }


}




