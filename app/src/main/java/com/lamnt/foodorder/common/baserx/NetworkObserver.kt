package com.lamnt.foodorder.common.baserx

import android.app.Activity
import android.content.Context
import com.lamnt.foodorder.R
import com.lamnt.foodorder.model.dto.ResponseDTO
import com.lamnt.foodorder.utils.ValidateUtil
import com.lamnt.foodorder.view.base.CommonDialog
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class NetworkObserver<E> constructor(private val mContext: Context) : Observer<E> {

    override fun onNext(t: E) {
        if (ValidateUtil.checkNull(t)) {
            onError(Throwable(mContext.resources.getString(R.string.msg_output_empty)))
        }
    }

    override fun onError(e: Throwable) {
        CommonDialog.showErrorMessage(mContext, mContext.resources.getString(R.string.msg_server_exception))
    }
}