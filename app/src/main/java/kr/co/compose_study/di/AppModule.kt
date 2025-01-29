package kr.co.compose_study.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.compose_study.data.manager.LocalUserManagerImpl
import kr.co.compose_study.data.remote.NewsApi
import kr.co.compose_study.data.repository.NewsRepositoryImpl
import kr.co.compose_study.domain.manager.LocalUserManager
import kr.co.compose_study.domain.repository.NewsRepository
import kr.co.compose_study.domain.usecase.app_entry.AppEntryUseCases
import kr.co.compose_study.domain.usecase.app_entry.ReadAppEntry
import kr.co.compose_study.domain.usecase.app_entry.SaveAppEntry
import kr.co.compose_study.domain.usecase.news.GetNews
import kr.co.compose_study.domain.usecase.news.NewsUseCases
import kr.co.compose_study.domain.usecase.news.SearchNews
import kr.co.compose_study.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImpl(newsApi)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}