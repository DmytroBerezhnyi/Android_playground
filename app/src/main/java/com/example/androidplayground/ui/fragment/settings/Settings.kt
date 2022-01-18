package com.example.androidplayground.ui.fragment.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.base.BaseViewModel
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidplayground.databinding.SettingsFragmentBinding as Binding
import com.example.androidplayground.ui.fragment.settings.SettingsVM as VM

@AndroidEntryPoint
class SettingsFragment : BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.settings_fragment

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

@HiltViewModel
class SettingsVM @Inject constructor() : BaseViewModel()