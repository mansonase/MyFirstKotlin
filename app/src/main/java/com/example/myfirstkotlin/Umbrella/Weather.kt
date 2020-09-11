package com.example.myfirstkotlin.Umbrella

interface IWeather{
    fun isSunny():Boolean
}
class Weather :IWeather{
    override fun isSunny(): Boolean {
        TODO("Not yet implemented")
        return true
    }
}