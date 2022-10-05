package com.tkpd.devcamp2022.day4.custom_view_animation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import com.tkpd.devcamp2022.databinding.ActivityAnimationViewBinding

class AnimationViewActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_DETAIL = "detail"
    }

    lateinit var binding: ActivityAnimationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.customvWireWord.onWiseWordClickListener = {
//            val intent = Intent(this, CustomViewAnimationDetailActivity::class.java)
//            intent.putExtra(EXTRA_NAME, it.name)
//            intent.putExtra(EXTRA_DETAIL, it.description)
//
//            val optionsCompat: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                this,
//                androidx.core.util.Pair(binding.customvWireWord.tvNameWiseWord, "name"),
//                androidx.core.util.Pair(binding.customvWireWord.tvDescriptionWiseWord, "description")
//            )
//            startActivity(intent, optionsCompat.toBundle())
////            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle())
//        }
    }
}