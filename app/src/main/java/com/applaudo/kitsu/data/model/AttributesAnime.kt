package com.applaudo.kitsu.data.model

import com.google.gson.annotations.SerializedName

data class AttributesAnime (
    @SerializedName("canonicalTitle") var canonicalTitle : String,
    @SerializedName("synopsis") var synopsis : String,
    @SerializedName("titles") var titles : Titles,
    @SerializedName("youtubeVideoId") var youtubeVideoId : String,
    @SerializedName("showType") var showType : String,
    @SerializedName("episodeCount") var episodeCount : Int,
    @SerializedName("posterImage") var posterImage : PosterImage,
    @SerializedName("startDate") var startDate : String,
    @SerializedName("endDate") var endDate : String,
    @SerializedName("ageRatingGuide") var ageRatingGuide : String,
    @SerializedName("averageRating") var averageRating : String,
    @SerializedName("episodeLength") var episodeLength : Int,
    @SerializedName("status") var status : String
)