package com.lamnt.foodorder.view.fragment.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.fragment.base.BaseDialogFragment;

public class ProcessDialog extends BaseDialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.popup_process;
        setCancelable(false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {

    }
}
