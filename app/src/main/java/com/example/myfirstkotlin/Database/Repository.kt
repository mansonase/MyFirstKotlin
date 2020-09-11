package com.example.myfirstkotlin.Database

import android.content.Context

class Repository(val context: Context) {

    fun saveUserId(id:String){
        val sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("USER_ID",id).commit()
    }
}