package com.mahrous.demo_app.features.categories.data.data_source



import com.mahrous.demo_app.api.DemoAppApi
import javax.inject.Inject

class CategoriesRemoteDataSourceImpl @Inject constructor(
    private val api: DemoAppApi
) : CategoriesRemoteDataSource {


}