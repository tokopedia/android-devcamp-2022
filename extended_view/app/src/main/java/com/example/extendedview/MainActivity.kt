package com.example.extendedview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.extendedview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * TO-DO : Implement view binding
     */
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}