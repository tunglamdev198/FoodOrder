package com.lamnt.foodorder.view.fragment.auth;

import android.view.View;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

public class RegisterFragment extends BaseFragment {
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_register;
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
