package com.android.revolut.myapplication.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.revolut.myapplication.data.OperationsCallback
import com.android.revolut.myapplication.model.TrendingRepoDataSource
import com.android.revolut.myapplication.model.TrendingRepos
import org.json.JSONArray
import org.json.JSONObject
class TrendingViewModel(private val repositry: TrendingRepoDataSource) : ViewModel() {

    private val _repos = MutableLiveData<List<TrendingRepos>>().apply { value = emptyList() }
    val _location_address: LiveData<List<TrendingRepos>> = _repos

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    fun loadRepos()
    {
        _isViewLoading.postValue(true)
        repositry.retriveTrendingRepos(object : OperationsCallback {
            override fun onError(obj: Any) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(obj)
            }

            override fun onSuccess(obj: Any) {
                _isViewLoading.postValue(false)
                if (obj != null) {

//                    var str_response = obj.toString()
//                    val json_contact: JSONObject = JSONObject(str_response)
//                    val keys = json_contact.keys()
//                    var myList: MutableList<TrendingRepos> = mutableListOf<TrendingRepos>()
//                    while (keys.hasNext()) {
//                        val key = keys.next()
//                        val value = json_contact.optDouble(key)
//
//                      //  val rateobj = TrendingRepos(key, value)
//                        myList.add(rateobj)
                    }
                    //_locations.value = myList
                  //  Log.i(_locations.value.toString(),"")


                }


        })

    }
}