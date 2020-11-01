package com.lamnt.foodorder.listener

import com.lamnt.foodorder.model.dto.DataDTO
import com.lamnt.foodorder.model.dto.ResponseDTO
import io.reactivex.disposables.Disposable

interface OnResponseListener<E : ResponseDTO> {
    fun returnDisposable(disposable: Disposable?)
    fun returnResult(e: E)
    fun returnError(message: String?)
}