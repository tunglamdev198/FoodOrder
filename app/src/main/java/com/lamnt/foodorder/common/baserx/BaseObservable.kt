package com.lamnt.foodorder.common.baserx

import io.reactivex.Observable
import io.reactivex.Observer

class BaseObservable<E> : Observable<E>() {
    override fun subscribeActual(observer: Observer<in E>?) {
        TODO("Not yet implemented")
    }


}