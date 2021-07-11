package com.example.islami.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.Adapters.azkarAdapter
import com.example.islami.Constants
import com.example.islami.R
import kotlinx.android.synthetic.main.activity_zekr_details.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class ZekrDetailsActivity : AppCompatActivity() {
    lateinit var azkarAdapter: azkarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zekr_details)
        val zekrTitle =  intent.getStringExtra(Constants.EXTRA_Zekr_Title) ?: ""
        val fileZekrName =  intent.getStringExtra(Constants.EXTRA_ZekrFile_Name) ?: ""
        val azkar = readazkarContent(fileZekrName)
        zekr_title.setText(zekrTitle)
        azkarAdapter= azkarAdapter(azkar)
        recyclerview_Azkarlist.adapter=azkarAdapter
    }

    private fun readazkarContent(fileZekrName: String) :List<String>{
        val reader: BufferedReader
        val azkar= mutableListOf<String>()
        try {
            val file: InputStream = assets.open(fileZekrName)
            reader = BufferedReader(InputStreamReader(file))
            var line: String? = reader.readLine()
            while (line != null) {
                azkar.add(line)
                line = reader.readLine()
            }
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return azkar
    }
}