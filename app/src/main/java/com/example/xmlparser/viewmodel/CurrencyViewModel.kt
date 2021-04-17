package com.example.xmlparser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.xmlparser.model.CurrencyModel
import com.example.xmlparser.repository.CurrencyRepository

class CurrencyViewModel: ViewModel() {

    fun getXml() : LiveData<CurrencyModel> {
        return CurrencyRepository.getXml()
    }


    

}