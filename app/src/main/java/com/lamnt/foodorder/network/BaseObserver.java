package com.lamnt.foodorder.network;

import android.content.Context;

import com.lamnt.foodorder.listener.OnResponseListener;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.dialog.ProcessDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseObserver<E extends Object> {
    private Context context;
    private ProcessDialog processDialog;

    public BaseObserver(Context context) {
        this.context = context;
        processDialog = new ProcessDialog();
    }

    public Observer<E> getObserver(OnResponseListener<E> onResponseListener){
        showProcess();
        return new Observer<E>() {
            @Override
            public void onSubscribe(Disposable d) {
                onResponseListener.returnDisposable(d);
            }

            @Override
            public void onNext(E e) {
                onResponseListener.returnResult(e);
            }

            @Override
            public void onError(Throwable e) {
                processDialog.dismiss();
            }

            @Override
            public void onComplete() {
                processDialog.dismiss();
            }
        };
    }

    private void showProcess(){
        FragmentUtil.showDialogFragment(context,processDialog);
    }

}
