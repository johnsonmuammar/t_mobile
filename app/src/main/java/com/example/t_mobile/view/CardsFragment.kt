package com.example.t_mobile.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t_mobile.R
import com.example.t_mobile.adapters.CardsAdapter
import com.example.t_mobile.databinding.FragmentCardsBinding

class CardsFragment : Fragment(R.layout.fragment_cards) {
    private val args: CardsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentCardsBinding.bind(view).apply {
            with(cardRv) {
                layoutManager = LinearLayoutManager(context)
                adapter = CardsAdapter(args.cards.toList())
            }
        }

    }
}