package com.mahrous.demo_app.features.home.data.repository

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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource,
    private val checkInternet: CheckInternet,
) : HomeRepository {
    override suspend fun updateFCMToken(domain: Unit): Flow<DataState<Unit>> = flow {
        emit(DataState.Loading)
        if (checkInternet.isCheck()) {
            try {
                val response = homeRemoteDataSource.updateFCMToken(
                    model = UpdateFCMTokenRequestDto(),
                    token = AppPreferences.getCurrentToken()
                )
                if (response.code == Constants.SUCCESS) {
                    emit(DataState.Success(Unit))
                    Log.e("TAG", "login:response.data ${response.data}")

                } else {
                    emit(DataState.Failure(message = response.message))
                    Log.e("TAG", "login: response ${response.message}")
                }
            } catch (exception: HttpException) {

                val errorBody = exception.response()?.errorBody()
                if (errorBody != null) {
                    val errorMessage = JSONObject(errorBody.string())
                        .optString("message", "Unknown error")

                    emit(DataState.Failure(message = errorMessage))
                } else {
                    emit(DataState.Failure(uiText = handleError(ConstantsErrorHandler.EXCEPTION_MESSAGE)))
                }
            }
        } else {
            emit(DataState.Failure(uiText = handleError(ConstantsErrorHandler.EXCEPTION_MESSAGE)))
        }
    }

}
