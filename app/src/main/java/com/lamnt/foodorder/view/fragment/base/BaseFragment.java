package com.lamnt.foodorder.view.fragment.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lamnt.foodorder.view.activity.MainActivity;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    protected @LayoutRes
    int layoutRes;
    protected Activity mActivity;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        View mView = inflater.inflate(layoutRes, container, false);
        ButterKnife.bind(this, mView);
        unit(mView);
        return mView;
    }

    protected abstract void unit(View v);

    protected abstract boolean isShowNotificationIcon();

    protected abstract boolean isShowSearchIcon();

    protected abstract boolean isShowBottomNav();

    protected void setTitleActionBar(String title) {
        MainActivity.getInstance().setTitleActionBar(title);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MainActivity.getInstance() != null) {
            if (isShowNotificationIcon()) {
                MainActivity.getInstance().btnNotification.setVisibility(View.VISIBLE);
            } else {
                MainActivity.getInstance().btnNotification.setVisibility(View.GONE);
            }

            if (isShowSearchIcon()) {
                MainActivity.getInstance().btnSearch.setVisibility(View.VISIBLE);
            } else {
                MainActivity.getInstance().btnSearch.setVisibility(View.GONE);
            }

            if (isShowBottomNav()) {
                MainActivity.getInstance().bottomNav.setVisibility(View.VISIBLE);
            } else {
                MainActivity.getInstance().bottomNav.setVisibility(View.GONE);
            }
        }
    }
}
