package com.example.androidplayground.architecture.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import com.example.androidplayground.architecture.extensions.findDefaultNavController

abstract class BaseActivity<DataBinding : ViewDataBinding, VM : BaseViewModel> :
    AppCompatActivity() {

    lateinit var binding: DataBinding

    protected abstract val vm: VM

    private var mNavController: NavController? = null

    protected val navController: NavController
        get() = mNavController!!

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        mNavController = findDefaultNavController()
    }
}