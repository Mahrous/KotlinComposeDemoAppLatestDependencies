package com.mahrous.demo_app.features.auth.domain.usecase

import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.core.generic.usecase.BaseUseCase
import com.mahrous.demo_app.features.auth.domain.model.Login
import com.mahrous.demo_app.features.auth.domain.model.User
import com.mahrous.demo_app.features.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val userRepository: AuthRepository
) : BaseUseCase<Login, Flow<DataState<User>>> {

    override suspend fun execute(input: Login): Flow<DataState<User>> {
        return userRepository.login(input)
    }
}