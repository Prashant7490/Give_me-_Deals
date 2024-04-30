package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.give_me_deals.databinding.ActivityFiltersBinding
import com.google.android.material.slider.Slider

class FiltersActivity : AppCompatActivity() {
    lateinit var binding: ActivityFiltersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.PriceSlider.addOnChangeListener { slider, value, fromUser ->
            binding.TVPriceRange.text = "$${value.toInt()}"
        }
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.Red)




    }
}