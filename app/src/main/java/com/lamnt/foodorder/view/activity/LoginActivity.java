package com.lamnt.foodorder.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.common.PopupNotify;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_account)
    EditText edtAccount;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_visible)
    TextView btnVisible;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @OnClick(R.id.btn_visible)
    public void onBtnVisibleClicked() {

    }

    @OnClick(R.id.btn_forgot_password)
    public void onBtnForgotPasswordClicked() {

    }

    @OnClick(R.id.btn_login)
    public void onBtnLoginClicked() {
        FragmentUtil.showDialogFragment(this,
                PopupNotify.newInstance("Đăng kí thông tin khách hàng thành công\n Vui lòng đăng nhập!",
                        "Đăng nhập",
                        PopupNotify.SUCCESS,
                        () -> {
                            startActivity(new Intent(this,MainActivity.class));
                        }));
    }

    @OnClick(R.id.btn_login_facebook)
    public void onBtnLoginFacebookClicked() {

    }

    @OnClick(R.id.btn_login_google)
    public void onBtnLoginGoogleClicked() {

    }

    @OnClick(R.id.txt_register)
    public void onTxtRegisterClicked() {

    }
}
