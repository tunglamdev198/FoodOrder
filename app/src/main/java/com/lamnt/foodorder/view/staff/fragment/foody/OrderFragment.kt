package com.lamnt.foodorder.view.staff.fragment.foody

import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentOrderBinding
import com.lamnt.foodorder.utils.ActivityUtil.replaceFragment
import com.lamnt.foodorder.utils.ActivityUtil.showDialogFragment
import com.lamnt.foodorder.view.adapter.recycleradapter.OrdersAdapter
import com.lamnt.foodorder.view.base.BaseFragmentMVVM
import com.lamnt.foodorder.view.common.PopupNotify
import com.lamnt.foodorder.view.common.PopupNotify.Companion.newInstance
import com.lamnt.foodorder.view.common.PopupNotify.OnButtonClickListener
import com.lamnt.foodorder.view.staff.fragment.payment.PaymentFragment
import com.lamnt.foodorder.viewmodel.OrderFragmentViewModel
import kotlinx.android.synthetic.main.fragment_order.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class OrderFragment : BaseFragmentMVVM<OrderFragmentViewModel,FragmentOrderBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_order

    override fun setTitle(): Int = R.string.text_order

    fun onBtnEditClicked() {
    }


    fun onBtnHideClicked() {
        if (viewBinding.lnPaymentExpandable.visibility == View.GONE) {
            viewBinding.lnPaymentExpandable.visibility = View.VISIBLE
            viewBinding.btnHide.setImageResource(R.drawable.ic_arrow_drop_down)
        } else {
            viewBinding.lnPaymentExpandable.visibility = View.GONE
            viewBinding.btnHide.setImageResource(R.drawable.ic_arrow_drop_up)
        }
    }

    fun onTxtDiscountCodeClicked() {
        showDialogFragment(
            activity,
            newInstance("Đăng kí thông tin khách hàng thành công\n Vui lòng đăng nhập!",
                "Đăng nhập",
                PopupNotify.SUCCESS,
                object : OnButtonClickListener {
                    override fun onClicked() {
                        replaceFragment(activity, RestaurantFragment(), true)
                    }
                })
        )
    }

    fun onBtnPaymentClicked() {
        replaceFragment(activity, PaymentFragment(), true)
    }

    override fun initViewModel() {

    }

    override fun initObserver() {

    }

    override fun initViews() {
        val demos: MutableList<String> = ArrayList()
        demos.add("1")
        demos.add("2")
        demos.add("3")
        demos.add("4")
        viewBinding.rvListFood.adapter = OrdersAdapter(activity!!, demos)
    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }
}