package com.example.androidplayground.ui.fragment.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.model.NavigationModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import com.example.androidplayground.databinding.SplashFragmentBinding as Binding
import com.example.androidplayground.ui.fragment.splash.SplashVM as VM

@AndroidEntryPoint
class SplashFragment : BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.splash_fragment

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.navigateToMaMainScreen()

        lifecycleScope.launchWhenCreated {
            vm.sharedFlow.collectLatest {
                navigateTo(NavigationModel(
                    direction = SplashFragmentDirections.actionSplashFragmentToMainFragment()
                ))
            }
        }
    }
}