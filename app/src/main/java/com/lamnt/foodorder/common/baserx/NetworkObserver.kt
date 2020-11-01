package com.lamnt.foodorder.common.baserx

import android.app.Activity
import com.lamnt.foodorder.R
import com.lamnt.foodorder.model.dto.ResponseDTO
import com.lamnt.foodorder.utils.ValidateUtil
import com.lamnt.foodorder.view.base.CommonDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class NetworkObserver<E : ResponseDTO>(
    private val mContext: Activity,
    private val onRequest: OnRequest<E>) : Observer<E> {
    override fun onSubscribe(d: Disposable) {
        onRequest.returnDisposable(d)
    }

    override fun onNext(t: E) {
        if (ValidateUtil.checkNull(t)) {
            CommonDialog.showErrorMessage(mContext, mContext.getString(R.string.msg_output_empty))
        } else {
            if (t.success!!) {
                onRequest.returnData(t)
            } else {
                t.message?.let { CommonDialog.showErrorMessage(mContext, it) }
            }
        }
    }

    override fun onError(e: Throwable) {
        onRequest.requestDone()
        CommonDialog.showErrorMessage(mContext, mContext.getString(R.string.msg_server_exception))
    }

    override fun onComplete() {
        onRequest.requestDone()
    }


    interface OnRequest<E : ResponseDTO> {
        fun requestDone()
        fun returnDisposable(d: Disposable)
        fun returnData(e: E)
    }
}