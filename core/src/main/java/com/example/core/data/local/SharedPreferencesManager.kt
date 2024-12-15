package com.example.core.data.local

import android.content.Context
import com.google.gson.Gson
import javax.inject.Inject


class SharedPreferencesManager @Inject constructor(
    val gson: Gson, val context: Context
) {

    val sharedPreferences by lazy {
        context.getSharedPreferences(
            "app_preferences", Context.MODE_PRIVATE
        )
    }

    fun <T> put(key: String, value: T) {
        with(sharedPreferences.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is Any -> putString(key, gson.toJson(value))
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }.apply()
    }

    inline fun <reified T> get(key: String, default: T? = null): T? {
        return try {
            when (T::class) {
                String::class -> sharedPreferences.getString(key, default as? String) as T
                Int::class -> sharedPreferences.getInt(key, default as? Int ?: 0) as T
                Boolean::class -> sharedPreferences.getBoolean(
                    key,
                    default as? Boolean ?: false
                ) as T

                Long::class -> sharedPreferences.getLong(key, default as? Long ?: 0L) as T
                Float::class -> sharedPreferences.getFloat(key, default as? Float ?: 0f) as T
                else -> {
                    val json = sharedPreferences.getString(key, null) ?: return default
                    gson.fromJson(json, T::class.java)
                }
            }
        } catch (e: Exception) {
            default
        }
    }

    fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}