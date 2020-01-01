package com.android.revolut.myapplication.model

import com.android.revolut.myapplication.data.OperationsCallback

interface TrendingRepoDataSource {
    fun retriveTrendingRepos(callback: OperationsCallback)
    fun cancel()
}