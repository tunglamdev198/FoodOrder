package com.lamnt.foodorder.network

interface IData<T : Any> {
    fun setData(t : T)
}