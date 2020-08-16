package com.lamnt.foodorder.view.fragment.foody

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import androidx.transition.TransitionInflater
import butterknife.BindView
import butterknife.OnClick
import com.bumptech.glide.Glide
import com.lamnt.foodorder.R
import com.lamnt.foodorder.listener.OnItemClickListener
import com.lamnt.foodorder.utils.ValidateUtil.checkNull
import com.lamnt.foodorder.view.activity.MainActivity.Companion.instance
import com.lamnt.foodorder.view.adapter.recycleradapter.FoodsAdapter3
import com.lamnt.foodorder.view.fragment.base.BaseFragment
import com.makeramen.roundedimageview.RoundedImageView
import kotlinx.android.synthetic.main.fragment_restaurant.*

/**
 * A simple [Fragment] subclass.
 */
class RestaurantFragment : BaseFragment(), OnRefreshListener, OnItemClickListener<String> {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_restaurant
    }

    override fun setTitle(): Int {
        return R.string.text_location
    }

    override fun setViewOnClick(): List<View> {
        return listOf(ratingBar, btnShare, btnFavorite)
    }

    override fun onViewClicked(id: Int) {
       when(id){
           R.id.ratingBar -> onRatingBarClicked()
           R.id.btnShare -> onBtnShareClicked()
           R.id.btnFavorite -> onBtnFavoriteClicked()
       }
    }

    override fun unit() {
        Glide.with(this).load(R.drawable.demo_royal_tea).into(imgRestaurant!!)
        val llm = GridLayoutManager(activity, 2)
        val adapter = FoodsAdapter3(mActivity!!)
        with(rvFoods) {

            this?.layoutManager = llm
            this?.adapter = adapter
        }
            instance!!.refreshLayout!!.setOnRefreshListener(this)
            var transitionName: String? = null
            if (checkNull(arguments)) {
                transitionName = arguments!!.getString("transitionName")
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.simple_fragment_transition)
            }
    }

    override val isShowNotificationIcon: Boolean
        get() = true

    override val isShowSearchIcon: Boolean
        get() = true

    override val isShowBottomNav: Boolean
        get() = true

    private fun onRatingBarClicked() {
    }

    private fun onBtnShareClicked() {
    }

    private fun onBtnFavoriteClicked() {
    }

    override fun onResume() {
        super.onResume()
        setTitleActionBar(getString(R.string.text_location))
    }

    override fun onRefresh() {
        Handler().postDelayed({ instance!!.refreshLayout!!.isRefreshing = true }, 2000)
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
}