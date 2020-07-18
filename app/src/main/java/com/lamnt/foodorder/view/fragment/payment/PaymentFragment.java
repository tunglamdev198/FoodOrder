package com.lamnt.foodorder.view.fragment.payment;

import android.view.View;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

public class PaymentFragment extends BaseFragment {

    public PaymentFragment() {
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_payment;
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
