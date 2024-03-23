package com.example.funfacts.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.data.UserInputState

class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputState())
    companion object{
        const val TAG = "UserInputViewModel"
    }

    fun onEvent(events: UserDataUiEvents){
        when(events){
            is UserDataUiEvents.UserNameEntered ->{
                uiState.value = uiState.value.copy(
                    name = events.nameEntered
                )
                Log.d(TAG,"UserNameEntered")
                Log.d(TAG,"${uiState.value}")
            }
            is UserDataUiEvents.AnimalSelected ->{
                uiState.value = uiState.value.copy(
                    animal = events.animalValue
                )
                Log.d(TAG,"UserAnimalSelected")
                Log.d(TAG,"${uiState.value}")
            }
        }
    }
    fun isAllGiven():Boolean {
        if (
            !uiState.value.name.isNullOrEmpty()
            &&
            !uiState.value.animal.isNullOrEmpty()
        ) {
            return true
        }
        else{
            return false
        }
    }
}

