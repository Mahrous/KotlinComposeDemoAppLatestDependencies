package com.mahrous.demo_app.features.auth.domain.repository

import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.features.auth.domain.model.Login
import com.mahrous.demo_app.features.auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(domain: Login): Flow<DataState<User>>
}