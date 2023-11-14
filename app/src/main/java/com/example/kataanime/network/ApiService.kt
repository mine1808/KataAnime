package com.example.kataanime.network

import com.example.kataanime.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("getrandom")
    fun getAllUsers(): Call<Users>
}