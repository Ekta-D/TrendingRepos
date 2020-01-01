package com.android.revolut.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.revolut.myapplication.model.TrendingRepoDataSource

class ViewModelFactory(private val repository:TrendingRepoDataSource): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<  T>): T {
        return TrendingViewModel(repository) as T
    }
}