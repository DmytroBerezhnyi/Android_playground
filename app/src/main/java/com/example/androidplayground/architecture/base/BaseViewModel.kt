package com.example.androidplayground.architecture.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidplayground.architecture.model.NavigationModel
import com.example.androidplayground.architecture.model.SnackbarModel

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
    val navEvent = MutableLiveData<NavigationModel>()
    val snackLiveEvent = MutableLiveData<SnackbarModel>()
}