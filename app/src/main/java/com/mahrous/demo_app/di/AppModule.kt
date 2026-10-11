package com.mahrous.demo_app.di
import com.mahrous.demo_app.api.DemoAppApi

import com.mahrous.demo_app.core.network.CheckInternet
import com.mahrous.demo_app.features.auth.data.data_source.AuthRemoteDataSource
import com.mahrous.demo_app.features.auth.data.data_source.AuthRemoteDataSourceImpl
import com.mahrous.demo_app.features.auth.data.repository.AuthRepositoryImpl
import com.mahrous.demo_app.features.auth.domain.repository.AuthRepository
import com.mahrous.demo_app.features.categories.data.data_source.CategoriesRemoteDataSource
import com.mahrous.demo_app.features.categories.data.data_source.CategoriesRemoteDataSourceImpl
import com.mahrous.demo_app.features.categories.data.repository.CategoriesRepositoryImpl
import com.mahrous.demo_app.features.categories.domain.repository.CategoriesRepository
import com.mahrous.demo_app.features.home.data.data_source.HomeRemoteDataSource
import com.mahrous.demo_app.features.home.data.data_source.HomeRemoteDataSourceImpl
import com.mahrous.demo_app.features.home.data.repository.HomeRepositoryImpl
import com.mahrous.demo_app.features.home.domain.repository.HomeRepository
import com.mahrous.demo_app.features.profile.data.data_source.ProfileRemoteDataSource
import com.mahrous.demo_app.features.profile.data.data_source.ProfileRemoteDataSourceImpl
import com.mahrous.demo_app.features.profile.data.repository.ProfileRepositoryImpl
import com.mahrous.demo_app.features.profile.domain.repository.ProfileRepository
import com.mahrous.demo_app.features.rx_upload.data.data_source.RxUploadRemoteDataSource
import com.mahrous.demo_app.features.rx_upload.data.data_source.RxUploadRemoteDataSourceImpl
import com.mahrous.demo_app.features.rx_upload.data.repository.RxUploadRepositoryImpl
import com.mahrous.demo_app.features.rx_upload.domain.repository.RxUploadRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Singleton
    @Provides
    fun providesAuthRemoteDataSource(
        api: DemoAppApi,
    ): AuthRemoteDataSource {
        return AuthRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        checkInternet: CheckInternet
    ): AuthRepository {
        return AuthRepositoryImpl(authRemoteDataSource, checkInternet)
    }


}






@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Singleton
    @Provides
    fun providesHomeRemoteDataSource(
        api: DemoAppApi,
    ): HomeRemoteDataSource {
        return HomeRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesHomeRepository(
        homeRemoteDataSource: HomeRemoteDataSource,
        checkInternet: CheckInternet
    ): HomeRepository {
        return HomeRepositoryImpl(homeRemoteDataSource, checkInternet)
    }


}



@Module
@InstallIn(SingletonComponent::class)
object CategoriesModule {
    @Singleton
    @Provides
    fun providesCategoriesRemoteDataSource(
        api: DemoAppApi,
    ): CategoriesRemoteDataSource {
        return CategoriesRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        checkInternet: CheckInternet
    ): CategoriesRepository {
        return CategoriesRepositoryImpl(categoriesRemoteDataSource, checkInternet)
    }


}



@Module
@InstallIn(SingletonComponent::class)
object RxUploadModule {
    @Singleton
    @Provides
    fun providesRxUploadRemoteDataSource(
        api: DemoAppApi,
    ): RxUploadRemoteDataSource {
        return RxUploadRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesRxUploadRepository(
        rxUploadRemoteDataSource: RxUploadRemoteDataSource,
        checkInternet: CheckInternet
    ): RxUploadRepository {
        return RxUploadRepositoryImpl(rxUploadRemoteDataSource, checkInternet)
    }


}



@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {
    @Singleton
    @Provides
    fun providesProfileRemoteDataSource(
        api: DemoAppApi,
    ): ProfileRemoteDataSource {
        return ProfileRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesProfileRepository(
        profileRemoteDataSource: ProfileRemoteDataSource,
        checkInternet: CheckInternet
    ): ProfileRepository {
        return ProfileRepositoryImpl(profileRemoteDataSource, checkInternet)
    }


}










