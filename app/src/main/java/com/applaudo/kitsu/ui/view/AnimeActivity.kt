package com.applaudo.kitsu.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.applaudo.kitsu.R
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.databinding.ActivityAnimeBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class AnimeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anime: Anime? = intent.getParcelableExtra("anime")

        //Check Years
        val endYear = anime?.attributes?.endDate ?: ""
        val startYear = anime?.attributes?.startDate ?: ""

        var startDateYear = ""
        var endDateYear = ""
        val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        if(startYear != ""){
            val startDate = LocalDate.parse(startYear, firstApiFormat)
            startDateYear = startDate.year.toString()
        }

        if(endYear != ""){
            val endDate = LocalDate.parse(endYear, firstApiFormat)
            endDateYear = endDate.year.toString()
        }

        //Check Nullables on Titles
        val title = anime?.attributes?.titles?.en  ?: anime?.attributes?.titles?.enJp ?: anime?.attributes?.titles?.jaJp ?: anime?.attributes?.canonicalTitle

        //Check Status
        if(anime?.attributes?.status == "finished")
            binding.tvStatus.setTextColor(ContextCompat.getColor(applicationContext, R.color.status_finished))

        //Biding Data
        binding.tvCanonicalTitle.text = anime?.attributes?.canonicalTitle
        binding.tvMainTitle.text = title
        binding.tvType.text = anime?.type?.capitalize()
        binding.tvYear.text = "$startDateYear - $endDateYear"

        binding.tvRating.text = anime?.attributes?.averageRating

        binding.tvAgeRating.text = anime?.attributes?.ageRatingGuide
        binding.tvDuration.text = anime?.attributes?.episodeLength.toString() + " min."
        binding.tvStatus.text = anime?.attributes?.status?.capitalize()
        binding.tvSynopsis.text = anime?.attributes?.synopsis

        Picasso.get().load(anime?.attributes?.posterImage?.medium).into(binding.ivAnime)

        //Buttons
        val videoId = anime?.attributes?.youtubeVideoId
        binding.btnYoutube.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.youtube.com/watch?v=$videoId")
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)
        }

        val shareSlug = anime?.attributes?.slug ?: anime?.id
        binding.btnShare.setOnClickListener { view ->

            Log.e("TEST SEND: ", anime?.attributes?.slug ?: "VACIO")
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Kitsu App")
                var shareMessage = "\nLet me recommend you this anime:\n\n"
                shareMessage = """
                    ${shareMessage}https://kitsu.io/anime/${shareSlug}
                    
                    
                    """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }

    }
}