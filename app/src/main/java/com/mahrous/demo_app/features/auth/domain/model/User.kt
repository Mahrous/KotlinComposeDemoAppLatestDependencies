package com.mahrous.demo_app.features.auth.domain.model

data class User(
    val id: Int,
    val email: String,
    val fullName: String,
    val phoneNumber: String?,
    val avatar: String?,
    val language: String,
    val role: String,
    val notificationsEnabled: Boolean,
    val isActive: Boolean,
    val dateJoined: String,
    val createdAt: String,
    val updatedAt: String,
    val accessToken: String,
    val tokenType: String,
    val expiresAt: String,
    val refreshToken: String,
    val refreshExpiresAt: String

    )