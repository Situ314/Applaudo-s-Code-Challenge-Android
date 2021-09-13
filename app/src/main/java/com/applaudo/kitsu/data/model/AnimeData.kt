package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class AnimeData (

    @SerializedName("type") var type : String,
    @SerializedName("id") var id : String,

    )