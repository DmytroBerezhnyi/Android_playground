package com.example.androidplayground.ui.fragment.splash

import androidx.lifecycle.viewModelScope
import com.example.androidplayground.architecture.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor() : BaseViewModel() {

    val sharedFlow = MutableSharedFlow<Boolean>()

    fun navigateToMaMainScreen() {
        viewModelScope.launch {
            delay(1000)
            sharedFlow.emit(true)
        }
    }
}