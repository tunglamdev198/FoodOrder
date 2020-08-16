package com.lamnt.foodorder.view.fragment.intro

import android.os.Handler
import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragment
import com.lamnt.foodorder.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_splash.*

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_splash
    }

    override fun setTitle(): Int {
        return 0
    }

    override fun setViewOnClick(): List<View> {
        return listOf()
    }

    override fun onViewClicked(id: Int) {
        TODO("Not yet implemented")
    }

    override fun unit() {
        imgType!!.setAnimation(R.raw.delivery_animate)
        Handler().postDelayed({
            replaceFragment(
                    activity,
                    R.id.frame_splash_container,
                    IntroFragment(),
                    true)
        },
                4000)
    }

    override val isShowNotificationIcon: Boolean
        get() = false

    override val isShowSearchIcon: Boolean
        get() = false

    override val isShowBottomNav: Boolean
        get() = false
}