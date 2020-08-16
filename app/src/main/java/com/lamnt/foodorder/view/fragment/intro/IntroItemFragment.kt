package com.lamnt.foodorder.view.fragment.intro

import android.os.Bundle
import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.view.common.ImageHelper.loadImage
import com.lamnt.foodorder.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroItemFragment : BaseFragment() {
    private val type = 0
    override fun getLayoutRes(): Int {
        return R.layout.fragment_intro
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
        var type = 0
        if (arguments != null) {
            type = arguments!!.getInt(Key.SimpleKey.TYPE)
        }
        initViews(type)
    }

    override val isShowNotificationIcon: Boolean
        get() = false
    override val isShowSearchIcon: Boolean
        get() = false
    override val isShowBottomNav: Boolean
        get() = false

    private fun initViews(type: Int) {
        when (type) {
            TYPE_ORDER -> {
                img_intro!!.visibility = View.VISIBLE
                img_type!!.visibility = View.GONE
                loadImage(
                        mActivity,
                    img_intro,
                        R.drawable.ic_fresh_food)
                txt_title!!.text = "Đặt hàng đơn giản"
            }
            TYPE_DELIVERY -> {
                img_intro!!.visibility = View.VISIBLE
                img_type!!.visibility = View.GONE
                loadImage(
                        mActivity,
                        img_intro,
                        R.drawable.ic_fast_delivery)
                txt_title!!.text = "Vận chuyển nhanh chóng"
            }
            TYPE_PAYMENT -> {
                img_intro!!.visibility = View.VISIBLE
                img_type!!.visibility = View.GONE
                loadImage(
                        mActivity,
                        img_intro,
                        R.drawable.ic_fast_payment)
                txt_title!!.text = "Thanh toán dễ dàng"
            }
            TYPE_WELCOME -> {
                img_intro!!.visibility = View.GONE
                img_type!!.visibility = View.VISIBLE
                txt_title!!.text = "Welcome!"
            }
            else -> {
            }
        }
    }



    companion object {
        const val TYPE_ORDER = 0
        const val TYPE_DELIVERY = 1
        const val TYPE_PAYMENT = 2
        const val TYPE_WELCOME = 3
        @JvmStatic
        fun newInstance(type: Int): IntroItemFragment {
            val args = Bundle()
            args.putInt(Key.SimpleKey.TYPE, type)
            val fragment = IntroItemFragment()
            fragment.arguments = args
            return fragment
        }
    }
}