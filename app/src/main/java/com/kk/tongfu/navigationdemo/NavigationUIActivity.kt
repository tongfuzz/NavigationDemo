package com.kk.tongfu.navigationdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_navigation_ui.*

/**
 * Created by tongfu
 * on 2019-09-11
 * Desc:
 */

class NavigationUIActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_ui)
        navController = findNavController(R.id.navigation_ui_fragment)
        bottom_nav_view.setupWithNavController(navController)
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_18dp)
        toolbar.setCollapseIcon(R.drawable.ic_navigate_before_black_18dp)
        toolbar.setNavigationOnClickListener {
            if(drawerLayout.isDrawerOpen(navigationView)){
                drawerLayout.closeDrawer(navigationView)
            }else{
                drawerLayout.openDrawer(navigationView)
            }
        }
    }



}