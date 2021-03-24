package com.lamnt.foodorder.listener

interface OnResponseListener <E>{
    fun onSuccess(e: E)
}