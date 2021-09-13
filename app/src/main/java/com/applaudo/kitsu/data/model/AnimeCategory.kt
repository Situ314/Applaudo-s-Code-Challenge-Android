package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class AnimeCategory (

    @SerializedName("data") var anime_data : List<AnimeData>,

)