package com.mahrous.demo_app.features.rx_upload.data.repository

import android.util.Log
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.Constants
import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.core.network.CheckInternet
import com.mahrous.demo_app.core.network.ConstantsErrorHandler
import com.mahrous.demo_app.core.network.handleError

import com.mahrous.demo_app.features.home.data.data_source.HomeRemoteDataSource
import com.mahrous.demo_app.features.home.data.request.UpdateFCMTokenRequestDto
import com.mahrous.demo_app.features.home.domain.repository.HomeRepository
import com.mahrous.demo_app.features.rx_upload.data.data_source.RxUploadRemoteDataSource
import com.mahrous.demo_app.features.rx_upload.domain.repository.RxUploadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class RxUploadRepositoryImpl @Inject constructor(
    private val rxUploadRemoteDataSource: RxUploadRemoteDataSource,
    private val checkInternet: CheckInternet,
) : RxUploadRepository {


}
