package com.noke.zendevchallenge.di

import com.noke.zendevchallenge.data.remote.NetworkClient
import com.noke.zendevchallenge.data.remote.PostApiService
import com.noke.zendevchallenge.data.remote.PostRemoteDataSource
import com.noke.zendevchallenge.data.remote.PostRemoteDataSourceImpl
import com.noke.zendevchallenge.data.repository.PostRepositoryImpl
import com.noke.zendevchallenge.domain.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostModule {

    @Provides
    @Singleton
    fun provideApiService(): PostApiService {
        return NetworkClient.postsApiService
    }

    @Provides
    @Singleton
    fun providePostRemoteDataSource(
        postRemoteDataSourceImpl: PostRemoteDataSourceImpl
    ): PostRemoteDataSource {
        return postRemoteDataSourceImpl
    }

    @Provides
    @Singleton
    fun providePostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository {
        return postRepositoryImpl
    }
}