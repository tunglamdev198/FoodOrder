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
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment extends Fragment {
    private  @LayoutRes
    int layoutRes;
    protected Activity mActivity;
//    protected CompositeDisposable mCompositeDisposable;
    private View mView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        layoutRes = getLayoutRes();
        if (mView == null){
            mView = inflater.inflate(layoutRes, container, false);
            ButterKnife.bind(this, mView);
//            mCompositeDisposable = new CompositeDisposable();
            unit(mView);
        }
        return mView;
    }

    public abstract int getLayoutRes();

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

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (mCompositeDisposable.size()>0){
//            mCompositeDisposable.clear();
//        }
    }
}
