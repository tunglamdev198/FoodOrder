package com.lamnt.foodorder.view.staff.fragment.intro

import android.content.Intent
import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.databinding.FragmentStartLoginBinding
import com.lamnt.foodorder.view.base.BaseFragment
import com.lamnt.foodorder.view.staff.activity.LoginActivity
import com.lamnt.foodorder.view.staff.fragment.intro.IntroItemFragment.Companion.newInstance
import kotlinx.android.synthetic.main.fragment_start_login.*

class StartLoginFragment : BaseFragment<FragmentStartLoginBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_start_login

    override fun setTitle(): Int = 0


    fun onLoginClicked() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.putExtra(Key.SimpleKey.TYPE, Key.Action.LOGIN)
        startActivity(intent)
        activity?.finish()
    }

    fun onRegisterClicked() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.putExtra(Key.SimpleKey.TYPE, Key.Action.REGISTER)
        startActivity(intent)
        activity?.finish()
    }

    override fun initViews() {
        viewBinding.btnRegister.visibility = View.GONE
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(
                R.id.frame_container,
                newInstance(IntroItemFragment.TYPE_WELCOME)
            )
            ?.commit()
    }

    override fun initDataBinding() {
        viewBinding.fragment = this
    }

    override fun initData() {

    }
}