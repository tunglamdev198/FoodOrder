package com.lamnt.foodorder.view.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.view.common.ImageHelper.loadGifImage
import com.lamnt.foodorder.view.fragment.base.BaseDialogFragment
import kotlinx.android.synthetic.main.popup_notify.*
import java.util.*

class PopupNotify private constructor(onButtonClickListener: OnButtonClickListener) : BaseDialogFragment() {
    private val mOnButtonClickListener: OnButtonClickListener?
    private var mMessage: String? = null
    private var mButtonAction: String? = null
    override fun setViewOnClick(): List<View> {
        return listOf(btnAction, btnClose)
    }

    override fun onViewClicked(id: Int) {
        when(id){
            R.id.btnAction -> onBtnActionClicked()
            R.id.btnClose -> onBtnCloseClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        layoutRes = R.layout.popup_notify
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun unit() {
        if (arguments != null) {
            mMessage = arguments!!.getString(Key.SimpleKey.MESSAGE)
            mButtonAction = arguments!!.getString(Key.SimpleKey.BUTTON_ACTION)
            val type = arguments!!.getInt(Key.SimpleKey.TYPE)
            config(type)
        }
    }

    private fun config(type: Int) {
        txtMessage!!.text = mMessage
        btnAction!!.text = mButtonAction
        if (type == SUCCESS) {
            loadGifImage(activity, imgType, R.raw.ic_gif_success)
            activity?.resources?.getColor(R.color.colorActive)?.let {
                btnAction!!.setBackgroundColor(
                        it)
            }
        } else {
            activity?.resources?.getColor(R.color.colorError)?.let {
                btnAction!!.setBackgroundColor(
                        it)
            }
        }
    }

    private fun onBtnActionClicked() {
        mOnButtonClickListener?.onClicked()
        dismiss()
    }

    private fun onBtnCloseClicked() {
        dismiss()
    }

    interface OnButtonClickListener {
        fun onClicked()
    }

    companion object {
        const val SUCCESS = 0
        const val ERROR = 1
        @JvmStatic
        fun newInstance(message: String?,
                        actionButton: String?,
                        type: Int,
                        onButtonClickListener: OnButtonClickListener): PopupNotify {
            val args = Bundle()
            args.putString(Key.SimpleKey.MESSAGE, message)
            args.putString(Key.SimpleKey.BUTTON_ACTION, actionButton)
            args.putInt(Key.SimpleKey.TYPE, type)
            val fragment = PopupNotify(onButtonClickListener)
            fragment.arguments = args
            return fragment
        }
    }

    init {
        mOnButtonClickListener = onButtonClickListener
    }
}