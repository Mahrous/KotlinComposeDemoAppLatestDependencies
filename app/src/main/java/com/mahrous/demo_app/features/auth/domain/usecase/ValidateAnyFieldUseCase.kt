package com.mahrous.demo_app.features.auth.domain.usecase

import com.mahrous.demo_app.R
import com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.generic.usecase.BaseUseCase
import javax.inject.Inject

class ValidateAnyFieldUseCase @Inject constructor() : BaseUseCase<String, ValidationResult> {
    override suspend fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strTheFieldCanNotBeBlank)
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}