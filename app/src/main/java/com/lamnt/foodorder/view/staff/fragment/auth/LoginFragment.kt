package com.lamnt.foodorder.view.staff.fragment.auth

import android.content.Intent
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import butterknife.OnClick
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.lamnt.foodorder.R
import com.lamnt.foodorder.listener.OnResponseListener
import com.lamnt.foodorder.model.dto.DataDTO
import com.lamnt.foodorder.network.BaseObserver.Companion.build
import com.lamnt.foodorder.utils.FragmentUtil.replaceFragment
import com.lamnt.foodorder.utils.FragmentUtil.showDialogFragment
import com.lamnt.foodorder.view.staff.activity.MainActivity
import com.lamnt.foodorder.view.base.BaseFragment
import com.lamnt.foodorder.view.staff.fragment.dialog.OTPConfirmDialogFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONException
import java.util.*
import kotlin.collections.ArrayList

class LoginFragment : BaseFragment() {
    private var isShowPassword = false
    private var mCallbackManager: CallbackManager? = null
    private var mCompositeDisposable : CompositeDisposable? = null

    override fun getLayoutRes(): Int {
        return R.layout.fragment_login
    }

   override fun setTitle(): Int {
        return 0
    }

    override fun setViewOnClick(): List<View> {
        return listOf<View>(btnVisible,btnForgotPassword,btnLogin,btnLoginFacebook,btnLoginGoogle,txtRegister)
    }

    override fun onViewClicked(id: Int) {
        when(id){
            R.id.btnVisible -> onBtnVisibleClicked()
            R.id.btnForgotPassword -> onBtnForgotPasswordClicked()
            R.id.btnLogin -> onBtnLoginClicked()
            R.id.btnLoginFacebook -> onBtnLoginFacebookClicked()
            R.id.btnLoginGoogle -> onBtnLoginGoogleClicked()
            R.id.txtRegister -> onTxtRegisterClicked()
        }
    }

    override fun unit() {
        mCompositeDisposable = CompositeDisposable()
        val baseObserver = activity?.let {build(it) }
        baseObserver?.getMapping("employees", object : OnResponseListener {
            override fun returnDisposable(disposable: Disposable?) {
                disposable?.let { mCompositeDisposable?.add(it) }
            }
            override fun returnResult(data: DataDTO?) {
                Log.d(TAG, "returnResult: ${data?.employee.toString()}")
            }
            override fun returnError(message: String?) {}
        })

    }

    override val isShowNotificationIcon: Boolean
        get() = false

    override val isShowSearchIcon: Boolean
        get() = false

    override val isShowBottomNav: Boolean
        get() = false

    @OnClick(R.id.btnVisible)
    fun onBtnVisibleClicked() {
        if (isShowPassword) {
            btnVisible!!.setImageResource(R.drawable.ic_show_password)
            edtPassword!!.setSelection(edtPassword!!.text.toString().length)
            edtPassword!!.transformationMethod = PasswordTransformationMethod()
            isShowPassword = false
        } else {
            btnVisible!!.setImageResource(R.drawable.ic_hide_password)
            edtPassword!!.transformationMethod = null
            edtPassword!!.setSelection(edtPassword!!.text.toString().length)
            isShowPassword = true
        }
    }

    @OnClick(R.id.btnForgotPassword)
    fun onBtnForgotPasswordClicked() {
    }

    private fun fbLogin() {
        mCallbackManager = CallbackManager.Factory.create()

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"))
        LoginManager.getInstance().registerCallback(mCallbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                        println("Success")
                        GraphRequest.newMeRequest(
                                loginResult.accessToken) { json, response ->
                            if (response.error != null) {
                                // handle error
                                println("ERROR")
                            } else {
                                println("Success")
                                try {
                                    val jsonresult = json.toString()
                                    println("JSON Result$jsonresult")
                                    val str_email = json.getString("email")
                                    val str_id = json.getString("id")
                                    val str_firstname = json.getString("first_name")
                                    val str_lastname = json.getString("last_name")
                                    Toast.makeText(mActivity, "email : $str_email , name : $str_firstname $str_lastname", Toast.LENGTH_SHORT).show()
                                } catch (e: JSONException) {
                                    e.printStackTrace()
                                }
                            }
                        }.executeAsync()
                    }

                    override fun onCancel() {}
                    override fun onError(error: FacebookException) {}
                })
    }

    @OnClick(R.id.btnLogin)
    fun onBtnLoginClicked() {
        showDialogFragment(activity,
                OTPConfirmDialogFragment.newInstance(
                    "0337539494",
                    object : OTPConfirmDialogFragment.OnConfirmOTPDone{
                    override fun onDone() {
                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                        activity!!.finish()
                    }
                }))
    }

    @OnClick(R.id.btnLoginFacebook)
    fun onBtnLoginFacebookClicked() {
        fbLogin()
    }

    fun onBtnLoginGoogleClicked() {
        fbLogin()
    }

    @OnClick(R.id.txtRegister)
    fun onTxtRegisterClicked() {
        replaceFragment(mActivity,
                R.id.login_container,
                RegisterFragment(),
                true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mCallbackManager!!.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}