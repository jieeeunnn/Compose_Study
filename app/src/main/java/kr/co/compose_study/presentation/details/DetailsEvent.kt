package kr.co.compose_study.presentation.details

sealed class DetailsEvent {
    data object SaveArticle: DetailsEvent()
}