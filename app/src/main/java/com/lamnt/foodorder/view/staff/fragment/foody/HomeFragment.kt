package com.lamnt.foodorder.view.staff.fragment.foody

import android.os.Handler
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentHomeBinding
import com.lamnt.foodorder.listener.OnItemClickListener
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragment
import com.lamnt.foodorder.view.adapter.pageradapter.PromotionPagerAdapter
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter2
import com.lamnt.foodorder.view.base.BaseFragment
import com.lamnt.foodorder.view.base.BaseFragmentMVVM
import com.lamnt.foodorder.viewmodel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: 4/4/20
class HomeFragment : BaseFragmentMVVM<HomeFragmentViewModel,FragmentHomeBinding>(),
    OnItemClickListener<String> {
    private val handler: Handler? = Handler()
    private var runnable: Runnable? = null
    private var mPosition = 0

    override fun initViewModel() {

    }

    override fun initObserver() {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun setTitle(): Int = 0

    override fun initViews() {
        initRecyclerView()
        initPromotions()
    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }

    private fun initRecyclerView() {
        with(viewBinding.rvRecentRestaurant) {
            val llm = LinearLayoutManager(
                activity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            this.layoutManager = llm
            this.adapter = FoodsAdapter2(activity!!)
        }
        with(viewBinding.rvRestaurant) {
            val adapter = FoodsAdapter(activity!!, this@HomeFragment)
            this.adapter = adapter
        }

    }

    private fun initPromotions() {
        viewBinding.vpPromotions.adapter = PromotionPagerAdapter(activity!!)
        val tabLayoutMediator = TabLayoutMediator(
            viewBinding.tabLayout,
            viewBinding.vpPromotions,
            true
        ) { _: TabLayout.Tab?, position: Int -> mPosition = position }
        tabLayoutMediator.attach()
        runnable = Runnable {
            mPosition = if (mPosition >= 4) {
                0
            } else {
                mPosition + 1
            }
            viewBinding.vpPromotions.setCurrentItem(mPosition, true)
            handler!!.postDelayed(runnable, 4000)
        }
    }

    override fun onItemClick(`object`: String, position: Int, view: View) {
        val fragment = RestaurantFragment.newInstance(ViewCompat.getTransitionName(view))
        replaceFragment(
            activity,
            R.id.container,
            fragment,
            false,
            view,
            "img_transition"
        )
    }

}