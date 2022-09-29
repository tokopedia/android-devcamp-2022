package com.example.basiclearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import com.example.basiclearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_DETAIL = "detail"
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.customvWwActivityTrans.onWiseWordClickListener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_NAME, it.name)
            intent.putExtra(EXTRA_DETAIL, it.description)

            val optionsCompat: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    androidx.core.util.Pair(binding.customvWwActivityTrans.tvNameWiseWord, "name"),
                    androidx.core.util.Pair(binding.customvWwActivityTrans.tvDescriptionWiseWord, "description")
                )
            startActivity(intent, optionsCompat.toBundle())
//            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
        }
    }
}