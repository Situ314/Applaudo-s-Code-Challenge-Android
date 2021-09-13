package com.applaudo.kitsu.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applaudo.kitsu.R
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.databinding.ActivityAnimeBinding
import com.applaudo.kitsu.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class AnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anime: Anime? = intent.getParcelableExtra("anime")

        binding.tvCanonicalTitle.text = anime?.attributes?.canonicalTitle
        binding.tvMainTitle.text = anime?.attributes?.titles?.en
        binding.tvType.text = anime?.type
        binding.tvYear.text = anime?.attributes?.startDate + " - " + anime?.attributes?.endDate

        binding.tvRating.text = anime?.attributes?.averageRating

        binding.tvAgeRating.text = anime?.attributes?.ageRatingGuide
        binding.tvDuration.text = anime?.attributes?.episodeLength.toString() + " min"
        binding.tvStatus.text = anime?.attributes?.status
        binding.tvSynopsis.text = anime?.attributes?.synopsis


        Picasso.get().load(anime?.attributes?.posterImage?.medium).into(binding.ivAnime)
    }
}