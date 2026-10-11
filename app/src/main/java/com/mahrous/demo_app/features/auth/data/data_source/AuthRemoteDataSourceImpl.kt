package com.mahrous.demo_app.features.auth.data.data_source



import com.mahrous.demo_app.api.DemoAppApi
import com.mahrous.demo_app.core.generic.dto.ResponseDto
import com.mahrous.demo_app.features.auth.data.request.LoginRequestDto
import com.mahrous.demo_app.features.auth.data.response.UserResponseDto
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val api: DemoAppApi
) : AuthRemoteDataSource {
    override suspend fun login(
        model: LoginRequestDto
    ): ResponseDto<UserResponseDto> {
        return api.login(model = model)
    }


}