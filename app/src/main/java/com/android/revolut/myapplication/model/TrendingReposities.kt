package com.android.revolut.myapplication.model

import android.util.Log
import com.android.revolut.myapplication.data.ApiClient
import com.android.revolut.myapplication.data.BaseTrendingRepo
import com.android.revolut.myapplication.data.OperationsCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrendingReposities:TrendingRepoDataSource {
    private var call: Call<TrendingRepos>? = null
    override fun retriveTrendingRepos(callback: OperationsCallback) {
        call = ApiClient.build()?.getTrendingRepos()
        call?.enqueue(object : Callback<TrendingRepos> {
            override fun onFailure(call: Call<TrendingRepos>, t: Throwable) {
                t.message?.let { callback.onError(it) }
            }

            override fun onResponse(call: Call<TrendingRepos>, response: Response<TrendingRepos>) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        //Log.v("response", "data ${it.repos}")

//                        callback.onSuccess(it.repos!!)
                    }else{
                        callback.onError("No response found")
                    }
                }
            }
        })
    }

    override fun cancel() {

    }
}