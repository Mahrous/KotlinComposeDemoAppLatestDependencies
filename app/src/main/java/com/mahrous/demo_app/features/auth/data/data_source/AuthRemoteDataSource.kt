package com.mahrous.demo_app.features.auth.data.data_source

import com.mahrous.demo_app.core.generic.dto.ResponseDto
import com.mahrous.demo_app.features.auth.data.request.LoginRequestDto
import com.mahrous.demo_app.features.auth.data.response.UserResponseDto

interface AuthRemoteDataSource {
    suspend fun login(model: LoginRequestDto): ResponseDto<UserResponseDto>






}