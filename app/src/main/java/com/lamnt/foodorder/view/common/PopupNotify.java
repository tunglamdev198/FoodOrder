package com.lamnt.foodorder.view.common;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.common.Key;
import com.lamnt.foodorder.view.fragment.base.BaseDialogFragment;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class PopupNotify extends BaseDialogFragment {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    @BindView(R.id.img_type)
    ImageView imgType;
    @BindView(R.id.txt_message)
    TextView txtMessage;
    @BindView(R.id.btn_action)
    Button btnAction;
    @BindView(R.id.btn_close)
    ImageView btnClose;

    private OnButtonClickListener mOnButtonClickListener;
    private String mMessage;
    private String mButtonAction;

    public static PopupNotify newInstance(String message,
                                          String actionButton,
                                          int type,
                                          OnButtonClickListener onButtonClickListener) {
        Bundle args = new Bundle();
        args.putString(Key.SimpleKey.MESSAGE,message);
        args.putString(Key.SimpleKey.BUTTON_ACTION,actionButton);
        args.putInt(Key.SimpleKey.TYPE,type);
        PopupNotify fragment = new PopupNotify(onButtonClickListener);
        fragment.setArguments(args);
        return fragment;
    }

    private PopupNotify(OnButtonClickListener onButtonClickListener){
        this.mOnButtonClickListener = onButtonClickListener;
    }

    @Override
    public void onStart() {
        super.onStart();
       Objects.requireNonNull(getDialog())
                .getWindow()
                .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.popup_notify;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        if (getArguments() != null) {
            mMessage = getArguments().getString(Key.SimpleKey.MESSAGE);
            mButtonAction = getArguments().getString(Key.SimpleKey.BUTTON_ACTION);
            int type = getArguments().getInt(Key.SimpleKey.TYPE);
            config(type);
        }
    }

    private void config(int type){
        txtMessage.setText(mMessage);
        btnAction.setText(mButtonAction);
        if (type == SUCCESS){
            ImageHelper.loadGifImage(getActivity(), imgType, R.raw.ic_gif_success);
            btnAction.setBackgroundColor(Objects.requireNonNull(
                    mActivity).getResources().getColor(R.color.colorActive));
        }else {
            btnAction.setBackgroundColor(Objects.requireNonNull(
                    mActivity).getResources().getColor(R.color.colorError));
        }
    }

    @OnClick(R.id.btn_action)
    void onBtnActionClicked() {
        if (mOnButtonClickListener != null){
            mOnButtonClickListener.onClicked();
        }
        dismiss();
    }

    @OnClick(R.id.btn_close)
    void onBtnCloseClicked() {
        dismiss();
    }

    public interface OnButtonClickListener{
        void onClicked();
    }
}
