package com.mahrous.demo_app.features.auth.data.repository

import android.util.Log
import com.mahrous.demo_app.core.app.Constants
import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.core.network.CheckInternet
import com.mahrous.demo_app.core.network.ConstantsErrorHandler
import com.mahrous.demo_app.core.network.handleError
import com.mahrous.demo_app.features.auth.data.data_source.AuthRemoteDataSource
import com.mahrous.demo_app.features.auth.data.mapper.mapFromDomain
import com.mahrous.demo_app.features.auth.data.mapper.mapFromModel

import com.mahrous.demo_app.features.auth.domain.model.*
import com.mahrous.demo_app.features.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val checkInternet: CheckInternet,
) : AuthRepository {
    override suspend fun login(domain: Login): Flow<DataState<User>> = flow {
        emit(DataState.Loading)
        if (checkInternet.isCheck()) {
            try {
                val response = authRemoteDataSource.login(
                    model = domain.mapFromDomain()
                )
                if (response.code == Constants.SUCCESS) {
                    emit(DataState.Success(response.data!!.mapFromModel()))
                    Log.e("TAG", "login:response.data ${response.data}", )

                } else {
                    emit(DataState.Failure(message = response.message))
                    Log.e("TAG", "login: response ${response.message}")
                }
            } catch (exception: HttpException) {

                val errorBody = exception.response()?.errorBody()
                if (errorBody != null) {
                    val errorMessage =   JSONObject(errorBody.string())
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
