package com.example.androidplayground.ui.fragment.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.base.BaseViewModel
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidplayground.databinding.ChatFragmentBinding as Binding
import com.example.androidplayground.ui.fragment.chat.ChatVM as VM

@AndroidEntryPoint
class ChatFragment : BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.chat_fragment

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}