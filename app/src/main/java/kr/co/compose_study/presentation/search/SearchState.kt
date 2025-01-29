package kr.co.compose_study.presentation.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.compose_study.domain.model.Article

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)