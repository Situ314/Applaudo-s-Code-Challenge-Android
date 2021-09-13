package com.applaudo.kitsu.domain

import com.applaudo.kitsu.data.AnimeRepository
import com.applaudo.kitsu.data.model.AnimesResponse

class GetAnimesUseCase(title: String) {
    private val repository = AnimeRepository()
    private val title :String = title
    suspend operator fun invoke(): AnimesResponse? = repository.getAnimes(title)

 }