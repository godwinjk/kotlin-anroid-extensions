package com.godwin.kotlinextns

import android.content.res.Resources
import java.text.DecimalFormat

/**
 * Created by WiSilica on 07-04-2021 12:41.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

fun Float.roundOff(): String {
    val df = DecimalFormat("##.##")
    return df.format(this)
}

val Float.pxTodp: Float
    get() = (this / Resources.getSystem().displayMetrics.density)

val Float.dpTopx: Float
    get() = (this * Resources.getSystem().displayMetrics.density)