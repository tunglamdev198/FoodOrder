package com.lamnt.foodorder.view.staff.fragment.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.utils.ValidateUtil
import com.lamnt.foodorder.view.base.BaseDialogFragment
import kotlinx.android.synthetic.main.popup_process.*

class ProcessDialog : BaseDialogFragment() {
    override fun setViewOnClick(): List<View> {
        return listOf()
    }

    override fun onViewClicked(id: Int) {
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        layoutRes = R.layout.popup_process
        isCancelable = false
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun unit() {
        val message = arguments?.getString(Key.SimpleKey.PHONE_NUMBER)
        if (!ValidateUtil.checkNull(message)){
            txtMessage!!.text = message
        }else{
            txtMessage!!.text = getString( R.string.text_processing)
        }
    }

    companion object {
        fun newInstance(message: String?): ProcessDialog {
            val args = Bundle()
            args.putString(Key.SimpleKey.PHONE_NUMBER, message)
            val fragment = ProcessDialog()
            fragment.arguments = args
            return fragment
        }
    }
}