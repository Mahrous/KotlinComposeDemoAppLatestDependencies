package com.mahrous.demo_app.core.generic.usecase

interface BaseUseCase<In, Out>{
    suspend fun execute(input: In): Out
}