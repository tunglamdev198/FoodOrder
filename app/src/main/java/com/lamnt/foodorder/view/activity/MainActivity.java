package com.lamnt.foodorder.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.foody.HomeFragment;
import com.lamnt.foodorder.view.fragment.foody.OrderFragment;
import com.lamnt.foodorder.view.fragment.payment.PaymentFragment;
import com.lamnt.foodorder.view.fragment.foody.RestaurantFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static MainActivity instance;
    private TextView txtTitle;
    public ImageView btnSearch;
    public ImageView btnNotification;
    public BottomNavigationView bottomNav;
    public SwipeRefreshLayout refreshLayout;
    public RelativeLayout toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        instance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txtTitle = findViewById(R.id.txt_title);
        btnSearch = findViewById(R.id.btn_search);
        btnNotification = findViewById(R.id.btn_notify);
        bottomNav = findViewById(R.id.bottom_nav);
        refreshLayout = findViewById(R.id.refresh_layout);
        toolBar = findViewById(R.id.tb);
        refreshLayout.setRefreshing(false);
        bottomNav.setOnNavigationItemSelectedListener(this);
        bottomNav.setSelectedItemId(R.id.mnu_home);
        visibleBadge(R.id.mnu_bag);
    }

    @OnClick(R.id.btn_back)
    void onBackClicked(){
        super.onBackPressed();
    }

    public static synchronized MainActivity getInstance() {
        return instance;
    }

    public void setTitleActionBar(String titleActionBar){
        txtTitle.setText(titleActionBar);
    }

    public void loadFragment(Fragment fragment){
        FragmentUtil.replaceFragmentNonBackStack(this, fragment,false);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_home:
                loadFragment(new HomeFragment());
                return true;

            case R.id.mnu_bag:
                loadFragment(new OrderFragment());
                return true;

            case R.id.mnu_account:
                loadFragment(new PaymentFragment());
                return true;
        }
        return false;
    }

    public void visibleBadge(int menuItemId){
        BadgeDrawable badgeDrawable = bottomNav.getOrCreateBadge(menuItemId);
        badgeDrawable.setVisible(true);
        badgeDrawable.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        badgeDrawable.setNumber(8);
    }

    public void goneBadge(int menuItemId){
        BadgeDrawable badgeDrawable = bottomNav.getBadge(menuItemId);
        if (badgeDrawable != null) {
            badgeDrawable.setVisible(false);
        }
    }
}
