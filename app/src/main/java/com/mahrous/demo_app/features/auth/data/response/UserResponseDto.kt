package com.mahrous.demo_app.features.auth.data.response

import com.google.gson.annotations.SerializedName

data class UserResponseDto(

    val id: Int,

    val email: String,

    @SerializedName("full_name")
    val fullName: String,

    val phoneNumber: String?,

    val avatar: String?,

    val language: String,

    val role: String,

    @SerializedName("notifications_enabled")
    val notificationsEnabled: Boolean,

    @SerializedName("is_active")
    val isActive: Boolean,

    @SerializedName("date_joined")
    val dateJoined: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("token_type")
    val tokenType: String,

    @SerializedName("expires_at")
    val expiresAt: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("refresh_expires_at")
    val refreshExpiresAt: String
)
