package com.godwin.kotlinextns

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by WiSilica on 07-04-2021 11:42.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

fun Long.getTimeStamp(timeStamp:String="EEEE, MMMM d, yyyy - hh:mm:ss a"): String {
    val date = Date(this)
    val simpleDateFormat = SimpleDateFormat(timeStamp, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}

fun Long.getYearMonthDay(dateFormat:String="yyyy-MM-dd"): String {
    val date = Date(this)
    val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}