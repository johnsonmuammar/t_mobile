package com.example.t_mobile.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "size")
    val size: Size?,
    @Json(name = "url")
    val url: String?
) : Parcelable