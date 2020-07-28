package com.lamnt.foodorder.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.lamnt.foodorder.listener.OnResponseListener;
import com.lamnt.foodorder.model.dto.ResponseDTO;
import com.lamnt.foodorder.utils.FragmentUtil;
import com.lamnt.foodorder.view.fragment.dialog.ProcessDialog;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BaseObserver {
    private Context context;
    private ProcessDialog processDialog;

    private BaseObserver(Context context) {
        this.context = context;
        processDialog = new ProcessDialog();
    }

    public static BaseObserver build(Context context) {
        return new BaseObserver(context);
    }


    @SuppressLint("CheckResult")
    private <DATA, OUTPUT extends ResponseDTO<DATA>>
    void getObserver(
            Observable<OUTPUT> observable,
            OnResponseListener<DATA> onResponseListener) {
        showProcess();
        Disposable disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(output -> onResponseListener.returnResult(output.getData()),
                        throwable -> {
                            processDialog.dismiss();
                            Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        },
                        () -> processDialog.dismiss());
        onResponseListener.returnDisposable(disposable);
    }

    private BaseService getService() {
        return Request.getIService();
    }

    public <DATA, OUTPUT extends ResponseDTO<DATA>> void getMapping(String endpoint,
                                                                    OnResponseListener<DATA> onResponseListener) {
        Observable observable = getService().getMapping(endpoint);
        getObserver(observable, onResponseListener);
    }

    public <DATA, OUTPUT extends ResponseDTO<DATA>> void deleteMapping(String endpoint,
                                                                       OnResponseListener<DATA> onResponseListener) {
        Observable observable = getService().deleteMapping(endpoint);
        getObserver(observable, onResponseListener);
    }

    public <DATA, OUTPUT extends ResponseDTO<DATA>, BODY extends BaseRequestBody>
    void postMapping(String endpoint,
                     BODY body,
                     OnResponseListener<DATA> onResponseListener) {
        Observable observable = getService().postMapping(endpoint, body);
        getObserver(observable, onResponseListener);
    }

    public <DATA, OUTPUT extends ResponseDTO<DATA>, BODY extends BaseRequestBody>
    void putMapping(String endpoint,
                    BODY body,
                    OnResponseListener<DATA> onResponseListener) {
        Observable observable = getService().putMapping(endpoint, body);
        getObserver(observable, onResponseListener);
    }

    private void showProcess() {
        FragmentUtil.showDialogFragment(context, processDialog);
    }

}
