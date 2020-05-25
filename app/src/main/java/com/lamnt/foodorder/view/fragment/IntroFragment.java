package com.lamnt.foodorder.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.activity.MainActivity;
import com.lamnt.foodorder.view.adapter.IntroPagerAdapter;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class IntroFragment extends BaseFragment implements IntroPagerAdapter.OnTabSelected {

    @BindView(R.id.vp_intro)
    ViewPager2 vpIntro;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.btn_next)
    TextView btnNext;
    @BindView(R.id.btn_skip)
    TextView btnSkip;
    private int mTabSelected = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_intro_container;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        initViews();
        if (MainActivity.getInstance() != null)
        MainActivity.getInstance().toolBar.setVisibility(View.GONE);
    }

    private void initViews() {
        IntroPagerAdapter introPagerAdapter = new IntroPagerAdapter(Objects.requireNonNull(getActivity()), this);
        vpIntro.setAdapter(introPagerAdapter);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout,
                vpIntro,
                true,
                (tab, position) -> {

        });
        tabLayoutMediator.attach();
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

    @OnClick(R.id.btn_next)
    void onBtnNextClicked() {
        if (tabLayout.getSelectedTabPosition() != 2) {
            vpIntro.setCurrentItem(tabLayout.getSelectedTabPosition() + 1);
        } else {
            FragmentUtil.replaceFragment(mActivity,R.id.frame_splash_container, new StartLoginFragment(), true);
        }
    }

    @OnClick(R.id.btn_skip)
    void onBtnSkipClicked() {
        FragmentUtil.replaceFragment(mActivity,R.id.frame_splash_container , new StartLoginFragment(), true);
    }

    @Override
    public void onItemSelected(int position) {
        mTabSelected = position;
    }
}
