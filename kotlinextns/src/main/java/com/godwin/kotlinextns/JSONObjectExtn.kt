package com.godwin.kotlinextns

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by WiSilica on 07-04-2021 11:34.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2021
 */

fun JSONObject.getIntOrNull(name: String): Int? =
    try {
        getInt(name)
    }
    catch (e: JSONException) {
        val strValue = getStringOrNull(name)
        strValue?.toIntOrNull()
    }

fun JSONObject.getDoubleOrNull(name: String): Double? =
    try {
        getDouble(name)
    }
    catch (e: JSONException) {
        null
    }

fun JSONObject.getLongOrNull(name: String): Long? =
    try {
        getLong(name)
    }
    catch (e: JSONException) {
        null
    }

fun JSONObject.getStringOrNull(name: String): String? =
    try {
        getString(name).trim()
    }
    catch (e: JSONException) {
        null
    }

fun JSONObject.getBooleanOrNull(name: String): Boolean? =
    try {
        getBoolean(name)
    }
    catch (e: JSONException) {
        null
    }

fun JSONObject.getObjectOrNull(name: String): JSONObject? =
    try {
        getJSONObject(name)
    }
    catch (e: JSONException) {
        null
    }

fun JSONObject.getArrayOrNull(name: String): JSONArray? =
    try {
        getJSONArray(name)
    }
    catch (e: JSONException) {
        null
    }

fun JSONObject.getArrayOrEmpty(name: String): JSONArray =
    try {
        getJSONArray(name)
    }
    catch (e: JSONException) {
        JSONArray()
    }