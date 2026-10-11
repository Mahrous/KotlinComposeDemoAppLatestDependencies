package com.mahrous.demo_app.features.home.domain.usecase

import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.core.generic.usecase.BaseUseCase
import com.mahrous.demo_app.features.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateFCMTokenUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseUseCase<Unit, Flow<DataState<Unit>>> {

    override suspend fun execute(input: Unit): Flow<DataState<Unit>> {
        return homeRepository.updateFCMToken(input)
    }
}