package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class AnimesResponse (

    @SerializedName("data") var data : List<Anime>,
    @SerializedName("meta") var meta : Meta,
    @SerializedName("links") var links : Links

)