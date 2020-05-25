package com.lamnt.foodorder.view.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.activity.MainActivity;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import java.util.Objects;

public class LoginFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_login;
        MainActivity.getInstance().toolBar.setVisibility(View.GONE);
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
}
