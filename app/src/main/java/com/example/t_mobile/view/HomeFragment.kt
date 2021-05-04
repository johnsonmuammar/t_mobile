package com.example.t_mobile.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.t_mobile.R
import com.example.t_mobile.databinding.FragmentHomeBinding
import com.example.t_mobile.util.ApiState
import com.example.t_mobile.viewModel.MainViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val TAG = "HomeFragment"
    private val mainVM by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentHomeBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            homeViewModel = mainVM
        }
        mainVM.apiState.observe(viewLifecycleOwner) { response ->
            Log.d(TAG, "onViewCreated: api response = $response")
            if (response is ApiState.Success) {
                Log.d(TAG, "onViewCreated: api success")

                val action = response.cards?.let {
                    HomeFragmentDirections.actionHomeFragmentToCardsFragment(
                        it.toTypedArray()
                    )
                }
                if (action != null) {
                    findNavController().navigate(action)
                }
                mainVM.toggleCompletedState()
            }
        }
    }
}