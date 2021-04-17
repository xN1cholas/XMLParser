package com.example.xmlparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xmlparser.adapter.CurrencyAdapter
import com.example.xmlparser.model.CurrencyModel
import com.example.xmlparser.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    private var currencyViewModel: CurrencyViewModel? = null

    private var currencyAdapter = CurrencyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currencyViewModel = ViewModelProviders.of(this).get(CurrencyViewModel::class.java)

        initRecycler()


        currencyViewModel?.getXml()?.observe(this, {
            val list = parseHtml(it)
            currencyAdapter.setData(list)
        })

    }


    private fun initRecycler() {
        currency_recycler?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = currencyAdapter
        }
    }


    private fun parseHtml(currencyModel: CurrencyModel): ArrayList<CurrencyModel.Currency> {
        val list = ArrayList<CurrencyModel.Currency>()

        val doc = Jsoup.parse(currencyModel.channel?.item?.description)
        val table = doc.select("table")
        val rows = table.select("tr")
        for (item in 0 until rows.size) {
            val ct = CurrencyModel.Currency()
            val row = rows[item]
            val cols = row.select("td")
            ct.currencyAbbr = cols[0].text()
            ct.name = cols[1].text()
            ct.buyRate = cols[2].text()
            ct.sellRate = cols[4].text()
            list.add(ct)
        }

        return list
    }

}