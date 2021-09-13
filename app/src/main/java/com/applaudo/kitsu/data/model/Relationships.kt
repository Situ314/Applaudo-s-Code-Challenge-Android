package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class Relationships (

    @SerializedName("anime") var anime_category : AnimeCategory,

)