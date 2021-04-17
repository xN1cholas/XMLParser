package com.example.xmlparser.api

import com.example.xmlparser.model.CurrencyModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("rss.php/")
    fun getCurrencyInfo() : Call<CurrencyModel>

}