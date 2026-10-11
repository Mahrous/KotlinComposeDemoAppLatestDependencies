package com.mahrous.demo_app.features.auth.domain.usecase

import android.content.Context
import com.mahrous.demo_app.R
import com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.functions.isNumber
import com.mahrous.demo_app.core.functions.isValidPhoneWithCountryCode
import com.mahrous.demo_app.core.generic.usecase.BaseUseCase
import com.mahrous.demo_app.features.auth.domain.model.ValidatePhoneModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.text.isBlank

class ValidatePhoneNumberUseCase @Inject constructor(@param:ApplicationContext private val context: Context,) : BaseUseCase<ValidatePhoneModel, ValidationResult> {
    override suspend fun execute(input: ValidatePhoneModel): ValidationResult {
        if (input.phone.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePhoneCanNotBeBlank),
            )
        }

        if (!isNumber(input.phone)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePhoneNumberShouldBeContentJustDigit),
            )
        }
        
        if (!isValidPhoneWithCountryCode(input.phone,input.code,context))
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.phone_number_not_valid_with_country_code),
            )

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}