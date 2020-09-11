package com.example.myfirstkotlin.Umbrella

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class OrderTest {

    @Mock
    lateinit var mockEmailUtil:IEmailUtil

    private val userEmail="mail"
    private val order=Order()

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun orderTestWithMockito(){

        order.insertOrder(userEmail,1,300,mockEmailUtil)

        //verify(mockEmailUtil, times(1)).sendCustomer(userEmail)
        //verify(mockEmailUtil, never()).sendCustomer(userEmail)
        //verify(mockEmailUtil, atLeast(1)).sendCustomer(userEmail)
        verify(mockEmailUtil, atMost(1)).sendCustomer(userEmail)
    }
}