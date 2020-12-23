package com.lamnt.foodorder.view.staff.fragment.payment

import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentPaymentBinding
import com.lamnt.foodorder.view.base.BaseFragmentMVVM
import com.lamnt.foodorder.viewmodel.PaymentFragmentViewModel

class PaymentFragment : BaseFragmentMVVM<PaymentFragmentViewModel,FragmentPaymentBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_payment
    }

    override fun setTitle(): Int {
       return R.string.text_choose_payment_options
    }

    override fun initViewModel() {

    }

    override fun initObserver() {

    }

    override fun initViews() {

    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }

}