package com.mahrous.demo_app.features.home.domain.repository

import com.mahrous.demo_app.core.common.DataState
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun updateFCMToken(domain: Unit): Flow<DataState<Unit>>
}