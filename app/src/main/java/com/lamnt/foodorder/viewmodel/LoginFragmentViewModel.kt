package com.lamnt.foodorder.viewmodel

import android.content.Context
import com.lamnt.foodorder.listener.OnResponseListener
import io.reactivex.Observable

class LoginFragmentViewModel(context: Context) : BaseViewModel(context) {
    public fun login() {
        val observable = Observable.just("Laam")
    }
}