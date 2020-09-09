package com.lamnt.foodorder.view.staff.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.utils.FragmentUtil
import com.lamnt.foodorder.view.staff.fragment.auth.LoginFragment
import com.lamnt.foodorder.view.staff.fragment.auth.RegisterFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        ButterKnife.bind(this)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        initFragments()
    }

    private fun initFragments() {
        val type = intent.getStringExtra(Key.SimpleKey.TYPE)
        if (Key.Action.LOGIN == type) {
            loadFragment(LoginFragment())
        } else {
            loadFragment(RegisterFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        FragmentUtil.replaceFragment(this, R.id.login_container, fragment, true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val fragment = supportFragmentManager.findFragmentById(R.id.login_container)
        fragment?.onActivityResult(requestCode, resultCode, data)
    }
}