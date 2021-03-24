package com.lamnt.foodorder.network

import android.annotation.SuppressLint
import android.app.Activity
import com.lamnt.foodorder.listener.OnActionSuccessListener
import com.lamnt.foodorder.listener.OnResponseListener
import com.lamnt.foodorder.model.dto.ResponseDTO
import com.lamnt.foodorder.utils.ActivityUtil.showDialogFragment
import com.lamnt.foodorder.view.staff.fragment.dialog.ProcessDialog
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RequestCommon<E : ResponseDTO> private constructor(private val context: Activity) {
    private val processDialog: ProcessDialog = ProcessDialog()

    @SuppressLint("CheckResult")
    private fun requestAPI(observable: Observable<E>,
                           onResponseListener: OnResponseListener<E>) {
        showProcess()
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(networkObserver)
    }

    private fun showProcess() {
        showDialogFragment(context, processDialog)
    }

    private fun getObserverNoData(
        completable: Completable,
        onResponseListener: OnActionSuccessListener
    ) {
        completable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {
                    onResponseListener.returnDisposable(d);
                }

                override fun onComplete() {
                    onResponseListener.isSucceed(true)
                }

                override fun onError(e: Throwable) {
                    onResponseListener.isSucceed(false)
                    onResponseListener.handleMessage(e.message)
                }

            })
    }

    companion object {
        @JvmStatic
        fun<E : ResponseDTO> build(context: Activity): RequestCommon<E> {
            return RequestCommon(context)
        }
    }
}