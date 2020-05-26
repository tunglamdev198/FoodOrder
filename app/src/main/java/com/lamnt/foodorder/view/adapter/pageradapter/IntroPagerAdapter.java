package com.lamnt.foodorder.view.adapter.pageradapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lamnt.foodorder.view.fragment.intro.IntroItemFragment;

public class IntroPagerAdapter extends FragmentStateAdapter {
    private OnTabSelected onTabSelected;

    public IntroPagerAdapter(@NonNull FragmentActivity fragmentActivity,
                             OnTabSelected onTabSelected) {
        super(fragmentActivity);
        this.onTabSelected = onTabSelected;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        onTabSelected.onItemSelected(position);
        if (position == 0) {
            return IntroItemFragment.newInstance(IntroItemFragment.TYPE_ORDER);
        } else if (position == 1) {
            return IntroItemFragment.newInstance(IntroItemFragment.TYPE_DELIVERY);
        } else {
            return IntroItemFragment.newInstance(IntroItemFragment.TYPE_PAYMENT);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public interface OnTabSelected{
        void onItemSelected(int position);
    }
}
