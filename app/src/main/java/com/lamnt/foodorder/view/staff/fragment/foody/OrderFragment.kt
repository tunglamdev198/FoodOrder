package com.lamnt.foodorder.view.staff.fragment.foody

import android.view.View
import com.lamnt.foodorder.R
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragment
import com.lamnt.foodorder.utils.FragmentUtil.showDialogFragment
import com.lamnt.foodorder.view.adapter.recycleradapter.OrdersAdapter
import com.lamnt.foodorder.view.common.PopupNotify
import com.lamnt.foodorder.view.common.PopupNotify.Companion.newInstance
import com.lamnt.foodorder.view.common.PopupNotify.OnButtonClickListener
import com.lamnt.foodorder.view.base.BaseFragment
import com.lamnt.foodorder.view.staff.fragment.payment.PaymentFragment
import kotlinx.android.synthetic.main.fragment_order.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class OrderFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_order
    }

    override fun setTitle(): Int {
        return R.string.text_order
    }

    override fun setViewOnClick(): List<View> {
        return listOf(btnEdit, btnHide, txtDiscountCode, btnPayment)
    }

    override fun onViewClicked(id: Int) {
        when (id) {
            R.id.btnEdit -> onBtnEditClicked()
            R.id.btnHide -> onBtnHideClicked()
            R.id.txtDiscountCode -> onTxtDiscountCodeClicked()
            R.id.btnPayment -> onBtnPaymentClicked()
        }
    }

    override fun unit() {
        val demos: MutableList<String> = ArrayList()
        demos.add("1")
        demos.add("2")
        demos.add("3")
        demos.add("4")
        rvListFood!!.adapter = OrdersAdapter(mActivity!!, demos)
    }

    override val isShowNotificationIcon: Boolean
        get() = false

    override val isShowSearchIcon: Boolean
        get() = false

    override val isShowBottomNav: Boolean
        get() = true

    private fun onBtnEditClicked() {
    }


    private fun onBtnHideClicked() {
        if (lnPaymentExpandable!!.visibility == View.GONE) {
            lnPaymentExpandable!!.visibility = View.VISIBLE
            btnHide!!.setImageResource(R.drawable.ic_arrow_drop_down)
        } else {
            lnPaymentExpandable!!.visibility = View.GONE
            btnHide!!.setImageResource(R.drawable.ic_arrow_drop_up)
        }
    }

    private fun onTxtDiscountCodeClicked() {
        showDialogFragment(
            mActivity,
            newInstance("Đăng kí thông tin khách hàng thành công\n Vui lòng đăng nhập!",
                "Đăng nhập",
                PopupNotify.SUCCESS,
                object : OnButtonClickListener {
                    override fun onClicked() {
                        replaceFragment(mActivity, RestaurantFragment(), true)
                    }
                })
        )
    }

    private fun onBtnPaymentClicked() {
        replaceFragment(mActivity, PaymentFragment(), true)
    }
}