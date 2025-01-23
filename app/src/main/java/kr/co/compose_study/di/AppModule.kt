package kr.co.compose_study.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.compose_study.data.manager.LocalUserManagerImpl
import kr.co.compose_study.domain.manager.LocalUserManager
import kr.co.compose_study.domain.usecase.AppEntryUseCases
import kr.co.compose_study.domain.usecase.ReadAppEntry
import kr.co.compose_study.domain.usecase.SaveAppEntry
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}