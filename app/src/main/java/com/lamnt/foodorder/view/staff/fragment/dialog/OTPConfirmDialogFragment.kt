package com.lamnt.foodorder.view.staff.fragment.dialog

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lamnt.foodorder.R
import com.lamnt.foodorder.common.Key
import com.lamnt.foodorder.utils.ValidateUtil.checkNull
import com.lamnt.foodorder.view.base.BaseDialogFragment
import kotlinx.android.synthetic.main.popup_input_otp.*

class OTPConfirmDialogFragment
private constructor(private val onConfirmOTPDone: OnConfirmOTPDone) : BaseDialogFragment() {
    override fun setViewOnClick(): List<View> {
        return listOf(btnClose, btnResend, btnDone)
    }

    override fun onViewClicked(id: Int) {
       when(id){
           R.id.btnClose -> onBtnCloseClicked()
           R.id.btnResend -> onBtnResendClicked()
           R.id.btnDone -> onBtnDoneClicked()
       }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutRes = R.layout.popup_input_otp
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun unit() {
        val bundle = arguments
        if (!checkNull(bundle)) {
            val phone = bundle!!.getString(Key.SimpleKey.PHONE_NUMBER)
            val phoneDes = getString(R.string.text_otp_confirm_des, phone)
            if (!checkNull(phone)) {
                val phoneHtml = phoneDes.replace(phone!!,
                        "<font color = 'black'><b>$phone</b></font>")
                txtOtpConfirmDes!!.text = Html.fromHtml(phoneHtml)
            }
        }
    }


    private fun onBtnCloseClicked() {
        dismiss()
    }

    private fun onBtnResendClicked() {
    }

    private fun onBtnDoneClicked() {
        onConfirmOTPDone.onDone()
    }

    interface OnConfirmOTPDone {
        fun onDone()
    }

    companion object {
        fun newInstance(phoneNumber: String?,
                        onConfirmOTPDone: OnConfirmOTPDone): OTPConfirmDialogFragment {
            val args = Bundle()
            args.putString(Key.SimpleKey.PHONE_NUMBER, phoneNumber)
            val fragment = OTPConfirmDialogFragment(onConfirmOTPDone)
            fragment.arguments = args
            return fragment
        }
    }

}