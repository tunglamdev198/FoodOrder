package com.lamnt.foodorder.view.staff.fragment.intro

import android.os.Handler
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentSplashBinding
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragment
import com.lamnt.foodorder.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_splash

    override fun setTitle(): Int = 0

    override fun initViews() {
        viewBinding.imgType.setAnimation(R.raw.delivery_animate)
        Handler().postDelayed({
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