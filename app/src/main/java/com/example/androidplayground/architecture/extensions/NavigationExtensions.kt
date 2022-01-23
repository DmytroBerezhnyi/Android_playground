package com.example.androidplayground.architecture.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseActivity

fun BaseActivity<*, *>.findDefaultNavHost(): NavHostFragment {
    return (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment)
}

fun Fragment.findTopNavHost(): NavHostFragment {
    return requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_top) as NavHostFragment
}

fun Fragment.findBottomNavHost(): NavHostFragment {
    return requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_bottom) as NavHostFragment
}

fun Fragment.findDialogNavHost(): NavHostFragment {
    return requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_bottom) as NavHostFragment
}

fun BaseActivity<*, *>.findDefaultNavController(): NavController {
    return findDefaultNavHost().navController
}

fun Fragment.findTopNavController(): NavController {
    return findTopNavHost().navController
}

fun Fragment.findBottomNavController(): NavController {
    return findBottomNavHost().navController
}

fun Fragment.findDialogNavController(): NavController {
    return findDialogNavHost().navController
}

fun AppCompatActivity.isTablet(): Boolean {
    return supportFragmentManager.findFragmentById(R.id.fragment_container_bottom) != null
}