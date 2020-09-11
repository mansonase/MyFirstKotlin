package com.example.myfirstkotlin.Database

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(override val context: Context):ISharedPreferenceManager{
    private val sharedPrefsKey="USER_DATA"
    private var sharedPreference:SharedPreferences

    init {
        sharedPreference=context.getSharedPreferences(sharedPrefsKey,Context.MODE_PRIVATE)
    }

    override fun saveString(key: String, value: String) {
        sharedPreference.edit().putString(key,value).commit()
    }

    override fun getsString(key: String): String {
        return sharedPreference.getString(key,"")!!
    }
}