package com.lamnt.foodorder.view.staff.fragment.foody

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentRestaurantBinding
import com.lamnt.foodorder.listener.OnItemClickListener
import com.lamnt.foodorder.utils.ValidateUtil.checkNull
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter3
import com.lamnt.foodorder.view.base.BaseFragmentMVVM
import com.lamnt.foodorder.viewmodel.RestaurantFragmentViewModel
import kotlinx.android.synthetic.main.fragment_restaurant.*

/**
 * A simple [Fragment] subclass.
 */
class RestaurantFragment : BaseFragmentMVVM<RestaurantFragmentViewModel,FragmentRestaurantBinding>(),
    OnRefreshListener, OnItemClickListener<String> {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_restaurant
    }

    override fun setTitle(): Int {
        return R.string.text_location
    }

    private fun onRatingBarClicked() {
    }

    private fun onBtnShareClicked() {
    }

    private fun onBtnFavoriteClicked() {
    }


    override fun onItemClick(`object`: String, position: Int, view: View) {}

    companion object {
        fun newInstance(transitionName: String?): RestaurantFragment {
            val args = Bundle()
            args.putString("transitionName", transitionName)
            val fragment = RestaurantFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initViewModel() {

    }

    override fun initObserver() {

    }

    override fun initViews() {
        Glide.with(this).load(R.drawable.demo_royal_tea).into(imgRestaurant!!)
        val llm = GridLayoutManager(activity, 2)
        val adapter = FoodsAdapter3(activity!!)
        with(viewBinding.rvFoods) {

            this.layoutManager = llm
            this.adapter = adapter
        }
        var transitionName: String? = null
        if (checkNull(arguments)) {
            transitionName = arguments!!.getString("transitionName")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.simple_fragment_transition)
        }
    }

    override fun initDataBinding() {

    }

    override fun initData() {

    }

    override fun onRefresh() {

    }
}