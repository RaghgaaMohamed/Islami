package com.example.islami.ui.activity

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Adapters.ayaAdapter
import com.example.islami.AyaResponse
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.RecitersVerseItem
import com.example.islami.api.ApiManager
import com.route.base.BaseActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class SuraDetailsActivity : BaseActivity() {
    lateinit var ayaAdapter: ayaAdapter
    lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        
        val suraTitle =findViewById<TextView>(R.id.sura_title)
        val suraName =  intent.getStringExtra(Constants.EXTRA_Sura_Name) ?: ""
        val fileName =  intent.getStringExtra(Constants.EXTRA_File_Name) ?: ""
        val ayat = readSuraContent(fileName)
         
        recyclerView2=findViewById(R.id.recycler_view2)

        suraTitle.setText("سورة "+suraName)
        ayaAdapter= ayaAdapter(ayat)
        recyclerView2.adapter=ayaAdapter


    }

        private fun readSuraContent(fileName: String) :List<String>{
        val reader: BufferedReader
        val ayat= mutableListOf<String>()
        try {
            val file: InputStream = assets.open(fileName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
              ayat.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return ayat
    }

}