package com.lamnt.foodorder.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.lamnt.foodorder.view.staff.activity.MainActivity

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {
    companion object {
        const val TAG = "FOOD_ORDER"
    }

    protected lateinit var viewBinding : VB
    private var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mView == null) {
            viewBinding = DataBindingUtil.inflate(inflater,getLayoutRes(),container,false)
            mView = viewBinding.root
            initViews()
            initData()
            initDataBinding()
        }
        return mView
    }
    protected abstract fun getLayoutRes(): Int
    protected abstract fun setTitle(): Int
    protected abstract fun initViews()
    protected abstract fun initDataBinding()
    protected abstract fun initData()

    protected fun setTitleActionBar(title: String?) {
        MainActivity.instance?.setTitleActionBar(title)
    }

    protected fun showIconSearch(){
        if (activity is MainActivity){
            (activity as MainActivity).viewBinding.btnSearch.visibility = View.VISIBLE
        }
    }

    protected fun showIconNotify(){
        if (activity is MainActivity){
            (activity as MainActivity).viewBinding.btnNotify.visibility = View.VISIBLE
        }
    }

    protected fun showBottomNavigation(){
        if (activity is MainActivity){
            (activity as MainActivity).viewBinding.bottomNav.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        if (activity is MainActivity) {
            val instance : MainActivity = activity as MainActivity
            if (setTitle() != 0)
                instance.setTitleActionBar(getString(setTitle()))
        }
    }
}