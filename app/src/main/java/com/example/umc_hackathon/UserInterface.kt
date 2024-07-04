package com.example.umc_hackathon

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInterface {
    @POST("/user/login")
    fun login(
        @Body userAccount: UserAccount
    ): Call<UserResponse<UserLogin>>

    @POST("/user/join")
    fun join(
        @Body userSignup: UserSignup
    ): Call<UserResponse<UserJoin>>

    @POST("/user/check-account")
    fun check_account(
        @Body checkAccountRequest: CheckAccountRequest
    ): Call<UserResponse<CheckAccount>>
}