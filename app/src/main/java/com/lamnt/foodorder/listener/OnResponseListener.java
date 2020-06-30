package com.lamnt.foodorder.listener;

import com.lamnt.foodorder.model.dto.ResponseDTO;

import io.reactivex.disposables.Disposable;

public interface OnResponseListener<E extends Object> {
    void returnDisposable(Disposable disposable);
    void returnResult(E e);
}
