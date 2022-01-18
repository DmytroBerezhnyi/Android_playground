package com.example.androidplayground.ui.fragment.setting_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.base.BaseViewModel
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidplayground.databinding.SettingsDetailFragmentBinding as Binding
import com.example.androidplayground.ui.fragment.setting_detail.SettingDetailVM as VM

@AndroidEntryPoint
class SettingsDetailFragment : BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.settings_detail_fragment

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

@HiltViewModel
class SettingDetailVM @Inject constructor() : BaseViewModel()