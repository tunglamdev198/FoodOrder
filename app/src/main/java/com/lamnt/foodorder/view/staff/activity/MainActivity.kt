package com.lamnt.foodorder.view.staff.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.ActivityMainBinding
import com.lamnt.foodorder.utils.ActivityUtil.replaceFragmentNonBackStack
import com.lamnt.foodorder.view.base.BaseActivity
import com.lamnt.foodorder.view.staff.fragment.foody.HomeFragment
import com.lamnt.foodorder.view.staff.fragment.foody.OrderFragment
import com.lamnt.foodorder.view.staff.fragment.payment.PaymentFragment

class MainActivity : BaseActivity<ActivityMainBinding>(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        instance = this
        super.onCreate(savedInstanceState)
        with(viewBinding.bottomNav) {
            this.setOnNavigationItemSelectedListener(this@MainActivity)
            this.selectedItemId = R.id.mnu_home
        }
        visibleBadge(R.id.mnu_bag)
    }
    fun setTitleActionBar(titleActionBar: String?) {
        viewBinding.txtTitle.text = titleActionBar
    }

    private fun loadFragment(fragment: Fragment?) {
        replaceFragmentNonBackStack(this, fragment!!, false)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnu_home -> {
                loadFragment(HomeFragment())
                return true
            }
            R.id.mnu_bag -> {
                loadFragment(OrderFragment())
                return true
            }
            R.id.mnu_account -> {
                loadFragment(PaymentFragment())
                return true
            }
        }
        return false
    }

    private fun visibleBadge(menuItemId : Int) {
        val badgeDrawable = viewBinding.bottomNav.getOrCreateBadge(menuItemId)
        badgeDrawable.isVisible = true
        badgeDrawable.backgroundColor = resources.getColor(android.R.color.holo_red_light)
        badgeDrawable.number = 8
    }

    fun goneBadge(menuItemId: Int) {
        val badgeDrawable = viewBinding.bottomNav.getBadge(menuItemId)
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = false
        }
    }

    companion object {
        @JvmStatic
        @get:Synchronized
        var instance: MainActivity? = null
            private set
    }

    override fun setLayoutId(): Int = R.layout.activity_main

    override fun initViewModel() {

    }

    override fun initView() {

    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }

    override fun initObserver() {

    }
}