package com.applaudo.kitsu.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AttributesAnime (
    @SerializedName("canonicalTitle") var canonicalTitle : String,
    @SerializedName("synopsis") var synopsis : String?,
    @SerializedName("titles") var titles : Titles?,
    @SerializedName("youtubeVideoId") var youtubeVideoId : String?,
    @SerializedName("showType") var showType : String?,
    @SerializedName("episodeCount") var episodeCount : Int?,
    @SerializedName("slug") var slug : String,
    @SerializedName("posterImage") var posterImage : PosterImage,
    @SerializedName("startDate") var startDate : String?,
    @SerializedName("endDate") var endDate : String?,
    @SerializedName("ageRatingGuide") var ageRatingGuide : String?,
    @SerializedName("averageRating") var averageRating : String?,
    @SerializedName("episodeLength") var episodeLength : Int?,
    @SerializedName("status") var status : String?
) : Parcelable