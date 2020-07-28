package com.lamnt.foodorder.view.fragment.dialog;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chaos.view.PinView;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.common.Key;
import com.lamnt.foodorder.utils.ValidateUtil;
import com.lamnt.foodorder.view.fragment.base.BaseDialogFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class OTPConfirmDialogFragment extends BaseDialogFragment {
    @BindView(R.id.btn_close)
    ImageView btnClose;
    @BindView(R.id.txt_otp_confirm_des)
    TextView txtOtpConfirmDes;
    @BindView(R.id.pv_otp)
    PinView pvOtp;
    @BindView(R.id.btn_resend)
    TextView btnResend;
    @BindView(R.id.btn_done)
    Button btnDone;
    private OnConfirmOTPDone onConfirmOTPDone;

    public static OTPConfirmDialogFragment newInstance(String phoneNumber,
                                                       OnConfirmOTPDone onConfirmOTPDone) {
        Bundle args = new Bundle();
        args.putString(Key.SimpleKey.PHONE_NUMBER, phoneNumber);
        OTPConfirmDialogFragment fragment = new OTPConfirmDialogFragment(onConfirmOTPDone);
        fragment.setArguments(args);
        return fragment;
    }

    private OTPConfirmDialogFragment(OnConfirmOTPDone onConfirmOTPDone) {
        this.onConfirmOTPDone = onConfirmOTPDone;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutRes = R.layout.popup_input_otp;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        Bundle bundle = getArguments();
        if (!ValidateUtil.checkNull(bundle)) {
            String phone = bundle.getString(Key.SimpleKey.PHONE_NUMBER);
            String phoneDes = getString(R.string.text_otp_confirm_des,phone);
            if (!ValidateUtil.checkNull(phone)) {
                String phoneHtml = phoneDes.replace(phone,
                        "<font color = 'black'><b>"+phone+"</b></font>");
                txtOtpConfirmDes.setText(Html.fromHtml(phoneHtml));
            }
        }
    }

    @OnClick(R.id.btn_close)
    public void onBtnCloseClicked() {
        dismiss();
    }

    @OnClick(R.id.btn_resend)
    public void onBtnResendClicked() {
    }

    @OnClick(R.id.btn_done)
    public void onBtnDoneClicked() {
    }

    public interface OnConfirmOTPDone {
        void onDone();
    }
}
