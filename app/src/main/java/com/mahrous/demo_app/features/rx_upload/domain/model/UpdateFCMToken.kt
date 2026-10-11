package com.mahrous.demo_app.features.rx_upload.domain.model

import com.mahrous.demo_app.core.app.AppPreferences
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateFCMToken(
    val language: String = AppPreferences.getLocale(),

    )