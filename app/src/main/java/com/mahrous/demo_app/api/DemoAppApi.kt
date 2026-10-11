package com.mahrous.demo_app.api

import com.mahrous.demo_app.core.generic.dto.ResponseDto
import com.mahrous.demo_app.features.auth.data.request.LoginRequestDto
import com.mahrous.demo_app.features.auth.data.response.UserResponseDto

import retrofit2.http.*

interface DemoAppApi {

    @POST("auth/jwt/create/")
    suspend fun login(
        @Body model: LoginRequestDto
    ): ResponseDto<UserResponseDto>







}
