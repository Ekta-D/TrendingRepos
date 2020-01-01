package com.android.revolut.myapplication.di

import com.android.revolut.myapplication.model.TrendingRepoDataSource
import com.android.revolut.myapplication.model.TrendingReposities

object Injection {
    fun providerRepository():TrendingRepoDataSource{
        return TrendingReposities()
    }
}