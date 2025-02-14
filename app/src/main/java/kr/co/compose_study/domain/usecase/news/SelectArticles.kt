package kr.co.compose_study.domain.usecase.news

import kotlinx.coroutines.flow.Flow
import kr.co.compose_study.domain.model.Article
import kr.co.compose_study.domain.repository.NewsRepository

class SelectArticles(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}