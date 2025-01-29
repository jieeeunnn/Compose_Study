package kr.co.compose_study.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kr.co.compose_study.domain.model.Article

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "articles")
    val articles: List<Article>,
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResults: Int
)