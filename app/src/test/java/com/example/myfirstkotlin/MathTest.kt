package com.example.myfirstkotlin

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MathTest {

    lateinit var math: Math

    @Before
    fun setup(){
        math= Math()
    }

    @Test
    fun addTest(){

        //val math=Math()
        val expected=3
        val actual=math.add(1,2)
        Assert.assertEquals(expected,actual)

    }

    @Test
    fun addTest2(){
        val math=Math2()
        val expected=3
        math.add(1,2)
        val actual=math.result
        Assert.assertEquals(expected,actual)

    }

    @Test
    fun testNumber1LessNumber2_minimumShouldBeNumber1(){
        //val math=Math()
        val expected=math.minimum(1,3)
        val actual=1
        Assert.assertEquals(expected,actual)
    }

    @Test
    fun testNumber2LessNumber1_minimumShouldBeNumber2(){
        //val math=Math()
        val expected=math.minimum(3,1)
        val actual =1
        Assert.assertEquals(expected,actual)

    }

}