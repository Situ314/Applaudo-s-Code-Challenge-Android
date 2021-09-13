package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName


data class Titles (

    @SerializedName("en") var en : String,
    @SerializedName("en_jp") var enJp : String,
    @SerializedName("ja_jp") var jaJp : String

)