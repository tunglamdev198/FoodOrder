package com.lamnt.foodorder.network

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.lamnt.foodorder.listener.OnActionSuccessListener
import com.lamnt.foodorder.listener.OnResponseListener
import com.lamnt.foodorder.model.dto.DataDTO
import com.lamnt.foodorder.utils.FragmentUtil.showDialogFragment
import com.lamnt.foodorder.view.staff.fragment.dialog.ProcessDialog
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BaseObserver private constructor(private val context: Context) {
    private val processDialog: ProcessDialog = ProcessDialog()

    @SuppressLint("CheckResult")
    private fun getObserver(
            observable: Observable<DataDTO>,
            onResponseListener: OnResponseListener) {
        showProcess()
        val disposable = observable
            .subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(
                    { output: DataDTO -> onResponseListener.returnResult(output) },
                    { throwable: Throwable ->
                            processDialog.dismiss()
                            Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
                    }
                ) { processDialog.dismiss() }
        onResponseListener.returnDisposable(disposable)
    }


    @JvmSuppressWildcards
    fun getMapping(endpoint: String?,
                          onResponseListener: OnResponseListener) {
        val observable: Observable<DataDTO> =  Request.getService().getMapping(endpoint)
        getObserver(observable, onResponseListener)
    }

    fun deleteMapping(endpoint: String?,
                      onResponseListener: OnActionSuccessListener) {
        val completable: Completable = Request.getService().deleteMapping(endpoint)
        getObserverNoData(completable, onResponseListener)
    }

    private fun getObserverNoData(completable : Completable, onResponseListener: OnActionSuccessListener) {
        completable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object  : CompletableObserver {
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

    @JvmSuppressWildcards
    fun <BODY : BaseRequestBody?> postMapping(endpoint: String?,
                                                    body: BODY,
                                                    onResponseListener: OnResponseListener) {
        val observable: Observable<DataDTO> = Request.getService().postMapping(endpoint, body)
        getObserver(observable, onResponseListener)
    }

    @JvmSuppressWildcards
    fun <BODY : BaseRequestBody?> putMapping(endpoint: String?,
                                                   body: BODY,
                                                   onResponseListener: OnResponseListener) {
        val observable: Observable<DataDTO> = Request.getService().putMapping(endpoint, body)
        getObserver(observable, onResponseListener)
    }

    private fun showProcess() {
        showDialogFragment(context, processDialog)
    }

    companion object {
        @JvmStatic
        fun build(context: Context): BaseObserver {
            return BaseObserver(context)
        }
    }
}