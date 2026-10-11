package com.mahrous.demo_app.features.rx_upload.data.request

import com.mahrous.demo_app.core.app.AppPreferences
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateFCMTokenRequestDto(
    val fcm_token: String = AppPreferences.getCurrentFCMToken(),
    val device: String="android",
    val language: String = AppPreferences.getLocale(),

    )