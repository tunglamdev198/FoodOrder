package com.lamnt.foodorder.view.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

public class PaymentFragment extends BaseFragment {

    public PaymentFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_payment;
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

    @Override
    public void onResume() {
        super.onResume();
        setTitleActionBar(getString(R.string.text_choose_payment_options));
    }
}
