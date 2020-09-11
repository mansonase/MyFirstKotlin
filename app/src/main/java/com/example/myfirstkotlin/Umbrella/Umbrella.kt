package com.example.myfirstkotlin.Umbrella



class Umbrella(){

    fun totalPrice(weather:IWeather,quantity:Int,price:Int):Int{

        var price=quantity*price
        if (weather.isSunny())price=(price*0.9).toInt()

        return price
    }
}