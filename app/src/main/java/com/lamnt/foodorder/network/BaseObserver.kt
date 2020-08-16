package com.lamnt.foodorder.network

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.lamnt.foodorder.listener.OnResponseListener
import com.lamnt.foodorder.model.dto.ResponseDTO
import com.lamnt.foodorder.model.dto.ResponseNoDataDTO
import com.lamnt.foodorder.utils.FragmentUtil.showDialogFragment
import com.lamnt.foodorder.view.fragment.dialog.ProcessDialog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BaseObserver<E> private constructor(private val context: Context) {
    private val processDialog: ProcessDialog = ProcessDialog()

    @SuppressLint("CheckResult")
    private fun <DATA, OUTPUT : ResponseDTO<DATA>?> getObserver(
            observable: Observable<OUTPUT>?,
            onResponseListener: OnResponseListener<DATA>) {
        showProcess()
        val disposable = observable
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ output: OUTPUT -> onResponseListener.returnResult(output!!.data) },
                        { throwable: Throwable ->
                            processDialog.dismiss()
                            Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
                        }
                ) { processDialog.dismiss() }
        onResponseListener.returnDisposable(disposable)
    }

    private fun getObserverNoData(
            observable: Observable<ResponseNoDataDTO>?,
            onResponseListener: OnResponseListener<ResponseNoDataDTO>) {
        showProcess()
        val disposable = observable
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ output: ResponseNoDataDTO -> onResponseListener.returnResult(output) },
                        { throwable: Throwable ->
                            processDialog.dismiss()
                            Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
                        }
                ) { processDialog.dismiss() }
        onResponseListener.returnDisposable(disposable)
    }

    fun getMapping(endpoint: String?,
                          onResponseListener: OnResponseListener<E>) {
        val observable: Observable<ResponseDTO<E>> = Request.getService().getMapping(endpoint)
        getObserver(observable, onResponseListener)
    }

    fun deleteMapping(endpoint: String?,
                      onResponseListener: OnResponseListener<ResponseNoDataDTO>) {
        val observable: Observable<ResponseNoDataDTO> = Request.getService().deleteMapping(endpoint)
        getObserverNoData(observable, onResponseListener)
    }

    fun <BODY : BaseRequestBody?> postMapping(endpoint: String?,
                                                    body: BODY,
                                                    onResponseListener: OnResponseListener<E>) {
        val observable: Observable<ResponseDTO<E>> = Request.getService().postMapping(endpoint, body)
        getObserver(observable, onResponseListener)
    }

    fun <BODY : BaseRequestBody?> putMapping(endpoint: String?,
                                                   body: BODY,
                                                   onResponseListener: OnResponseListener<E>) {
        val observable: Observable<ResponseDTO<E>> = Request.getService().putMapping(endpoint, body)
        getObserver(observable, onResponseListener)
    }

    private fun showProcess() {
        showDialogFragment(context, processDialog)
    }

    companion object {
        @JvmStatic
        fun<E> build(context: Context): BaseObserver<E> {
            return BaseObserver(context)
        }
    }

}