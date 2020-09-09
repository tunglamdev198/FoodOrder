package com.lamnt.foodorder.view.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.lamnt.foodorder.view.staff.activity.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseFragment : Fragment(), View.OnClickListener {
    companion object {
        const val TAG = "FOOD_ORDER"
    }

    @LayoutRes
    private var layoutRes = 0
    protected var mActivity: Activity? = null
    private var isViewCreated: Boolean = false
    private var views: List<View> = ArrayList()

    //    protected CompositeDisposable mCompositeDisposable;
    private var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mActivity = activity
        if (mView == null) {
            layoutRes = getLayoutRes()
            mView = inflater.inflate(layoutRes, container, false)
        }
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isViewCreated) {
            unit()
            views = setViewOnClick()
            registerListener(views)
        }
    }

    abstract fun getLayoutRes(): Int
    abstract fun setTitle(): Int
    abstract fun setViewOnClick(): List<View>
    abstract fun onViewClicked(id: Int)
    protected abstract fun unit()
    protected abstract val isShowNotificationIcon: Boolean
    protected abstract val isShowSearchIcon: Boolean
    protected abstract val isShowBottomNav: Boolean
    protected fun setTitleActionBar(title: String?) {
        MainActivity.instance?.setTitleActionBar(title)
    }

    private fun registerListener(views: List<View>) {
        views.forEach { view->view.setOnClickListener(this@BaseFragment)}
    }

    override fun onResume() {
        super.onResume()
        isViewCreated = true
        if (activity is MainActivity) {
            val instance : MainActivity = activity as MainActivity
            if (setTitle() != 0)
                instance.txt_title.setText(setTitle())
            if (isShowNotificationIcon) {
                instance.btnNotification?.visibility = View.VISIBLE
            } else {
                instance.btnNotification?.visibility = View.GONE
            }
            if (isShowSearchIcon) {
                instance.btnSearch?.visibility = View.VISIBLE
            } else {
                instance.btnSearch?.visibility = View.GONE
            }
            if (isShowBottomNav) {
                instance.bottomNav?.visibility = View.VISIBLE
            } else {
                instance.bottomNav?.visibility = View.GONE
            }
        }
    }

    override fun onClick(v: View?) {
        v?.id?.let { onViewClicked(it) }
    }
}