package com.example.xmlparser.api

object ApiUtils {

    val apiService: APIService?
        get() = RetrofitClient.getClient()?.create(APIService::class.java)

}