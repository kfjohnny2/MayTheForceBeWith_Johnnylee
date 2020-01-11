package com.example.maytheforcebewith_johnnylee.injection.module

import com.example.maytheforcebewith_johnnylee.BuildConfig
import com.example.maytheforcebewith_johnnylee.BuildConfig.API_URL
import com.example.maytheforcebewith_johnnylee.network.PeopleApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {
    /**
     * Provides the PeopleApi service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the PeopleApi service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePeopleApi(retrofit: Retrofit): PeopleApi {
        return retrofit.create(PeopleApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
//        val header =
//            Interceptor { it.proceed(it.request().newBuilder().addHeader("Authorization", getAccessToken()!!).build()) }
        val httpClient = OkHttpClient.Builder()

        httpClient.readTimeout(230, TimeUnit.SECONDS)
        httpClient.connectTimeout(230, TimeUnit.SECONDS)

        //INTERCEPTORS
        if (BuildConfig.DEBUG){
            httpClient.addInterceptor(logging)
        }

//        httpClient.addInterceptor(header)

//        val tokenApi =
//            retrofit2.Retrofit.Builder().baseUrl(IDENTITY_URL).addConverterFactory(GsonConverterFactory.create(gson))
//                .client(httpClient.build()).build().create(TokenApi::class.java)
//
//        httpClient.authenticator(TokenAuthenticator(tokenApi))

        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}