package com.example.kataanime.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("english")
    val english: String,
    @SerializedName("indo")
    val indo: String,
    @SerializedName("character")
    val character: String,
    @SerializedName("anime")
    val anime: String
)
