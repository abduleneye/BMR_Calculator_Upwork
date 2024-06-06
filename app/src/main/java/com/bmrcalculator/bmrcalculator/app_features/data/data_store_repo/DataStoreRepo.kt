package com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



class DialogBoxVisibilityController(private val context: Context) {

    //To make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DialogBoxBoxVisibilityAndFrequency")
        val DIALOGBOX_STATUS_KEY = intPreferencesKey("dialog_status")

    }


    //To get dialog box status
    val getDialogBoxStatus: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[DIALOGBOX_STATUS_KEY] ?: 0

        }


    //To save dialog box status

    suspend fun saveDialogBoxStatus(dialogBoxStatus: Int) {
        context.dataStore.edit { preferences ->
            preferences[DIALOGBOX_STATUS_KEY] = dialogBoxStatus

        }
    }

}


