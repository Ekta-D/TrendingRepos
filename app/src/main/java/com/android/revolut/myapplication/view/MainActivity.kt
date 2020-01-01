package com.android.revolut.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.revolut.myapplication.R
import com.android.revolut.myapplication.di.Injection
import com.android.revolut.myapplication.model.TrendingRepos
import com.android.revolut.myapplication.viewmodel.TrendingViewModel
import com.android.revolut.myapplication.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TrendingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, ViewModelFactory(Injection.providerRepository()))
            .get(TrendingViewModel::class.java)
        viewModel._location_address.observe(this, renderRepos)

        viewModel.isViewLoading.observe(this, isViewLoadingObserver)

    }

    private val renderRepos= Observer<List<TrendingRepos>> {
       // adapter.update(it)
    }
    private val isViewLoadingObserver= Observer<Boolean> {
        val visibility=if(it) View.VISIBLE else View.GONE

    }

    override fun onResume() {
        super.onResume()
        viewModel.loadRepos()
    }
}
