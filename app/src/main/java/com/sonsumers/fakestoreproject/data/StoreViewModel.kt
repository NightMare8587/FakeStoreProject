package com.sonsumers.fakestoreproject.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonsumers.fakestoreproject.model.StoreModelsItem
import com.sonsumers.fakestoreproject.network.ApiCalls
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(val apiCalls: ApiCalls) : ViewModel() {
    private val TAG = "StoreViewModel"
    private val _storeProducts = MutableSharedFlow<List<StoreModelsItem>>()
    val storeProducts: SharedFlow<List<StoreModelsItem>> = _storeProducts

    fun fetchProducts() {
        viewModelScope.launch {
            apiCalls.fetchProducts().enqueue(object : Callback<List<StoreModelsItem>> {
                override fun onResponse(
                    p0: Call<List<StoreModelsItem>>,
                    p1: Response<List<StoreModelsItem>>
                ) {
                    if (p1.code() == 200) {
                        CoroutineScope(Dispatchers.IO).launch {
                            _storeProducts.emit(p1.body()!!)
                        }
                    }
                    Log.d(TAG, "onResponse: success body ${p1.body()}")
                    Log.d(TAG, "onResponse: success code ${p1.code()}")
                }

                override fun onFailure(p0: Call<List<StoreModelsItem>>, p1: Throwable) {
                    Log.d(TAG, "onFailure: faliure response ${p1.message}")
                }

            })
        }
    }
}