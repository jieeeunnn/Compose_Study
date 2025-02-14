package kr.co.compose_study.domain.usecase.news

import kr.co.compose_study.domain.model.Article
import kr.co.compose_study.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}