package com.lamnt.foodorder.view.fragment.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;
import com.lamnt.foodorder.view.fragment.dialog.OTPConfirmDialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private List<String> demos = new ArrayList<>();
    private CallbackManager mCallbackManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_login;
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

    private void fbLogin() {
        mCallbackManager = CallbackManager.Factory.create();

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"));

        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        System.out.println("Success");
                        GraphRequest.newMeRequest(
                                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject json, GraphResponse response) {
                                        if (response.getError() != null) {
                                            // handle error
                                            System.out.println("ERROR");
                                        } else {
                                            System.out.println("Success");
                                            try {

                                                String jsonresult = String.valueOf(json);
                                                System.out.println("JSON Result" + jsonresult);

                                                String str_email = json.getString("email");
                                                String str_id = json.getString("id");
                                                String str_firstname = json.getString("first_name");
                                                String str_lastname = json.getString("last_name");
                                                Toast.makeText(mActivity, "email : " + str_email + " , name : " + str_firstname + " " + str_lastname, Toast.LENGTH_SHORT).show();

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }

                                }).executeAsync();

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
    }

    @OnClick(R.id.btn_login)
    void onBtnLoginClicked() {
        FragmentUtil.showDialogFragment(getActivity(),
                OTPConfirmDialogFragment.newInstance("0337539494",
                        () -> {

                        }));
    }

    @OnClick(R.id.btn_login_facebook)
    void onBtnLoginFacebookClicked() {
        fbLogin();
    }

    @OnClick(R.id.txt_register)
    void onTxtRegisterClicked() {
        FragmentUtil.replaceFragment(mActivity,
                R.id.login_container,
                new RegisterFragment(),
                true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
