package com.lamnt.foodorder.view.fragment.intro;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.common.ImageHelper;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends BaseFragment {
    @BindView(R.id.img_type)
    LottieAnimationView imgType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_splash;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        imgType.setAnimation(R.raw.delivery_animate);
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
