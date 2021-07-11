package com.example.islami.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.Adapters.azkarlistAdapter
import com.example.islami.Constants
import com.example.islami.R
import com.example.islami.ui.activity.ZekrDetailsActivity
import kotlinx.android.synthetic.main.fragment_azkar.*


class AzkarFragment : Fragment() {
    var Arazkar = listOf("أذكار الصباح","أذكار المساء","أذكار الاستيقاظ","أذكار النوم","أذكار الصلاة","أذكار الاذان")
lateinit var azkarlistAdapter: azkarlistAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_azkar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarlistAdapter= azkarlistAdapter(Arazkar)
        recyclerview_Azkar.adapter=azkarlistAdapter
        azkarlistAdapter.onzekrClick=object :azkarlistAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, zekr: String) {
                startZekrDetailsActivity(position,zekr)
            }
        }

    }


    private fun startZekrDetailsActivity(position: Int, zekr: String) {
        val ZekrfileName ="zekr"+(position+1)+".txt"
        val intent = Intent(context, ZekrDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_Zekr_Title,zekr)
        intent.putExtra(Constants.EXTRA_ZekrFile_Name,ZekrfileName)
        startActivity(intent)
    }

}