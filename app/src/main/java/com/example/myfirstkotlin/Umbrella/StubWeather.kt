package com.example.myfirstkotlin.Umbrella

class StubWeather :IWeather {

    val fakeIsSunny=false

    override fun isSunny(): Boolean {

        return fakeIsSunny
    }
}