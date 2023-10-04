package com.example.recipeapp.retrofit

import com.example.recipeapp.retrofit.ApiUtils.Companion.BASE_URL
import com.example.recipeapp.utils.Constant.STORE
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RecipeRetrofitClient {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(RecipeDao::class.java)

}




