package com.mahrous.demo_app.di

import android.annotation.SuppressLint
import com.mahrous.demo_app.api.DemoAppApi
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import javax.inject.Provider
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().build()

    @Singleton
    @Provides
    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    val language = AppPreferences.getLocale()
                    builder.header("Accept-Language", language)
                    return@Interceptor chain.proceed(builder.build())
                }
            )
//            .addInterceptor(authInterceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Named("App")
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            //.addConverterFactory(.create(moshi))
            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun providesIntegrateApi(@Named("App") retrofit: Retrofit): DemoAppApi =
        retrofit.create(DemoAppApi::class.java)




}


class AuthInterceptor @Inject constructor(
    private val DemoAppApiProvider: Provider<DemoAppApi>
) : Interceptor {
    @SuppressLint("SuspiciousIndentation")
    override fun intercept(chain: Interceptor.Chain): Response {

        val api = DemoAppApiProvider.get()
        val language = AppPreferences.getLocale()
        val originalRequest = chain.request()
        val accessToken = "AppPreferences.getCurrentToken()"
        originalRequest.url


        val response = chain.proceed(originalRequest)

//        if (response.code == 401 &&  AppPreferences.getCurrentUser()!=null ) {
//            Log.e("TAG22", "${response.code}")
//            val refreshToken = AppPreferences.getCurrentUser()!!.refreshToken
//            I_AM_IN_REFRESH_TOKEN = true
//            // Make the token refresh request
//            val refreshedToken = runBlocking {
//                val response = api.refreshTokenChecker(RefreshTokenRequestDto(refreshToken))
//                // Update the refreshed access token and its expiration time in the session
//                if (response.data != null) {
//                    AppPreferences.storeCurrentToken(response.data.token)
//                    AppPreferences.getCurrentUser()!!.copy(token = response.data.token)
//                    response.data.token
//                } else {
//                    null
//                }
//            }
//
//            response.close()
//
//
//
//            if (refreshedToken == null){
//                GlobalAppState.setForcedLogout(true)
//                Log.e("TAG", "intercept: refreshedToken = null and $${IS_FORCED_LOGE_OUT} ", )
//
//            } else {
//                GlobalAppState.reset()
//                Log.e("TAG", "intercept: refreshedToken = ${refreshedToken} & \n $${IS_FORCED_LOGE_OUT} ", )
//
//            }
//
//            Log.e("TAG", "intercept: iam before new request ", )
//            if (refreshedToken != null) {
//                Log.e("TAG", "intercept: iam at new request before bug ", )
//                // Create a new request with the refreshed access token
//                val newRequest = originalRequest.newBuilder()
//                    .header("Authorization", "Bearer $refreshedToken")
//                    .header("Accept-Language", language)
//                    .build()
//
//                return chain.proceed(newRequest)
//
//            }
//
//
//        // Add the access token to the request header
//        val authorizedRequest = originalRequest.newBuilder()
//            .header("Authorization", "Bearer $accessToken")
//            .build()
//
//            //builder.header("Accept-Language", language)
//
//        return chain.proceed(authorizedRequest)
//        }
//        else {
////            I_AM_IN_REFRESH_TOKEN = false
//            Log.e("TAG111111111", "2")
            return response
//        }
    }
}









