package com.example.umc_hackathon


data class DiaryResponse<T>(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: T
)

data class DiaryInfo(
    val title : String,
    val date : String,
    val place : String,
    val people : String,
    val feeling : String,
    val hashtag : String
)


