package com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")
class PreferencesRepository(private val context: Context) {

    companion object {

        val ENTRY_COUNT_KEY = intPreferencesKey("entry_count")
        val DIALOG_SHOW_KEY = booleanPreferencesKey("dialog_shown")

    }

    val entryCount: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[ENTRY_COUNT_KEY] ?: 0
        }

    val dialogShown: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[DIALOG_SHOW_KEY] ?: false

        }

    suspend fun incrementEntryCount(){
        context.dataStore.edit { preferences ->
            val currentCount = preferences[ENTRY_COUNT_KEY] ?: 0
            preferences[ENTRY_COUNT_KEY] = currentCount + 1

        }
    }

    suspend fun setDialogShown(shown: Boolean){
        context.dataStore.edit { preferences ->
            preferences[DIALOG_SHOW_KEY] = shown
        }

    }

    suspend fun resetToDefaultForCancellingDialogBox(){
        context.dataStore.edit { preferences ->
            preferences[ENTRY_COUNT_KEY] = 0
            preferences[DIALOG_SHOW_KEY] = false


        }
    }


}