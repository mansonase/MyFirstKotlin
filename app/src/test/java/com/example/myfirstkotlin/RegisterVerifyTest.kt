package com.example.myfirstkotlin

import org.junit.Assert.*
import org.junit.Test

class RegisterVerifyTest {

    @Test
    fun loginVerifyTrue(){
        val registerVerify=RegisterVerify()
        assertTrue(registerVerify.isLoginIdVerify("A123456"))
    }


    @Test
    fun loginVerifyFalse(){
        val registerVerify=RegisterVerify()
        assertFalse(registerVerify.isLoginIdVerify("A1234"))
    }
}