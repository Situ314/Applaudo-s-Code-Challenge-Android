package com.applaudo.kitsu.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applaudo.kitsu.data.model.AnimesResponse
import com.applaudo.kitsu.data.model.CategoriesResponse
import com.applaudo.kitsu.data.model.QuoteModel
import com.applaudo.kitsu.data.model.CategoryProvider
import com.applaudo.kitsu.domain.GetAnimesUseCase
import com.applaudo.kitsu.domain.GetCategoriesUseCase
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    val categoryModel = MutableLiveData<CategoriesResponse?>()
    val animeModel = MutableLiveData<AnimesResponse?>()
    val isLoading = MutableLiveData<Boolean>()

    var getCategoriesUseCase = GetCategoriesUseCase()
//    var getAnimesUseCase = GetAnimesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getCategoriesUseCase()

            categoryModel.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun getAnimes(category: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            var getAnimesUseCase = GetAnimesUseCase(category)
            val result =  getAnimesUseCase()

            animeModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}