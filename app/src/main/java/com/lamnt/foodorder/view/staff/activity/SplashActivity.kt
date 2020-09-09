package com.lamnt.foodorder.view.staff.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lamnt.foodorder.R
import com.lamnt.foodorder.view.staff.fragment.intro.SplashFragment

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.frame_splash_container, SplashFragment())
                .commit()
    }
}