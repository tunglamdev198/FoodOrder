package com.lamnt.foodorder.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lamnt.foodorder.common.baserx.NetworkObserver
import com.lamnt.foodorder.listener.OnResponseListener
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


open class BaseViewModel : ViewModel() {
    @SuppressLint("StaticFieldLeak")
    @Inject @ApplicationContext lateinit var context: Context
    private val loading : MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage : MutableLiveData<String> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun<T> makeRequest(observable: Observable<T>, onResponseListener: OnResponseListener<T>) {
        observable.observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { loading.postValue(true) }
            .doOnTerminate { loading.postValue(false) }
            .subscribe(object : NetworkObserver<T>(context) {
                override fun onSubscribe(d: Disposable) {
                    addDispose(d)
                }

                override fun onNext(t: T) {
                    onResponseListener.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    errorMessage.value = e.message
                }

                override fun onComplete() {

                }

            })
    }

    fun addDispose(disposable: Disposable){
        compositeDisposable.add(disposable)
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}