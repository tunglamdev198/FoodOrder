package com.lamnt.foodorder.listener;

import io.reactivex.disposables.Disposable;

public interface OnResponseListener<E extends Object> {
    void returnDisposable(Disposable disposable);
    void returnResult(E e);
    void returnError(String message);
}
