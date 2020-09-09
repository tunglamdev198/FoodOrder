package com.lamnt.foodorder.view.base

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() , View.OnClickListener{
    @JvmField
    @LayoutRes
    protected var layoutRes = 0
    private var views : List<View> = ArrayList()


    abstract fun setViewOnClick(): List<View>
    abstract fun onViewClicked(id : Int)

    override fun onStart() {
        super.onStart()
        try {
            val lp = WindowManager.LayoutParams()
            lp.copyFrom(this.dialog!!.window?.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.gravity = Gravity.CENTER
            this.dialog!!.setCancelable(false)
            this.dialog!!.window!!.attributes = lp
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unit()
        views = setViewOnClick()
        registerListener(views)
    }

    abstract fun unit()

    private fun registerListener(views : List<View>){
        for (view in views){
            view.setOnClickListener(this@BaseDialogFragment)
        }
    }
    override fun onClick(v: View?) {
        onViewClicked(v!!.id)
    }
}