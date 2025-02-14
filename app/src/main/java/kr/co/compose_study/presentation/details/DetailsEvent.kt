package kr.co.compose_study.presentation.details

import kr.co.compose_study.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()
    data object RemoveSideEffect: DetailsEvent()
}