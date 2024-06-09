package com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DataStoreViewModel(private val repository: PreferencesRepository): ViewModel() {

    val entryCount: StateFlow<Int> = repository.entryCount.stateIn(viewModelScope, SharingStarted.Lazily, 0)
    val DialogShown: StateFlow<Boolean> = repository.dialogShown.stateIn(viewModelScope, SharingStarted.Lazily, true)

    init {
        viewModelScope.launch {
            repository.incrementEntryCount()
        }
    }

    fun updateDialogShown(shown: Boolean){
        viewModelScope.launch {
            repository.setDialogShown(
                shown = shown
            )
        }

    }

    fun resetDialogBoxStatusToDefault(){
        viewModelScope.launch {
            repository.resetToDefaultForCancellingDialogBox()
        }

    }


}

class DataStoreViewModelFactory(private val repository: PreferencesRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataStoreViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DataStoreViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
        //return super.create(modelClass)
    }

}