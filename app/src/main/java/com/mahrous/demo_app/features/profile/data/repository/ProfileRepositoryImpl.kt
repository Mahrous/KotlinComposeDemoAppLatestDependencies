package com.mahrous.demo_app.features.profile.data.repository

import com.mahrous.demo_app.core.network.CheckInternet

import com.mahrous.demo_app.features.profile.data.data_source.ProfileRemoteDataSource
import com.mahrous.demo_app.features.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileRemoteDataSource: ProfileRemoteDataSource,
    private val checkInternet: CheckInternet,
) : ProfileRepository {



}
