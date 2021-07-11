package com.example.islami.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
       navigation.setOnNavigationItemSelectedListener { item->
           if(item.itemId==R.id.quran_navigation){
           pushFragment(QuranFragment())
           }else if(item.itemId==R.id.hadeth_navigation){
               pushFragment(HadethFragment())
           }else if (item.itemId==R.id.tasbeh_navigation){
               pushFragment(TasbehFragment())
           }else if (item.itemId===R.id.azkar_navigation){
               pushFragment(AzkarFragment())
           } else if (item.itemId===R.id.radio_navigation){
               pushFragment(RadioFragment())
           }


           true }
       navigation.selectedItemId=R.id.quran_navigation

    }
    fun pushFragment (fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_containar,fragment).commit()
    }

    }
