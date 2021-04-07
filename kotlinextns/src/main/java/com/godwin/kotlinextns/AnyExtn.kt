package com.godwin.kotlinextns

import android.os.Build
import java.util.*

/**
 * Created by WiSilica on 07-04-2021 12:36.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

val Any.deviceName: String
    get() {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer))
            model.capitalize(Locale.getDefault())
        else
            manufacturer.capitalize(Locale.getDefault()) + " " + model
    }