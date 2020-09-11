package com.example.myfirstkotlin.Database

import android.content.Context

interface ISharedPreferenceManager {
    val context:Context

    fun saveString(key:String,value:String)
    fun getsString(key: String):String
}