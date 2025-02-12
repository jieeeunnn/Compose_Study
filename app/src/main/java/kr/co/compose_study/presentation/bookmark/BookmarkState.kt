package kr.co.compose_study.presentation.bookmark

import kr.co.compose_study.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)