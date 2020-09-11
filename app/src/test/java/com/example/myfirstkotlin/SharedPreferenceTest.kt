package com.example.myfirstkotlin

import android.content.Context
import android.content.SharedPreferences
import com.example.myfirstkotlin.Database.ISharedPreferenceManager
import com.example.myfirstkotlin.Database.SharePrefRepository
import org.junit.Test

import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*

class SharedPreferenceTest {


    /*
    @Test
    fun saveUserId(){
        // 1. set up mock
        val sharedPrefs=mock(SharedPreferences::class.java)
        val sharedPrefsEditor= mock(SharedPreferences.Editor::class.java)
        val context= mock(Context::class.java)

        // 2. set up when & thenReturn
        `when`(context.getSharedPreferences(anyString(),anyInt()))   .thenReturn(sharedPrefs)
        `when`(sharedPrefs.edit())                                   .thenReturn(sharedPrefsEditor)
        `when`(sharedPrefsEditor.putString(anyString(), anyString())).thenReturn(sharedPrefsEditor)

        val userId="A1234567"
        val preKey="USER_ID"

        // 3. execute test item
        val repository=SharePrefRepository(context)
        repository.saveUserId(userId)

        // 4. verify method, check if putString is called
        verify(sharedPrefsEditor).putString(
            argThat { key->key==preKey },
            argThat { value->value==userId }
        )

        // 5. check if sharedPreference commit
        verify(sharedPrefsEditor).commit()
    }

     */

    @Test
    fun saveUserId(){
        val mockSharedPreferencesManager= mock(ISharedPreferenceManager::class.java)

        val userId="A123334"
        val preKey="USER_ID"

        val repository=SharePrefRepository(mockSharedPreferencesManager)

        repository.saveUserId(userId)

        verify(mockSharedPreferencesManager).saveString(preKey,userId)
    }

}