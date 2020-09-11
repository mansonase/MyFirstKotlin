package com.example.myfirstkotlin.Robolectric

import android.os.Build
import com.example.myfirstkotlin.MainActivity
import com.example.myfirstkotlin.ResultActivity
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowAlertDialog

@RunWith(RobolectricTestRunner::class)
@Config(sdk=[Build.VERSION_CODES.O_MR1])
class MainActivityTest {

    private lateinit var activity:MainActivity

    @Before
    fun setupActivity(){
        MockitoAnnotations.initMocks(this)
        activity=Robolectric.buildActivity(MainActivity::class.java).setup().get()
    }

    @Test
    fun registerSuccessShouldDirectToResult(){

        val shadowActivity=Shadows.shadowOf(activity)

        val userId="A1232344"
        val userPassword="a123234234"

        activity.loginId.setText(userId)
        activity.password.setText(userPassword)

        // click action
        activity.send.performClick()

        //
        val nextIntent=shadowActivity.nextStartedActivity
        assertEquals(nextIntent.component!!.className,ResultActivity::class.java.name)
        assertEquals(1,nextIntent.extras!!.size())
        assertEquals(userId,nextIntent.extras!!.getString("ID"))
    }

    @Test
    fun registerFailShouldAlert(){
        // arrange and setup
        val userId="A1234"
        val userPassword="11a12332222"

        activity.loginId.setText(userId)
        activity.password.setText(userPassword)

        // click
        activity.send.performClick()

        val dialog=ShadowAlertDialog.getLatestDialog()


        assertNotNull(dialog)
        assertTrue(dialog.isShowing)
    }
}