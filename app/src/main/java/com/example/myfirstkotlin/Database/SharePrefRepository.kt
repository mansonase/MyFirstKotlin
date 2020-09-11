package com.example.myfirstkotlin.Database

import android.content.Context

class SharePrefRepository(private val sharedPreferenceManager: ISharedPreferenceManager) {

    fun saveUserId(id:String){
        sharedPreferenceManager.saveString("USER_ID",id)
    }
}