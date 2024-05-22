package com.sonsumers.fakestoreproject.network

import com.sonsumers.fakestoreproject.model.StoreModelsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiCalls {
    @GET("products")
    fun fetchProducts() : Call<List<StoreModelsItem>>
}