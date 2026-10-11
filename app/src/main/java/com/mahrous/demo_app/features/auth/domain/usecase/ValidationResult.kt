package com.mahrous.demo_app.features.auth.domain.usecase

import com.mahrous.demo_app.core.app.UiText


data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)

