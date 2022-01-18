package com.example.androidplayground.ui.fragment.chat_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.base.BaseViewModel
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidplayground.databinding.ChatListFragmentBinding as Binding
import com.example.androidplayground.ui.fragment.chat_list.ChatListVM as VM

@AndroidEntryPoint
class ChatListFragment : BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.chat_list_fragment

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

@HiltViewModel
class ChatListVM @Inject constructor() : BaseViewModel()