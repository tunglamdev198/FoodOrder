package com.lamnt.foodorder.view.fragment.foody;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.transition.TransitionInflater;

import com.bumptech.glide.Glide;
import com.google.android.material.transition.MaterialContainerTransform;
import com.lamnt.foodorder.Demo;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.listener.OnItemClickListener;
import com.lamnt.foodorder.utils.ValidateUtil;
import com.lamnt.foodorder.view.activity.MainActivity;
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter;
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter3;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener, OnItemClickListener<String> {

    @BindView(R.id.img_restaurant)
    RoundedImageView imgRestaurant;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_category)
    TextView txtCategory;
    @BindView(R.id.txt_location)
    TextView txtLocation;
    @BindView(R.id.txt_description)
    TextView txtDescription;
    @BindView(R.id.txt_rating)
    TextView txtRating;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.btn_share)
    ImageButton btnShare;
    @BindView(R.id.btn_favorite)
    ImageButton btnFavorite;
    @BindView(R.id.txt_state)
    TextView txtState;
    @BindView(R.id.rv_foods)
    RecyclerView rvFoods;

    public RestaurantFragment() {

    }

    public static RestaurantFragment newInstance(String transitionName) {

        Bundle args = new Bundle();
        args.putString("transitionName",transitionName);
        RestaurantFragment fragment = new RestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_restaurant;
    }

    @Override
    protected void unit(View v) {
        Glide.with(this).load(R.drawable.demo_royal_tea).into(imgRestaurant);
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        rvFoods.setLayoutManager(llm);
        FoodsAdapter3 adapter = new FoodsAdapter3(getActivity());
        rvFoods.setAdapter(adapter);
        MainActivity.getInstance().refreshLayout.setOnRefreshListener(this);
        String transitionName = null;
        if (ValidateUtil.checkNull(getArguments())) {
            transitionName = getArguments().getString("transitionName");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(
                    TransitionInflater.from(getContext()).inflateTransition(R.transition.simple_fragment_transition));
        }
    }

    @Override
    protected boolean isShowNotificationIcon() {
        return true;
    }

    @Override
    protected boolean isShowSearchIcon() {
        return true;
    }

    @Override
    protected boolean isShowBottomNav() {
        return true;
    }

    @OnClick(R.id.rating_bar)
    void onRatingBarClicked() {
    }

    @OnClick(R.id.btn_share)
    void onBtnShareClicked() {
    }

    @OnClick(R.id.btn_favorite)
    void onBtnFavoriteClicked() {
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitleActionBar(getString(R.string.text_location));
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() ->
                MainActivity.getInstance().refreshLayout.setRefreshing(true), 2000);
    }

    @Override
    public void onItemClick(String object, int position, View view) {

    }
}
