package com.lamnt.foodorder.view.fragment.auth

import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.view.fragment.base.BaseFragment

class RegisterFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_register
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

    override fun unit() {}

    override val isShowNotificationIcon: Boolean
        get() = false

    override val isShowSearchIcon: Boolean
        get() = false

    override val isShowBottomNav: Boolean
        get() = false
}