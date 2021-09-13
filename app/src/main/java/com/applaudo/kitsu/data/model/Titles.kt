package com.applaudo.kitsu.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Titles (

    @SerializedName("en") var en : String?,
    @SerializedName("en_jp") var enJp : String?,
    @SerializedName("ja_jp") var jaJp : String

) : Parcelable