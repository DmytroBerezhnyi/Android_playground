package com.example.androidplayground.ui.activity

import androidx.activity.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseActivity
import com.example.androidplayground.architecture.base.BaseViewModel
import com.example.androidplayground.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {
    override val layoutId: Int = R.layout.activity_main

    override val vm: BaseViewModel by viewModels()
}