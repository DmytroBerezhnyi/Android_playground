package com.example.androidplayground.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.androidplayground.R
import com.example.androidplayground.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    protected lateinit var navController: NavController

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        navController = findDefaultNavController()
    }
}

fun MainActivity.findDefaultNavController(): NavController {
    return (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
}

fun Fragment.findTopNavController(): NavController {
    val navHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_top) as NavHostFragment
    return navHost.navController
}

fun Fragment.findBottomNavController(): NavController {
    val navHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_bottom) as NavHostFragment?
    return navHost?.navController ?: findNavController()
}

fun Fragment.findDialogNavController(): NavController {
    val navHost =
        requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_bottom) as NavHostFragment?
    return navHost?.navController ?: findNavController()
}