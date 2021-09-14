package com.applaudo.kitsu.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaudo.kitsu.data.model.CategoriesResponse
import com.applaudo.kitsu.domain.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase:GetCategoriesUseCase,
) : ViewModel() {
    val categoryModel = MutableLiveData<CategoriesResponse?>()
    val isLoading = MutableLiveData<Boolean>()
    val isFailing = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            try{
                isFailing.postValue(false)
                isLoading.postValue(true)
                val result = getCategoriesUseCase()
                categoryModel.postValue(result)
                isLoading.postValue(false)
            }catch(e: Exception) {
                isLoading.postValue(false)
                isFailing.postValue(true)
                Log.e("Error", e.message.toString())
            }
        }
    }
}