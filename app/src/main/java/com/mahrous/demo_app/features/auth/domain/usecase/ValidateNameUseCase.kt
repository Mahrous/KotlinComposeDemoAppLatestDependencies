package com.mahrous.demo_app.features.auth.domain.usecase

import com.mahrous.demo_app.R
import com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.functions.isNameContainJustLetterValidInput
import com.mahrous.demo_app.core.generic.usecase.BaseUseCase
import javax.inject.Inject

class ValidateNameUseCase @Inject constructor() : BaseUseCase<String, ValidationResult> {
    override suspend fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strTheNameCanNotBeBlank)
            )
        } else if (!isNameContainJustLetterValidInput(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strTheNameCanContainDigitsAndLettersOnly)
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}