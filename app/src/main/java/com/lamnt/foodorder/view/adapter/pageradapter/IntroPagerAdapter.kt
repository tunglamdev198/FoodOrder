package com.lamnt.foodorder.view.adapter.pageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lamnt.foodorder.view.fragment.intro.IntroItemFragment

class IntroPagerAdapter(fragmentActivity: FragmentActivity,
                        private val onTabSelected: OnTabSelected) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        onTabSelected.onItemSelected(position)
        return when (position) {
            0 -> {
                IntroItemFragment.newInstance(IntroItemFragment.TYPE_ORDER)
            }
            1 -> {
                IntroItemFragment.newInstance(IntroItemFragment.TYPE_DELIVERY)
            }
            else -> {
                IntroItemFragment.newInstance(IntroItemFragment.TYPE_PAYMENT)
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    interface OnTabSelected {
        fun onItemSelected(position: Int)
    }

}