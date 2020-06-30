package com.lamnt.foodorder.view.fragment.foody;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.transition.MaterialContainerTransform;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.listener.OnItemClickListener;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter;
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter2;
import com.lamnt.foodorder.view.adapter.pageradapter.PromotionPagerAdapter;
import com.lamnt.foodorder.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

// TODO: 4/4/20
public class HomeFragment extends BaseFragment implements OnItemClickListener<String> {

    @BindView(R.id.vp_promotions)
    ViewPager2 vpPromotions;
    @BindView(R.id.tab_layout)
    TabLayout tabLayoutPromotions;
    @BindView(R.id.rv_recent_restaurant)
    RecyclerView rvRecentRestaurant;
    @BindView(R.id.txt_result)
    TextView txtResult;
    @BindView(R.id.txt_filter)
    TextView txtFilter;
    @BindView(R.id.rv_restaurant)
    RecyclerView rvRestaurant;

    private Handler handler = new Handler();
    private Runnable runnable;
    private int mPosition;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRes = R.layout.fragment_home;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void unit(View v) {
        initRecyclerView();
        initPromotions();
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false);
        rvRecentRestaurant.setLayoutManager(llm);
        rvRecentRestaurant.setAdapter(new FoodsAdapter2(getActivity()));
        FoodsAdapter adapter = new FoodsAdapter(mActivity,this::onItemClick);
        rvRestaurant.setAdapter(adapter);
    }

    private void initPromotions() {
        vpPromotions.setAdapter(new PromotionPagerAdapter(mActivity));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayoutPromotions,
                vpPromotions,
                true,
                (tab, position) -> {
                    mPosition = position;
                });
        tabLayoutMediator.attach();
        runnable = () -> {
            if( mPosition >= 4){
                mPosition = 0;
            }else{
                mPosition = mPosition +1;
            }
            vpPromotions.setCurrentItem(mPosition, true);
            handler.postDelayed(runnable, 4000);
        };
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

    @OnClick(R.id.btn_food)
    void onBtnFoodClicked() {
    }

    @OnClick(R.id.btn_nearby)
    void onBtnNearbyClicked() {
    }

    @OnClick(R.id.btn_drink)
    void onBtnDrinkClicked() {
    }

    @OnClick(R.id.txt_filter)
    void onTxtFilterClicked() {
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 4000);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (handler!= null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onItemClick(String object, int position, View view) {
        RestaurantFragment fragment = RestaurantFragment.newInstance(ViewCompat.getTransitionName(view));
        FragmentUtil.replaceFragment(
                mActivity,
                R.id.container,
                fragment,
                false,
                view.findViewById(R.id.img_restaurant),
                "img_transition");
    }
}
