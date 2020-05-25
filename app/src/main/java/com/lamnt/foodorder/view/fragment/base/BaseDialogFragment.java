package com.lamnt.foodorder.view.fragment.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

import butterknife.ButterKnife;

public abstract class BaseDialogFragment extends DialogFragment {
    protected @LayoutRes
    int layoutRes;
    protected Activity mActivity;

    @Override
    public void onStart() {
        super.onStart();
        try {
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(Objects.requireNonNull(this.getDialog().getWindow()).getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.gravity = Gravity.CENTER;
            this.getDialog().setCancelable(false);
            this.getDialog().getWindow().setAttributes(lp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        View mView = inflater.inflate(layoutRes, container, false);
        ButterKnife.bind(this, mView);
        unit(mView);
        return mView;
    }

    protected abstract void unit(View v);
}
