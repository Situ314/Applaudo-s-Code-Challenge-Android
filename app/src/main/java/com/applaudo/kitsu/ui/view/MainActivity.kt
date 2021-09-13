package com.applaudo.kitsu.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.applaudo.kitsu.data.model.Category
import com.applaudo.kitsu.databinding.ActivityMainBinding
import com.applaudo.kitsu.ui.viewmodel.CategoryViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var categoryAdapter: CategoryAdapter


    lateinit var categoriesList: List<Category>

    private val categoryViewModel: CategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryViewModel.onCreate()

        categoryViewModel.categoryModel.observe(this, Observer {
            categoryAdapter = CategoryAdapter(it!!.data, it!!.anime, applicationContext)
            binding.rvCategories.setHasFixedSize(true)
            binding.rvCategories.layoutManager = LinearLayoutManager(this)
            binding.rvCategories.adapter = categoryAdapter
        })

        categoryViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

    }
}