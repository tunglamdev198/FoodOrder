package com.lamnt.foodorder.view.base

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.lamnt.foodorder.R
import com.lamnt.foodorder.view.common.PopupNotify

object CommonDialog {
    @JvmStatic
    fun showErrorMessage(context: Context, message : String) {
        val mFragmentActivity : FragmentActivity = context as FragmentActivity
        val mPopupNotify = PopupNotify.newInstance(
            message,
            mFragmentActivity.getString(R.string.text_confirm),
            PopupNotify.ERROR,null)
        mPopupNotify.show(mFragmentActivity.supportFragmentManager,PopupNotify.javaClass.name)
    }
}