package com.godwin.kotlinextns

import java.text.DecimalFormat

/**
 * Created by WiSilica on 07-04-2021 11:41.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

fun Double.toPriceAmount(): String {
    val dec = DecimalFormat("###,###,###.00")
    return dec.format(this)
}