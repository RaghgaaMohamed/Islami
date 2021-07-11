package com.example.islami.api

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    companion object{
        private var retrofit : Retrofit? =null
       private fun getRetrofitInstance(): Retrofit{
         if (retrofit==null){
             val interceptor = HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
                 override fun log(message: String) {
                     Log.e("api",message)
                 }
             })
             interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
             val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

             val gson = GsonBuilder()
                     .setLenient()
                     .create()


             retrofit = Retrofit.Builder().baseUrl("http://api.mp3quran.net/")
                     .client(client)
                     .addConverterFactory(GsonConverterFactory.create(gson))
                     .build()
         }
           return retrofit!!
        }

        fun getApis () :Webservices{
            return getRetrofitInstance().create(Webservices::class.java)
        }
    }

}