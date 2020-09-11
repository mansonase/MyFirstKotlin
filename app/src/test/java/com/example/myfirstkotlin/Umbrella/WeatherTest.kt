package com.example.myfirstkotlin.Umbrella

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.*

class WeatherTest {


    @Test
    fun totalPrice_sunnyDay() {

        val umbrella=Umbrella()
        //val weather=StubWeather()
        val weather=mock(IWeather::class.java)
        `when`(weather.isSunny()).thenReturn(true)

        val actual=umbrella.totalPrice(weather,3,100)
        val expected=270

        Assert.assertEquals(expected,actual)
    }


    @Test
    fun testInsertOrder(){
        val order=Order()

        val mockEmailUtil=MockEmailUtil()

        val userEmail="someone@gmail.com"
        order.insertOrder(userEmail,1,200,mockEmailUtil)

        Assert.assertEquals(userEmail,mockEmailUtil.receiveEmail)
    }

    @Test
    fun insertOrderWithMockito(){
        val order=Order()
        val mockEmailUtil= mock(IEmailUtil::class.java)

        val userEmail="someone@gmail.com"
        order.insertOrder(userEmail,1,200,mockEmailUtil)

        verify(mockEmailUtil).sendCustomer(userEmail)
    }
}