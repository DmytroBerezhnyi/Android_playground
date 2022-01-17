package com.example.androidplayground.architecture.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidplayground.architecture.model.NavigationModel
import com.example.androidplayground.architecture.model.SnackbarModel
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<DataBinding : ViewDataBinding, VM : BaseViewModel>() : Fragment() {

    protected abstract val vm: VM

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected lateinit var binding: DataBinding

    protected lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)

        vm.navEvent.observe(viewLifecycleOwner, { this.navigateTo(it) })
        vm.snackLiveEvent.observe(viewLifecycleOwner, { this.showSnackBar(it) })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    protected fun navigateTo(navigationModel: NavigationModel?) {
        navigationModel?.let {
            when {
                it.popBack ->
                    navController.navigateUp()
                it.direction != null && it.extras != null ->
                    navController.navigate(
                        it.direction!!,
                        it.extras!!
                    )
                it.direction != null -> {
                    navController.navigate(it.direction!!)
                }
            }
            vm.navEvent.value = null
        }
    }


    protected fun showSnackBar(snackbarModel: SnackbarModel) {
        val message =
            snackbarModel.idResMessage?.let { getString(it) } ?: snackbarModel.message ?: ""
        view?.let {
            val snackbar = Snackbar.make(it, message, snackbarModel.duration)
            snackbarModel.actionTitle?.let { res ->
                snackbar.setAction(getString(res)) {
                    snackbarModel.action?.invoke()
                }
            }
            snackbar.show()
        }
    }
}