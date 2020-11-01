package com.lamnt.foodorder.view.staff.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lamnt.foodorder.R
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragmentNonBackStack
import com.lamnt.foodorder.view.staff.fragment.foody.HomeFragment
import com.lamnt.foodorder.view.staff.fragment.foody.OrderFragment
import com.lamnt.foodorder.view.staff.fragment.payment.PaymentFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var txtTitle: TextView? = null
    var btnSearch: ImageView? = null
    var btnNotification: ImageView? = null
    var bottomNav: BottomNavigationView? = null
    var refreshLayout: SwipeRefreshLayout? = null
    var toolBar: RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        instance = this
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        txtTitle = findViewById(R.id.txt_title)
        btnSearch = findViewById(R.id.btn_search)
        btnNotification = findViewById(R.id.btn_notify)
        bottomNav = findViewById(R.id.bottom_nav)
        refreshLayout = findViewById(R.id.refresh_layout)
        toolBar = findViewById(R.id.tb)
        refreshLayout.run { this?.setRefreshing(false) }
        with(bottomNav) {
            this?.setOnNavigationItemSelectedListener(this@MainActivity)
            this?.setSelectedItemId(R.id.mnu_home) }
        visibleBadge(R.id.mnu_bag)
    }

    @OnClick(R.id.btn_back)
    fun onBackClicked() {
        super.onBackPressed()
    }

    fun setTitleActionBar(titleActionBar: String?) {
        txtTitle!!.text = titleActionBar
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
        val badgeDrawable = bottomNav!!.getOrCreateBadge(menuItemId)
        badgeDrawable.isVisible = true
        badgeDrawable.backgroundColor = resources.getColor(android.R.color.holo_red_light)
        badgeDrawable.number = 8
    }

    fun goneBadge(menuItemId: Int) {
        val badgeDrawable = bottomNav!!.getBadge(menuItemId)
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
}