package com.mahrous.demo_app.features.profile.data.data_source



import com.mahrous.demo_app.api.DemoAppApi
import javax.inject.Inject

class ProfileRemoteDataSourceImpl @Inject constructor(
    private val api: DemoAppApi
) : ProfileRemoteDataSource {


}