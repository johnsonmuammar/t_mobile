package com.example.t_mobile.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Title(
    @Json(name = "attributes")
    val attributes: AttributesXX?,
    @Json(name = "value")
    val value: String?
) : Parcelable