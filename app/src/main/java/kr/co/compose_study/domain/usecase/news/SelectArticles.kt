package kr.co.compose_study.domain.usecase.news

import kotlinx.coroutines.flow.Flow
import kr.co.compose_study.data.local.NewsDao
import kr.co.compose_study.domain.model.Article

class SelectArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}