package com.lamnt.foodorder.view.staff.fragment.auth

import android.content.Intent
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.lamnt.foodorder.R
import com.lamnt.foodorder.databinding.FragmentLoginBinding
import com.lamnt.foodorder.listener.OnResponseListener
import com.lamnt.foodorder.model.dto.DataDTO
import com.lamnt.foodorder.network.RequestCommon.Companion.build
import com.lamnt.foodorder.utils.ActivityUtil.replaceFragment
import com.lamnt.foodorder.utils.ActivityUtil.showDialogFragment
import com.lamnt.foodorder.view.base.BaseFragmentMVVM
import com.lamnt.foodorder.view.staff.activity.MainActivity
import com.lamnt.foodorder.view.staff.fragment.dialog.OTPConfirmDialogFragment
import com.lamnt.foodorder.viewmodel.LoginFragmentViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONException

class LoginFragment : BaseFragmentMVVM<LoginFragmentViewModel,FragmentLoginBinding>() {
    private var isShowPassword = false
    private var mCallbackManager: CallbackManager? = null
    private var mCompositeDisposable : CompositeDisposable? = null

    override fun getLayoutRes(): Int = R.layout.fragment_login

   override fun setTitle(): Int = 0


    fun onBtnVisibleClicked() {
        if (isShowPassword) {
            viewBinding.btnVisible.setImageResource(R.drawable.ic_show_password)
            viewBinding.edtPassword.setSelection(edtPassword!!.text.toString().length)
            viewBinding.edtPassword.transformationMethod = PasswordTransformationMethod()
            isShowPassword = false
        } else {
            viewBinding.btnVisible.setImageResource(R.drawable.ic_hide_password)
            viewBinding.edtPassword.transformationMethod = null
            viewBinding.edtPassword.setSelection(edtPassword!!.text.toString().length)
            isShowPassword = true
        }
    }

    fun onBtnForgotPasswordClicked() {
    }

    private fun fbLogin() {
        mCallbackManager = CallbackManager.Factory.create()

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "user_photos", "public_profile"))
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
                                    Toast.makeText(activity, "email : $str_email , name : $str_firstname $str_lastname", Toast.LENGTH_SHORT).show()
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

    fun onBtnLoginFacebookClicked() {
        fbLogin()
    }

    fun onBtnLoginGoogleClicked() {
        fbLogin()
    }

    fun onTxtRegisterClicked() {
        replaceFragment(activity,
                R.id.login_container,
                RegisterFragment(),
                true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mCallbackManager!!.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun initViewModel() {

    }

    override fun initObserver() {

    }

    override fun initViews() {
        mCompositeDisposable = CompositeDisposable()
        val baseObserver = activity?.let {build<DataDTO>(it) }
        baseObserver?.getMapping("employees", object : OnResponseListener<DataDTO> {
            override fun returnDisposable(disposable: Disposable?) {
                disposable?.let { mCompositeDisposable?.add(it) }
            }
            override fun returnResult(e: DataDTO) {
                Log.d(TAG, "returnResult: ${e.employee.toString()}")
            }
            override fun returnError(message: String?) {}
        })
    }

    override fun initDataBinding() {
        viewBinding.loginFragment = this
    }

    override fun initData() {

    }
}