package com.mahrous.demo_app.features.home.data.data_source



import com.mahrous.demo_app.api.DemoAppApi
import com.mahrous.demo_app.core.generic.dto.ResponseDto
import com.mahrous.demo_app.features.home.data.request.UpdateFCMTokenRequestDto
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val api: DemoAppApi
) : HomeRemoteDataSource {
    override suspend fun updateFCMToken(token:String,model: UpdateFCMTokenRequestDto): ResponseDto<Unit> {
        return ResponseDto<Unit>()
    }


}