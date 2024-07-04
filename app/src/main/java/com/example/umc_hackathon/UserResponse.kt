package com.example.umc_hackathon

data class UserResponse<T>(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: T
)

data class UserJoin(
    val userId: Int,
    val createdAt: String
)

data class UserLogin(
    val userId: Int,
    val name: String
)

data class UserCheck(
    val duplicated: Boolean
)

data class UserAccount(
    var account: String,
    var password: String
)

data class UserSignup(
    var name: String,
    var account: String,
    var password: String
)