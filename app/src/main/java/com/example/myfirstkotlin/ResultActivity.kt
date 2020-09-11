package com.example.myfirstkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstkotlin.Database.ISharedPreferenceManager
import com.example.myfirstkotlin.Database.SharePrefRepository
import com.example.myfirstkotlin.Database.SharedPreferenceManager
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val id=intent.getStringExtra("ID")
        registered_id.text="success!!"

        //SharePrefRepository(SharedPreferenceManager(this)).saveUserId(id)

    }
}