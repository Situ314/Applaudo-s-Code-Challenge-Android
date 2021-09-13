package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class Links (

    @SerializedName("first") var first : String,
    @SerializedName("next") var next : String,
    @SerializedName("last") var last : String

)