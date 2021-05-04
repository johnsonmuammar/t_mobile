package com.example.t_mobile.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Size(
    @Json(name = "height")
    val height: Int?,
    @Json(name = "width")
    val width: Int?
) : Parcelable