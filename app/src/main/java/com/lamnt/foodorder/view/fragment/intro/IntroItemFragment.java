package com.lamnt.foodorder.view.fragment.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.common.Key;
import com.lamnt.foodorder.view.common.ImageHelper;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import butterknife.BindView;

public class IntroItemFragment extends BaseFragment {
    public static final int TYPE_ORDER = 0;
    public static final int TYPE_DELIVERY = 1;
    public static final int TYPE_PAYMENT = 2;
    public static final int TYPE_WELCOME = 3;
    @BindView(R.id.img_intro)
    ImageView imgIntro;
    @BindView(R.id.img_type)
    LottieAnimationView imgType;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_description)
    TextView txtDescription;
    private int type;

    public static IntroItemFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(Key.SimpleKey.TYPE, type);
        IntroItemFragment fragment = new IntroItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_intro;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        int type = 0;
        if (getArguments() != null) {
            type = getArguments().getInt(Key.SimpleKey.TYPE);
        }
        initViews(type);
    }

    private void initViews(int type){
        switch (type){
            case TYPE_ORDER:
                imgIntro.setVisibility(View.VISIBLE);
                imgType.setVisibility(View.GONE);
                ImageHelper.loadImage(
                        mActivity,
                        imgIntro,
                        R.drawable.ic_fresh_food);
                txtTitle.setText("Đặt hàng đơn giản");
                break;

            case TYPE_DELIVERY:
                imgIntro.setVisibility(View.VISIBLE);
                imgType.setVisibility(View.GONE);
                ImageHelper.loadImage(
                        mActivity,
                        imgIntro,
                        R.drawable.ic_fast_delivery);
                txtTitle.setText("Vận chuyển nhanh chóng");
                break;

            case TYPE_PAYMENT:
                imgIntro.setVisibility(View.VISIBLE);
                imgType.setVisibility(View.GONE);
                ImageHelper.loadImage(
                        mActivity,
                        imgIntro,
                        R.drawable.ic_fast_payment);
                txtTitle.setText("Thanh toán dễ dàng");
                break;

                case TYPE_WELCOME:
                imgIntro.setVisibility(View.GONE);
                imgType.setVisibility(View.VISIBLE);
                txtTitle.setText("Welcome!");
                break;

            default:
                break;
        }
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
