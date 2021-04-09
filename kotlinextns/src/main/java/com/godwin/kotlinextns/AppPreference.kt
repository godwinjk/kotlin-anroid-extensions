package com.godwin.kotlinextns

import android.content.Context
import androidx.core.content.edit
import kotlin.reflect.KProperty

/**
 * Created by Godwin on 1/6/2020 11:00 AM.
 *
 * @author : Godwin Joseph Kurinjikattu
 * @since : 2020
 */

typealias  Input<T> = () -> T

fun Context.appPreference(name: String): Lazy<AppPreference> {
    return object : Lazy<AppPreference> {
        private var cached: AppPreference? = null
        override val value: AppPreference
            get() {
                if (null == cached) {
                    cached = AppPreference(this@appPreference, name)
                }
                return cached!!
            }

        override fun isInitialized()= cached!= null
    }
}

inline fun AppPreference.setData(action: AppPreference.() -> Unit) {
    action()
}

inline fun <reified T> AppPreference.getData(key: String, defaultValue: T): T =
    when (defaultValue) {
        is Int -> getInt(key, defaultValue) as T
        is Long -> getLong(key, defaultValue) as T
        is Double -> getDouble(key, defaultValue) as T
        is String -> getString(key, defaultValue) as T
        is Boolean -> getBool(key, defaultValue) as T
        else -> defaultValue
    }

/**
 * Support SharedPreference class for small data persistence.
 *
 * Can be initialized using lazy method
 * <p>
 *     val preference by Preference { context }
 *     OR
 *     val Preference by ArixaPreference(context)
 * </p>
 *
 */
class AppPreference(private val context: Context, private val prefName: String) {

    private val preference by lazy {
        context.getSharedPreferences(
            prefName,
            Context.MODE_PRIVATE
        )
    }

    fun setDouble(key: String, input: Input<Double>) = preference.edit {
        putLong(key, java.lang.Double.doubleToRawLongBits(input()))
    }

    fun setDouble(key: String, input: Double) = preference.edit {
        putLong(key, java.lang.Double.doubleToRawLongBits(input))
    }

    fun getDouble(key: String, defaultValue: Double = 0.0): Double =
        java.lang.Double.longBitsToDouble(
            preference.getLong(
                key,
                java.lang.Double.doubleToLongBits(defaultValue)
            )
        )

    fun setLong(key: String, input: Input<Long>) = preference.edit {
        putLong(key, input())
    }

    fun setLong(key: String, input: Long) = preference.edit {
        putLong(key, input)
    }

    fun getLong(key: String, defaultValue: Long = 0): Long = preference.getLong(key, defaultValue)

    fun setBool(key: String, input: Input<Boolean>) = preference.edit {
        putBoolean(key, input())
    }

    fun setBool(key: String, input: Boolean) = preference.edit {
        putBoolean(key, input)
    }

    fun getBool(key: String, defaultValue: Boolean = false): Boolean =
        preference.getBoolean(key, defaultValue)

    fun setInt(key: String, input: Input<Int>) = preference.edit {
        putInt(key, input())
    }

    fun setInt(key: String, input: Int) = preference.edit {
        putInt(key, input)
    }

    fun getInt(key: String, defaultValue: Int = 0): Int = preference.getInt(key, defaultValue)

    fun setString(key: String, input: Input<String>) = preference.edit {
        putString(key, input())
    }

    fun setString(key: String, input: String) = preference.edit {
        putString(key, input)
    }

    fun getString(key: String, defaultValue: String = ""): String =
        preference.getString(key, defaultValue) ?: ""

    fun clear() {
        preference.edit {
            clear()
        }
    }

    //delegated property
    operator fun getValue(thisRef: Any?, property: KProperty<*>): AppPreference {
        return AppPreference(context, prefName)
    }
}