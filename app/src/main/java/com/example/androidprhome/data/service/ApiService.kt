package com.example.androidprhome.data.service

import com.example.androidprhome.data.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    suspend fun getData(): Response<List<ItemsResponse>>
}