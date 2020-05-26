package com.lamnt.foodorder.view.fragment.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.common.Key;
import com.lamnt.foodorder.view.activity.LoginActivity;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import java.util.Objects;

import butterknife.Action;
import butterknife.BindView;
import butterknife.OnClick;

public class StartLoginFragment extends BaseFragment {

    @BindView(R.id.btn_login)
    TextView btnLogin;
    @BindView(R.id.btn_register)
    TextView btnRegister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_start_login;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        Objects.requireNonNull(getActivity())
                .getSupportFragmentManager()
                .beginTransaction().replace(
                R.id.frame_container,
                IntroItemFragment.newInstance(IntroItemFragment.TYPE_WELCOME))
                .commit();
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

    @OnClick(R.id.btn_login)
    void onLoginClicked() {
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        intent.putExtra(Key.SimpleKey.TYPE,Key.Action.LOGIN);
        startActivity(intent);
        Objects.requireNonNull(getActivity()).finish();
    }

    @OnClick(R.id.btn_register)
    void onRegisterClicked() {
        Intent intent = new Intent(getActivity(),LoginActivity.class);
        intent.putExtra(Key.SimpleKey.TYPE,Key.Action.REGISTER);
        startActivity(intent);
        Objects.requireNonNull(getActivity()).finish();
    }
}
