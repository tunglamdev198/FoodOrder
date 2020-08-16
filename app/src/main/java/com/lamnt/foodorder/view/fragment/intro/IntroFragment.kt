package com.lamnt.foodorder.view.fragment.intro

import android.view.View
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.lamnt.foodorder.R
import com.lamnt.foodorder.utils.FragmentUtil
import com.lamnt.foodorder.view.activity.MainActivity
import com.lamnt.foodorder.view.adapter.pageradapter.IntroPagerAdapter
import com.lamnt.foodorder.view.adapter.pageradapter.IntroPagerAdapter.OnTabSelected
import com.lamnt.foodorder.view.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro_container.*

class IntroFragment : BaseFragment(), OnTabSelected{
    private var mTabSelected = 0
    override fun getLayoutRes(): Int {
        return R.layout.fragment_intro_container
    }

    override fun setTitle(): Int {
        return 0
    }

    override fun setViewOnClick(): List<View> {
        return listOf(btnSkip, btnNext)
    }

    override fun onViewClicked(id: Int) {
        when(id){
            R.id.btnNext -> onBtnNextClicked()
            R.id.btnSkip -> onBtnSkipClicked()
        }
    }

    override fun unit() {
        initViews()
        if (MainActivity.instance != null) MainActivity.instance?.toolBar?.visibility = View.GONE
    }

    private fun initViews() {
        with(vpIntro){
            val introPagerAdapter = IntroPagerAdapter(activity!!, this@IntroFragment)
            this!!.adapter = introPagerAdapter
            val tabLayoutMediator = TabLayoutMediator(
                tab_layout!!,
                this,
                true,
                TabConfigurationStrategy { tab: TabLayout.Tab?, position: Int -> })
            tabLayoutMediator.attach()
        }

    }

    override val isShowNotificationIcon: Boolean
        get() = false

    override val isShowSearchIcon: Boolean
        get() = false

    override val isShowBottomNav: Boolean
        get() = false


    private fun onBtnNextClicked() {
        if (tab_layout!!.selectedTabPosition != 2) {
            vpIntro!!.currentItem = tab_layout!!.selectedTabPosition + 1
        } else {
            FragmentUtil.replaceFragment(mActivity, R.id.frame_splash_container, StartLoginFragment(), true)
        }
    }

    private fun onBtnSkipClicked() {
        FragmentUtil.replaceFragment(mActivity, R.id.frame_splash_container, StartLoginFragment(), true)
    }

    override fun onItemSelected(position: Int) {
        mTabSelected = position
    }

}