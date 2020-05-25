package com.lamnt.foodorder.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_splash;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        new Handler().postDelayed(() ->
                        FragmentUtil.replaceFragment(
                                mActivity,
                                R.id.frame_splash_container,
                                new IntroFragment(),
                                true),
                4000);
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
