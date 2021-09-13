package com.applaudo.kitsu.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applaudo.kitsu.R
import com.applaudo.kitsu.data.model.Anime
import com.applaudo.kitsu.data.model.Category
import java.util.*

class CategoryAdapter(
    private val categories: MutableList<Category>,
    private val animes: List<Anime>,
    private val context: Context,
) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflater.inflate(R.layout.category_item, parent, false))

    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categories[position]
        var animeNew = mutableListOf<Anime>()

        for(anime in animes){
            if(item.relationships.anime_category.anime_data.filter { it.id == anime.id }.size > 0)
                animeNew.add(anime)
        }

        holder.bind(item, animeNew, context)

    }

    override fun getItemCount(): Int {
       return categories.size
    }

    fun clear() {
        val size: Int = categories.size
        categories.clear()
        notifyItemRangeRemoved(0, size)
    }
}