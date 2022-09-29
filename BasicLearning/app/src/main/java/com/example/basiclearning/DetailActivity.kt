package com.example.basiclearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basiclearning.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.extras?.getString(MainActivity.EXTRA_NAME)
        val description = intent.extras?.getString(MainActivity.EXTRA_DETAIL)

        binding.tvName.text = name
        binding.tvDescription.text = description
    }
}