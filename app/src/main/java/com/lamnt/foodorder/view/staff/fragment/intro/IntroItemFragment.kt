package com.lamnt.foodorder.view.staff.fragment.intro

import android.os.Bundle
import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.databinding.FragmentIntroBinding
import com.lamnt.foodorder.view.base.BaseFragment
import com.lamnt.foodorder.view.common.ImageHelper.loadImage

class IntroItemFragment : BaseFragment<FragmentIntroBinding>() {
    private val type = 0
    override fun getLayoutRes(): Int = R.layout.fragment_intro


    override fun setTitle(): Int = 0

    private fun initByType(type: Int) {
        when (type) {
            TYPE_ORDER -> {
                viewBinding.imgIntro.visibility = View.VISIBLE
                viewBinding.imgType.visibility = View.GONE
                loadImage(
                        activity,
                    viewBinding.imgIntro,
                        R.drawable.ic_fresh_food)
                viewBinding.txtTitle.text = "Đặt hàng đơn giản"
            }
            TYPE_DELIVERY -> {
                viewBinding.imgIntro.visibility = View.VISIBLE
                viewBinding.imgType.visibility = View.GONE
                loadImage(
                        activity,
                        viewBinding.imgIntro,
                        R.drawable.ic_fast_delivery)
                viewBinding.txtTitle.text = "Vận chuyển nhanh chóng"
            }
            TYPE_PAYMENT -> {
                viewBinding.imgIntro.visibility = View.VISIBLE
                viewBinding.imgType.visibility = View.GONE
                loadImage(
                        activity,
                        viewBinding.imgIntro,
                        R.drawable.ic_fast_payment)
                viewBinding.txtTitle.text = "Thanh toán dễ dàng"
            }
            TYPE_WELCOME -> {
                viewBinding.imgIntro.visibility = View.GONE
                viewBinding.imgType.visibility = View.VISIBLE
                viewBinding.txtTitle.text = "Welcome!"
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

    override fun initViews() {
        var type = 0
        if (arguments != null) {
            type = arguments!!.getInt(Key.SimpleKey.TYPE)
        }
        initByType(type)
    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }
}