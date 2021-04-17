package com.example.xmlparser.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.xmlparser.api.ApiUtils
import com.example.xmlparser.model.CurrencyModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object CurrencyRepository {

    fun getXml(): MutableLiveData<CurrencyModel> {
        val data = MutableLiveData<CurrencyModel>()

        ApiUtils.apiService?.getCurrencyInfo()?.enqueue(object : Callback<CurrencyModel> {
            override fun onResponse(call: Call<CurrencyModel>, response: Response<CurrencyModel>) {
                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<CurrencyModel>, t: Throwable) {
                Log.d("Error", "onFailure: " + t.message.toString())
            }

        })

        return data
    }


}