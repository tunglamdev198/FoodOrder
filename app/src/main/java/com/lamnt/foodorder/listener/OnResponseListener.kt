package com.lamnt.foodorder.listener

import com.lamnt.foodorder.model.dto.DataDTO
import io.reactivex.disposables.Disposable

interface OnResponseListener {
    fun returnDisposable(disposable: Disposable?)
    fun returnResult(e: DataDTO?)
    fun returnError(message: String?)
}