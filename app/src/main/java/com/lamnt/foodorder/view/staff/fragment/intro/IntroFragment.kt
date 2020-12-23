package com.lamnt.foodorder.view.staff.fragment.intro

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentIntroContainerBinding
import com.lamnt.foodorder.utils.FragmentUtil
import com.lamnt.foodorder.view.adapter.pageradapter.IntroPagerAdapter
import com.lamnt.foodorder.view.adapter.pageradapter.IntroPagerAdapter.OnTabSelected
import com.lamnt.foodorder.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro_container.*

class IntroFragment : BaseFragment<FragmentIntroContainerBinding>(), OnTabSelected{
    private var mTabSelected = 0
    override fun getLayoutRes(): Int = R.layout.fragment_intro_container


    override fun setTitle(): Int =0


    fun onBtnNextClicked() {
        if (viewBinding.tabLayout.selectedTabPosition != 2) {
            viewBinding.vpIntro.currentItem = tab_layout!!.selectedTabPosition + 1
        } else {
            FragmentUtil.replaceFragment(activity, R.id.frame_splash_container, StartLoginFragment(), true)
        }
    }

    fun onBtnSkipClicked() {
        FragmentUtil.replaceFragment(activity, R.id.frame_splash_container, StartLoginFragment(), true)
    }

    override fun onItemSelected(position: Int) {
        mTabSelected = position
    }

    override fun initDataBinding() {
        viewBinding.fragment = this
    }

    override fun initData() {

    }

    override fun initViews() {
        with(viewBinding.vpIntro){
            val introPagerAdapter = IntroPagerAdapter(activity!!, this@IntroFragment)
            this.adapter = introPagerAdapter
            val tabLayoutMediator = TabLayoutMediator(
                viewBinding.tabLayout,
                this,
                true,
                TabConfigurationStrategy { _: TabLayout.Tab?, _: Int -> })
            tabLayoutMediator.attach()
        }
    }

}