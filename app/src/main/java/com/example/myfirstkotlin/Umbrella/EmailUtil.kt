package com.example.myfirstkotlin.Umbrella

interface IEmailUtil {
    fun sendCustomer(email:String)
}


class MockEmailUtil:IEmailUtil {

    var receiveEmail:String?=null

    override fun sendCustomer(email: String) {
        receiveEmail=email
    }
}
