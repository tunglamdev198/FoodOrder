package com.lamnt.foodorder.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.lamnt.foodorder.viewmodel.BaseViewModel

abstract class BaseFragmentMVVM<VM : BaseViewModel, VB : ViewDataBinding> : BaseFragment<VB>() {
    protected lateinit var viewModel : VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        initObserver()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    protected abstract fun initViewModel()

    protected abstract fun initObserver()

}