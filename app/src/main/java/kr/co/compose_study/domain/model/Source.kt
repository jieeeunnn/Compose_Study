package kr.co.compose_study.domain.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Source(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String
): Parcelable