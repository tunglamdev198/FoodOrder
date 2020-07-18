package com.lamnt.foodorder.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.lamnt.foodorder.listener.OnResponseListener;
import com.lamnt.foodorder.model.dto.ResponseDTO;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.dialog.ProcessDialog;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BaseObserver {
    private Context context;
    private ProcessDialog processDialog;

    private BaseObserver(Context context) {
        this.context = context;
        processDialog = new ProcessDialog();
    }

    public static BaseObserver build(Context context){
        BaseObserver baseObserver = new BaseObserver(context);
        return baseObserver;
    }



    @SuppressLint("CheckResult")
    private  <BODY, OUTPUT extends ResponseDTO<BODY>> void getObserver(
                            Observable<OUTPUT> observable,
                            OnResponseListener<BODY> onResponseListener) {

        showProcess();
        Disposable disposable = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(output -> onResponseListener.returnResult(output.getData()),
                        throwable -> {
                            processDialog.dismiss();
                            Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }, () -> processDialog.dismiss());
        onResponseListener.returnDisposable(disposable);
    }

    private BaseService getService(){
        return Request.getIService();
    }

    public <BODY, OUTPUT extends ResponseDTO<BODY>> void getMapping(OnResponseListener<BODY> onResponseListener){
        Observable observable = getService().getMapping("employees");
        getObserver(observable,onResponseListener);
    }

    private void showProcess() {
        FragmentUtil.showDialogFragment(context, processDialog);
    }

}
