package com.lamnt.foodorder.view.fragment.foody;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.adapter.recycleradapter.OrdersAdapter;
import com.lamnt.foodorder.view.common.PopupNotify;
import com.lamnt.foodorder.view.fragment.payment.PaymentFragment;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment {

    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.btn_edit)
    ImageView btnEdit;
    @BindView(R.id.rv_list_food)
    RecyclerView rvListFood;
    @BindView(R.id.txt_order_value)
    TextView txtOrderValue;
    @BindView(R.id.rl_order_value)
    RelativeLayout rlOrderValue;
    @BindView(R.id.txt_delivery_value)
    TextView txtDeliveryValue;
    @BindView(R.id.rl_delivery_value)
    RelativeLayout rlDeliveryValue;
    @BindView(R.id.txt_discount)
    TextView txtDiscount;
    @BindView(R.id.rl_discount)
    RelativeLayout rlDiscount;
    @BindView(R.id.txt_discount_code)
    TextView txtDiscountCode;
    @BindView(R.id.btn_payment)
    TextView btnPayment;
    @BindView(R.id.ln_payment)
    LinearLayout lnPayment;
    @BindView(R.id.ln_payment_expandable)
    LinearLayout lnPaymentExpandable;
    @BindView(R.id.btn_hide)
    ImageView btnExpand;

    public OrderFragment() {
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_order;
    }

    @Override
    protected void unit(View v) {
        List<String> demos = new ArrayList<>();
        demos.add("1");
        demos.add("2");
        demos.add("3");
        demos.add("4");
        rvListFood.setAdapter(new OrdersAdapter(mActivity, demos));
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
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitleActionBar(getString(R.string.text_order));
    }

    @OnClick(R.id.btn_edit)
    void onBtnEditClicked() {
    }

    @OnClick(R.id.btn_hide)
    void onBtnHideClicked() {
        if (lnPaymentExpandable.getVisibility() == View.GONE) {
            lnPaymentExpandable.setVisibility(View.VISIBLE);
            btnExpand.setImageResource(R.drawable.ic_arrow_drop_down);
        } else {
            lnPaymentExpandable.setVisibility(View.GONE);
            btnExpand.setImageResource(R.drawable.ic_arrow_drop_up);
        }
    }

    @OnClick(R.id.txt_discount_code)
    public void onTxtDiscountCodeClicked() {
        FragmentUtil.showDialogFragment(mActivity,
                PopupNotify.newInstance("Đăng kí thông tin khách hàng thành công\n Vui lòng đăng nhập!",
                        "Đăng nhập",
                        PopupNotify.SUCCESS,
                        () -> {
                            FragmentUtil.replaceFragment(mActivity, new RestaurantFragment(),true);
                        }));
    }

    @OnClick(R.id.btn_payment)
    public void onBtnPaymentClicked() {
        FragmentUtil.replaceFragment(mActivity, new PaymentFragment(),true);
    }

}
