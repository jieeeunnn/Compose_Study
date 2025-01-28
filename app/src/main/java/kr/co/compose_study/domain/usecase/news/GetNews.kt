package kr.co.compose_study.domain.usecase.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.compose_study.domain.model.Article
import kr.co.compose_study.domain.repository.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>>{
        return newsRepository.getNews(sources = sources)
    }
}