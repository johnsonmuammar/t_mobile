package com.example.t_mobile.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class AttributesXX(
    @Json(name = "font")
    val font: FontXX?,
    @Json(name = "text_color")
    val textColor: String?
) : Parcelable