package com.lamnt.foodorder.view.base

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lamnt.foodorder.R

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewBinding : VB

    abstract fun setLayoutId(): Int

    abstract fun initView()

    abstract fun initDataBinding()
    abstract fun initData()

    abstract fun initViewModel()

    abstract fun initObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,setLayoutId())
        viewBinding.lifecycleOwner = this
        initViewModel()
        initDataBinding()
        initView()
        initData()
        initObserver()
    }

    fun navigateTo(clazz: Class<*>?, bundle: Bundle?) {
        navigateTo(clazz, bundle, true)
    }

    open fun navigateTo(
        clazz: Class<*>?,
        bundle: Bundle?,
        closeCurrent: Boolean) {
        val intent = Intent(this, clazz)
        if (bundle != null) intent.putExtras(bundle)
        startActivity(intent)
        if (closeCurrent) finish()
    }

    @SuppressLint("ShowToast")
    protected fun showToast(content : String) {
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show()
    }

    protected fun showPopup(title : String,
                            message : String,
                            onClickListener: DialogInterface.OnClickListener){
        val builder =  AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setNegativeButton(getString(R.string.text_no)
            ) { dialog, _ -> dialog.dismiss()}
            .setPositiveButton(getString(R.string.text_yes),onClickListener)
        builder.create().show()
    }

}