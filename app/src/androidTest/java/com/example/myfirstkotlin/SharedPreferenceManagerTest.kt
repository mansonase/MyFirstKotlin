package com.example.myfirstkotlin

import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myfirstkotlin.Database.ISharedPreferenceManager
import com.example.myfirstkotlin.Database.SharedPreferenceManager
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SharedPreferenceManagerTest {

    @Test
    fun useAppContext(){

        // get context in test
        val appContext=InstrumentationRegistry.getInstrumentation().targetContext

        val key="user_id"
        val value="A123456789"

        // do saving
        val sharedPreferenceManager:ISharedPreferenceManager=SharedPreferenceManager(appContext)
        sharedPreferenceManager.saveString(key,value)

        // get string from database
        val valueFromSP=sharedPreferenceManager.getsString(key)

        // comparing
        Assert.assertEquals(value,valueFromSP)

    }
}