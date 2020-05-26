package com.lamnt.foodorder.view.fragment.foody;

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

import com.bumptech.glide.Glide;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.activity.MainActivity;
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter3;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

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
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_restaurant;
       return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        Glide.with(this).load(R.drawable.demo_royal_tea).into(imgRestaurant);
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        rvFoods.setLayoutManager(llm);
        rvFoods.setAdapter(new FoodsAdapter3(getActivity()));
        MainActivity.getInstance().refreshLayout.setOnRefreshListener(this);
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
    public void onRatingBarClicked() {
    }

    @OnClick(R.id.btn_share)
    public void onBtnShareClicked() {
    }

    @OnClick(R.id.btn_favorite)
    public void onBtnFavoriteClicked() {
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
}
