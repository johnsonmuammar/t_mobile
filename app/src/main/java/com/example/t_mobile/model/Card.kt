package com.example.t_mobile.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Card(
    @Json(name = "card")
    val card: CardX?,
    @Json(name = "card_type")
    val cardType: String?
) : Parcelable