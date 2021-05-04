package com.example.t_mobile.util

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.t_mobile.model.Card
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

@BindingAdapter("app:toggleButtonState")
fun <T> MaterialButton.toggleButtonState(state: ApiState<T>?) {
    val isLoading = state is ApiState.Loading
    isEnabled = isLoading.not()
}

@BindingAdapter("app:toggleProgressState")
fun <T> ProgressBar.toggleProgressState(state: ApiState<T>?) {
    visibility = if (state is ApiState.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("app:loadImg")
fun ImageView.loadImg(url: String?) {
    Glide.with(context).load(url).into(this)
}

enum class CardType {
    TITLE, DESCRIPTION
}

@BindingAdapter(value = ["app:card", "app:type"])
fun MaterialTextView.init(card: Card?, type: CardType) {
    when (type) {
        CardType.TITLE -> {
            when (card?.cardType) {
                "text" -> {
                    val attributes = card.card?.attributes
                    setProperties(
                            card.card?.value, attributes?.textColor, attributes?.font?.size?.toFloat()
                    )
                }
                else -> {
                    val attributes = card?.card?.title?.attributes
                    setProperties(
                            card?.card?.title?.value, attributes?.textColor,
                            attributes?.font?.size?.toFloat()
                    )
                }
            }
        }
        CardType.DESCRIPTION -> {
            val attributes = card?.card?.description?.attributes
            setProperties(
                    card?.card?.description?.value, attributes?.textColor,
                    attributes?.font?.size?.toFloat()
            )
        }
    }
}

fun MaterialTextView.setProperties(
        cardValue: String?,
        cardTextColor: String?,
        cardFontSize: Float?
) {
    cardValue?.let { text = it }
    cardTextColor?.let { setTextColor(Color.parseColor(it)) }
    cardFontSize?.let { textSize = it }
}
