package com.example.myfirstkotlin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

@LargeTest
class RegisterTest {
    @Rule
    @JvmField
    var activityTestRule=ActivityTestRule(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity(){

        // type account
        onView(withId(R.id.loginId)).perform(typeText("a123456789"),ViewActions.closeSoftKeyboard())

        // type password
        onView(withId(R.id.password)).perform(typeText("A111111111"),ViewActions.closeSoftKeyboard())

        //  click register button
        onView(withId(R.id.send)).perform(click())

        //  successfully register
        onView(withText("success!!")).check(matches(isDisplayed()))

    }

    @Test
    fun wrongPassword_should_alert(){

        onView(withId(R.id.loginId)).perform(typeText("a1234556778"),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.password)).perform(typeText("1234"),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.send)).perform(click())

        onView(withText("error"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))

    }
}