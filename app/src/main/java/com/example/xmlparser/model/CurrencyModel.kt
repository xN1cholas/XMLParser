package com.example.xmlparser.model

import org.simpleframework.xml.*

@Root(name = "rss", strict = false)
data class CurrencyModel @JvmOverloads constructor(
    @field:Element(name = "channel", required = false)
    var channel: Channel? = null
) {

    class Channel {
        var item: Item? = null
    }

    class Item {
        @field:Element(name = "description", required = false)
        var description: String? = null
    }


    class Currency {
        var currencyAbbr: String? = null
        var name: String? = null
        var sellRate: String? = null
        var buyRate: String? = null
    }


}