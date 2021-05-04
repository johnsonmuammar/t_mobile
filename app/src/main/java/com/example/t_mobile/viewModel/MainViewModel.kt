package com.example.t_mobile.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_mobile.model.Card
import com.example.t_mobile.model.TmobileResponse
import com.example.t_mobile.repo.TmobileRepo
import com.example.t_mobile.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    private val TAG = "MainViewModel"
    private val _apiState = MutableLiveData<ApiState<List<Card>?>>()
    val apiState: LiveData<ApiState<List<Card>?>>
        get() = _apiState

    fun getResponse() {
        _apiState.postValue(ApiState.Loading)
        try {
            viewModelScope.launch(Dispatchers.IO) {
                _apiState.postValue(ApiState.Loading)
                val tmobileResponse: TmobileResponse? = TmobileRepo.getTmobileResponse()
                if (tmobileResponse != null) {
                    _apiState.postValue(ApiState.Success(tmobileResponse.page?.cards))
                }
            }
        } catch (e: Exception) {
            ApiState.Error("Network error, please try again.")
        }
    }

    fun toggleCompletedState() {
        _apiState.value = ApiState.Completed
    }
}