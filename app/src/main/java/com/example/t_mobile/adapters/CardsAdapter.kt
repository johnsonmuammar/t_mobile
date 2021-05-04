package com.example.t_mobile.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t_mobile.databinding.CardItemBinding
import com.example.t_mobile.model.Card

class CardsAdapter(
    private val results: List<Card>
) : RecyclerView.Adapter<CardsAdapter.TrackViewHolder>() {
    private val TAG = "CardsAdapter"

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = TrackViewHolder(
        CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(
        holder: TrackViewHolder, position: Int
    ) = with(holder.binding) {
        Glide.with(image.context)
            .load(results[position].card?.image?.url.toString())
            .into(image)
        card = results[position]


    }

    override fun getItemCount() = results.size


    class TrackViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)
}