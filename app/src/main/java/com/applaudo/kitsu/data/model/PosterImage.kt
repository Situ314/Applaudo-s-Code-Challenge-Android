package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class PosterImage (

    @SerializedName("tiny") var tiny : String,
    @SerializedName("small") var small : String,
    @SerializedName("medium") var medium : String,
    @SerializedName("large") var large : String,
    @SerializedName("original") var original : String,
    @SerializedName("meta") var meta : Meta

)