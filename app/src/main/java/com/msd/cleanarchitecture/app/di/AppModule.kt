
package com.msd.cleanarchitecture.app.di

import com.msd.cleanarchitecture.data.api.AnimalApi
import com.msd.cleanarchitecture.data.repo.AnimalRepo
import com.msd.cleanarchitecture.data.repo.AnimalRepoImpl
import com.msd.cleanarchitecture.domain.usecase.GetAnimalsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://example.com/") // replace with your API base URL
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): AnimalApi = retrofit.create(AnimalApi::class.java)

    @Provides
    @Singleton
    fun provideRepo(api: AnimalApi): AnimalRepo = AnimalRepoImpl(api)

    @Provides
    @Singleton
    fun provideGetAnimalsUseCase(repo: AnimalRepo) = GetAnimalsUseCase(repo)
}
