package com.example.myfirstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.myfirstkotlin.Database.Repository
import com.example.myfirstkotlin.Database.SharePrefRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.text="ok"
        tv_main.setOnClickListener(View.OnClickListener { tv_main.setText("not ok") })



        send.setOnClickListener {
            val loginId=loginId.text.toString()
            val pwd=password.text.toString()

            var isLoginIdOk=RegisterVerify().isLoginIdVerify(loginId)
            var isLoginPwdOK=RegisterVerify().isLoginPwdVerify(pwd)

            var isLoginNotOk= getIsLoginNotOk()

            if (!isLoginIdOk){
                val builder=AlertDialog.Builder(this)
                builder.setMessage("at least 6 characters and the first should be English").setTitle("error")
                builder.show()
            }else if (!isLoginPwdOK){
                val builder=AlertDialog.Builder(this)
                builder.setMessage("at least 8 characters with first char is English and contains 1 number").setTitle("error").show()
            }else{

                Repository(this).saveUserId(loginId)

                val intent=Intent(this,ResultActivity::class.java)
                intent.putExtra("ID",loginId)

                startActivity(intent)
            }
        }
    }

    private fun getIsLoginNotOk() = false


}