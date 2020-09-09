package com.lamnt.foodorder.listener

import io.reactivex.disposables.Disposable

interface OnActionSuccessListener {
    fun returnDisposable(disposable: Disposable?)
    fun isSucceed(isSucceed: Boolean)
    fun handleMessage(message: String?)
}