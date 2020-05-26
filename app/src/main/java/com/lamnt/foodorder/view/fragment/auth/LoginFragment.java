package com.lamnt.foodorder.view.fragment.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.activity.MainActivity;
import com.lamnt.foodorder.view.common.PopupNotify;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    @BindView(R.id.edt_account)
    EditText edtAccount;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_visible)
    ImageView btnVisible;
    @BindView(R.id.btn_forgot_password)
    TextView btnForgotPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_login_facebook)
    ImageView btnLoginFacebook;
    @BindView(R.id.btn_login_google)
    ImageView btnLoginGoogle;
    @BindView(R.id.txt_register)
    TextView txtRegister;

    private boolean isShowPassword = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_login;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {

    }

    @Override
    protected boolean isShowNotificationIcon() {
        return false;
    }

    @Override
    protected boolean isShowSearchIcon() {
        return false;
    }

    @Override
    protected boolean isShowBottomNav() {
        return false;
    }

    @OnClick(R.id.btn_visible)
    void onBtnVisibleClicked() {
        if (isShowPassword) {
            btnVisible.setImageResource(R.drawable.ic_show_password);
            edtPassword.setSelection(edtPassword.getText().toString().length());
            edtPassword.setTransformationMethod(new PasswordTransformationMethod());
            isShowPassword = false;
        } else {
            btnVisible.setImageResource(R.drawable.ic_hide_password);
            edtPassword.setTransformationMethod(null);
            edtPassword.setSelection(edtPassword.getText().toString().length());
            isShowPassword = true;
        }
    }

    @OnClick(R.id.btn_forgot_password)
    void onBtnForgotPasswordClicked() {
    }

    @OnClick(R.id.btn_login)
    void onBtnLoginClicked() {
        FragmentUtil.showDialogFragment(getActivity(),
                PopupNotify.newInstance("Đăng kí thông tin khách hàng thành công\n Vui lòng đăng nhập!",
                        "Đăng nhập",
                        PopupNotify.SUCCESS,
                        () -> {
                            startActivity(new Intent(getActivity(), MainActivity.class));
                        }));
    }

    @OnClick(R.id.btn_login_facebook)
    void onBtnLoginFacebookClicked() {
    }

    @OnClick(R.id.txt_register)
    void onTxtRegisterClicked() {
    }
}
