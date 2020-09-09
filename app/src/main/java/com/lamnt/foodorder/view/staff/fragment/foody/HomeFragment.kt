package com.lamnt.foodorder.view.staff.fragment.foody

import android.os.Handler
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.lamnt.foodorder.R
import com.lamnt.foodorder.listener.OnItemClickListener
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragment
import com.lamnt.foodorder.view.adapter.pageradapter.PromotionPagerAdapter
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter2
import com.lamnt.foodorder.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: 4/4/20
class HomeFragment : BaseFragment(), OnItemClickListener<String> {
    private val handler: Handler? = Handler()
    private var runnable: Runnable? = null
    private var mPosition = 0
    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun setTitle(): Int {
        return 0
    }

    override fun setViewOnClick(): List<View> {
        return listOf(btnFood,btnDrink,btnNearby,txtFilter)
    }

    override fun onViewClicked(id: Int) {
        when(id){
            R.id.btnFood -> onBtnFoodClicked()
            R.id.btnNearby -> onBtnNearbyClicked()
            R.id.btnDrink -> onBtnDrinkClicked()
            R.id.txtFilter -> onTxtFilterClicked()
        }
    }

    override fun unit() {
        initRecyclerView()
        initPromotions()
    }

    private fun initRecyclerView() {
        with(rvRecentRestaurant) {
            val llm = LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            this!!.layoutManager = llm
            this.adapter = FoodsAdapter2(activity!!)
        }
        with(rvRestaurant) {
            val adapter = FoodsAdapter(mActivity!!, this@HomeFragment)
            this!!.adapter = adapter
        }

    }

    private fun initPromotions() {
        vpPromotions!!.adapter = PromotionPagerAdapter(mActivity!!)
        val tabLayoutMediator = TabLayoutMediator(
            tabLayout!!,
            vpPromotions!!,
            true,
            TabConfigurationStrategy { tab: TabLayout.Tab?, position: Int -> mPosition = position })
        tabLayoutMediator.attach()
        runnable = Runnable {
            mPosition = if (mPosition >= 4) {
                0
            } else {
                mPosition + 1
            }
            vpPromotions!!.setCurrentItem(mPosition, true)
            handler!!.postDelayed(runnable, 4000)
        }
    }

    override val isShowNotificationIcon: Boolean
        get() = true

    override val isShowSearchIcon: Boolean
        get() = true

    override val isShowBottomNav: Boolean
        get() = true

    fun onBtnFoodClicked() {
    }

    fun onBtnNearbyClicked() {
    }

    fun onBtnDrinkClicked() {
    }

    fun onTxtFilterClicked() {
    }

    override fun onResume() {
        super.onResume()
        handler!!.postDelayed(runnable, 4000)
    }

    override fun onPause() {
        super.onPause()
        handler?.removeCallbacks(runnable)
    }

    override fun onItemClick(`object`: String, position: Int, view: View) {
        val fragment = RestaurantFragment.newInstance(ViewCompat.getTransitionName(view))
        replaceFragment(
            mActivity,
            R.id.container,
            fragment,
            false,
            view,
            "img_transition"
        )
    }

}