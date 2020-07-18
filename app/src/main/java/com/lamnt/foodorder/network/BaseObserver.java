package com.lamnt.foodorder.network;

import android.annotation.SuppressLint;
import android.content.Context;

import com.lamnt.foodorder.listener.OnResponseListener;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.dialog.ProcessDialog;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BaseObserver<E> {
    private Context context;
    private ProcessDialog processDialog;

    public BaseObserver(Context context) {
        this.context = context;
        processDialog = new ProcessDialog();
    }

    @SuppressLint("CheckResult")
    public void getObserver(Observable<E> baseObservable,
                            OnResponseListener<E> onResponseListener) {
        showProcess();
        Disposable disposable = baseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onResponseListener::returnResult,
                        throwable -> processDialog.dismiss(),
                        () -> processDialog.dismiss());
        onResponseListener.returnDisposable(disposable);
    }

    private void showProcess() {
        FragmentUtil.showDialogFragment(context, processDialog);
    }

}
