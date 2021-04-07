package com.godwin.kotlinextns

import android.content.res.Resources

/**
 * Created by WiSilica on 07-04-2021 12:41.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

fun Int.appendOrdinal(): String {
    return ordinalOf(this)
}

private fun ordinalOf(i: Int) = "$i" + if (i % 100 in 11..13) "th" else when (i % 10) {
    1 -> "st"
    2 -> "nd"
    3 -> "rd"
    else -> "th"
}

val Int.pxTodp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.dpTopx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()