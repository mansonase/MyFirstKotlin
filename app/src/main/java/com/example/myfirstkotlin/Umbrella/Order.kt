package com.example.myfirstkotlin.Umbrella

class Order {
    fun insertOrder(email:String,quantity:Int,price:Int,emailUtil:IEmailUtil){
        val weather=StubWeather()
        val umbrella=Umbrella()
        umbrella.totalPrice(weather,quantity, price)


        //val emailUtil=MockEmailUtil()
        emailUtil.sendCustomer(email)
    }
}