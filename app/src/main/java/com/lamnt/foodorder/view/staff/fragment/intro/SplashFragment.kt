package com.lamnt.foodorder.view.staff.fragment.intro

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentSplashBinding
import com.lamnt.foodorder.utils.ActivityUtil.replaceFragment
import com.lamnt.foodorder.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_splash

    override fun setTitle(): Int = 0

    @SuppressLint("ResourceType")
    override fun initViews() {
        viewBinding.imgType.setAnimation(R.raw.delivery_animate)
        Handler(Looper.myLooper()!!).postDelayed({
            replaceFragment(
                activity,
                R.id.frame_splash_container,
                IntroFragment(),
                true)
        },
            4000)
    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }
}