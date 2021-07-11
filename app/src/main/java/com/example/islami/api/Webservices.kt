package com.example.islami.api

import android.telecom.Call

import com.example.islami.RadioResponse
import retrofit2.Response
import retrofit2.http.GET


interface Webservices {

    @GET("radios/radio_arabic.json")
    fun getRadioChannel() : retrofit2.Call<RadioResponse>

}