package com.godwin.kotlinextns

import android.util.Log

/**
 * Created by WiSilica on 05-04-2021 11:08.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

class L {
    companion object DEBUG {
        var isDebug = true
        var level =5
        var isIncludeStackDetails = true


        fun i(tag: String="", message: String) {
            if (isDebug) Log.i(getTag(tag), message)
        }

        fun e(tag: String="", message: String) {
            if (isDebug) Log.e(getTag(tag), message)
        }

        fun d(tag: String="", message: String) {
            if (isDebug) Log.d(getTag(tag), message)
        }

        fun v(tag: String="", message: String) {
            if (isDebug) Log.v(getTag(tag), message)
        }

        fun w(tag: String="", message: String) {
            if (isDebug) Log.w(getTag(tag), message)
        }
        private fun getTag(tag: String): String {
            if (isIncludeStackDetails) {
                try {
                    val methodName = Thread.currentThread().stackTrace[level].methodName
                    val line = Thread.currentThread().stackTrace[level].lineNumber
                    val clazz = Thread.currentThread().stackTrace[level].className
                    return "$clazz->$methodName:$line:$tag"
                } catch (e: Exception) {
                    //something happened
                }
            }
            return tag
        }
    }
}