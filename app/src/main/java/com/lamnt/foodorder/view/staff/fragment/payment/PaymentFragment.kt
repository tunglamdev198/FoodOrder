package com.lamnt.foodorder.view.staff.fragment.payment

import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.view.base.BaseFragment

class PaymentFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_payment
    }

    override fun setTitle(): Int {
       return R.string.text_choose_payment_options
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