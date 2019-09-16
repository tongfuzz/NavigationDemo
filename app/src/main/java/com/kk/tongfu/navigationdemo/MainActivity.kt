package com.kk.tongfu.navigationdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navigationUse(view: View) {
        startActivity(Intent(this,NavigationUseActivity::class.java))
    }

    fun navigationUIUse(view:View){
        startActivity(Intent(this,NavigationUIActivity::class.java))
    }

    fun navigationPopUse(view:View){
        startActivity(Intent(this,NavPopActivity::class.java))
    }
}
