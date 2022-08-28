package com.fajar.tiptime

import android.content.Context
import android.content.SharedPreferences

class Preference (context : Context) {

    private val PREFS_NAME = "FajarMukhollis"
    private val sharedPref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

}