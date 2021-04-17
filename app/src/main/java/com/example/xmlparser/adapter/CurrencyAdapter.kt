package com.example.xmlparser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparser.R
import com.example.xmlparser.model.CurrencyModel
import kotlinx.android.synthetic.main.item_currency.view.*

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    private var data = ArrayList<CurrencyModel.Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.itemView.currency_abbreviation.text  = item.currencyAbbr
        holder.itemView.buy.text = item.buyRate
        holder.itemView.sell.text = item.sellRate

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: ArrayList<CurrencyModel.Currency>) {
        this.data = data
        notifyDataSetChanged()
    }


}