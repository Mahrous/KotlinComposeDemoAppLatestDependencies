package com.mahrous.demo_app.features.rx_upload.data.data_source



import com.mahrous.demo_app.api.DemoAppApi
import javax.inject.Inject

class RxUploadRemoteDataSourceImpl @Inject constructor(
    private val api: DemoAppApi
) : RxUploadRemoteDataSource {


}