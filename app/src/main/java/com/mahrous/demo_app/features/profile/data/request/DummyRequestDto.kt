package com.mahrous.demo_app.features.profile.data.request

import com.mahrous.demo_app.core.app.AppPreferences
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DummyRequestDto(
    val device: String="android",

    )