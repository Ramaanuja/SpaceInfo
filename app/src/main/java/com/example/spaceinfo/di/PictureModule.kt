package com.example.spaceinfo.di

import com.example.spaceinfo.datalayer.localdatasource.FakeRoomDataSource
import com.example.spaceinfo.datalayer.localdatasource.RoomDataSource
import com.example.spaceinfo.datalayer.remotedatasource.RemoteDataSource
import com.example.spaceinfo.datalayer.repository.PictureRepositoryImpl
import com.example.spaceinfo.domain.PictureRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object PictureModule {

    @Singleton
    @Provides
    fun provideRoomDataSource(): RoomDataSource {
        return FakeRoomDataSource()
    }

    @Singleton
    @Provides
    fun providePictureRepository(dataSource: RemoteDataSource, localDataSource: RoomDataSource): PictureRepository {
        return PictureRepositoryImpl(dataSource, localDataSource)
    }
}