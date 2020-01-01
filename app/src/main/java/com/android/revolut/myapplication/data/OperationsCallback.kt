package com.android.revolut.myapplication.data

interface OperationsCallback {
    fun onSuccess(obj: Any)
    fun onError(obj: Any)
}