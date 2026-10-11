package com.mahrous.demo_app.features.auth.data.mapper

import com.mahrous.demo_app.features.auth.data.request.LoginRequestDto
import com.mahrous.demo_app.features.auth.data.response.UserResponseDto
import com.mahrous.demo_app.features.auth.domain.model.Login
import com.mahrous.demo_app.features.auth.domain.model.User

fun LoginRequestDto.mapFromModel() = Login(
    email = this.email,
    password = this.password,
)

fun Login.mapFromDomain() = LoginRequestDto(
    email = this.email,
    password = this.password,

    )



// region User
fun UserResponseDto.mapFromModel() = User(
    id = this.id,
    email = this.email,
    fullName = this.fullName.ifEmpty { "Client Name" },
    phoneNumber = this.phoneNumber,
    avatar = this.avatar.orEmpty(),
    language = this.language,
    role = this.role,
    notificationsEnabled = this.notificationsEnabled,
    isActive = this.isActive,
    dateJoined = this.dateJoined,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    accessToken = this.accessToken,
    tokenType = this.tokenType,
    expiresAt = this.expiresAt,
    refreshToken = this.refreshToken,
    refreshExpiresAt = this.refreshExpiresAt,
)

fun User.mapFromDomain() = UserResponseDto(
    id = this.id,
    email = this.email,
    fullName = this.fullName.ifEmpty { "Client Name" },
    phoneNumber = this.phoneNumber,
    avatar = this.avatar,
    language = this.language,
    role = this.role,
    notificationsEnabled = this.notificationsEnabled,
    isActive = this.isActive,
    dateJoined = this.dateJoined,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    accessToken = this.accessToken,
    tokenType = this.tokenType,
    expiresAt = this.expiresAt,
    refreshToken = this.refreshToken,
    refreshExpiresAt = this.refreshExpiresAt,
)