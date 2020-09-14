package com.example.myfirstkotlin

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.android.synthetic.main.numberselect.view.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NumberSelectAndroidTest {

    @Test
    fun test_addButton_thenValueShouldAdd(){
        val context=InstrumentationRegistry.getInstrumentation().targetContext
        val numberSelect=NumberSelect(context)
        numberSelect.setDefaultValue(1)
        numberSelect.addButton.performClick()

        Assert.assertEquals(2,numberSelect.textValue)
    }

    @Test
    fun test_minusButton_thenValueShouldMinus(){
        val context=InstrumentationRegistry.getInstrumentation().targetContext
        val numberSelect=NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.minusButton.performClick()

        Assert.assertEquals(1,numberSelect.textValue)
    }

    @Test
    fun test_minValueLimit(){
        val context=InstrumentationRegistry.getInstrumentation().targetContext
        val numberSelect=NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.setMinValue(2)
        numberSelect.minusButton.performClick()

        Assert.assertEquals(2,numberSelect.textValue)
    }

    @Test
    fun test_maxValueLimit(){
        val context=InstrumentationRegistry.getInstrumentation().targetContext
        val numberSelect=NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.setMaxValue(2)
        numberSelect.addButton.performClick()

        Assert.assertEquals(2,numberSelect.textValue)
    }

}