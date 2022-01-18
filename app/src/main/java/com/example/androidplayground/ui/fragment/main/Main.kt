package com.example.androidplayground.ui.fragment.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.base.BaseViewModel
import com.example.androidplayground.ui.activity.MainActivity
import com.example.androidplayground.ui.activity.findDefaultNavController
import com.example.androidplayground.ui.activity.findTopNavController
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidplayground.databinding.MainFragmentBinding as Binding
import com.example.androidplayground.ui.fragment.main.MainVM as VM

@AndroidEntryPoint
class MainFragment : BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.main_fragment

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = when {
            (requireActivity() as MainActivity).binding?.fragmentContainerTop != null -> {
                findTopNavController()
            }
            else -> {
                findNavController()
            }
        }

        navController.navigate(R.id.chatListFragment)
    }
}

@HiltViewModel
class MainVM @Inject constructor() : BaseViewModel()