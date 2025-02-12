package kr.co.compose_study.domain.usecase.news

import kr.co.compose_study.data.local.NewsDao
import kr.co.compose_study.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}