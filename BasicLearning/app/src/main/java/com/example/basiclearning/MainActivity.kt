package com.example.basiclearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basiclearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
    * Task 1: Implement view binding
    **/
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}