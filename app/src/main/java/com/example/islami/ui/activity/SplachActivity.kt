package com.example.islami.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.islami.R

class SplachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach)
        Handler().postDelayed({gotosuralist()},2000)
    }

    private fun gotosuralist() {
        val intent=Intent(this@SplachActivity,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}