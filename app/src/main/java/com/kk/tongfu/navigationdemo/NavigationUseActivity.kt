package com.kk.tongfu.navigationdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationUseActivity:AppCompatActivity() {

    lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        //向navhost传递数据，即向第一页传递数据
        navController = findNavController(R.id.fragment)
        navController.setGraph(R.navigation.nav_graph,Bundle().apply {
            putString("params","paramsInfos")
        })

    }

    //经navigation与optionsMenu进行关联
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigationuse_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)
    }
}
