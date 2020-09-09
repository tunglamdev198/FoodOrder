package com.lamnt.foodorder.view.staff.fragment.intro

import android.content.Intent
import android.view.View
import butterknife.OnClick
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.view.staff.activity.LoginActivity
import com.lamnt.foodorder.view.base.BaseFragment
import com.lamnt.foodorder.view.staff.fragment.intro.IntroItemFragment.Companion.newInstance
import kotlinx.android.synthetic.main.fragment_start_login.*

class StartLoginFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_start_login
    }

    override fun setTitle(): Int {
        return 0
    }

    override fun setViewOnClick(): List<View> {
        return listOf(btnRegister, btnLogin)
    }

    override fun onViewClicked(id: Int) {
        when (id) {
            R.id.btnLogin -> onLoginClicked()
            R.id.btnRegister -> onRegisterClicked()
        }
    }

    override fun unit() {
        btnRegister!!.visibility = View.GONE
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(
                R.id.frame_container,
                newInstance(IntroItemFragment.TYPE_WELCOME)
            )
            ?.commit()
    }

    override val isShowNotificationIcon: Boolean
        get() = false

    override val isShowSearchIcon: Boolean
        get() = false

    override val isShowBottomNav: Boolean
        get() = false

    @OnClick(R.id.btnLogin)
    fun onLoginClicked() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.putExtra(Key.SimpleKey.TYPE, Key.Action.LOGIN)
        startActivity(intent)
        activity?.finish()
    }

    @OnClick(R.id.btnRegister)
    fun onRegisterClicked() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.putExtra(Key.SimpleKey.TYPE, Key.Action.REGISTER)
        startActivity(intent)
        activity?.finish()
    }
}