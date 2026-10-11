package com.mahrous.demo_app.features.home.data.data_source

import com.mahrous.demo_app.core.generic.dto.ResponseDto
import com.mahrous.demo_app.features.home.data.request.UpdateFCMTokenRequestDto

interface HomeRemoteDataSource {
    suspend fun updateFCMToken(token:String,model: UpdateFCMTokenRequestDto): ResponseDto<Unit>






}