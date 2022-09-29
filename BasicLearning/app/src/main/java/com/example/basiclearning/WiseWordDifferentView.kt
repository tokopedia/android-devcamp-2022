package com.example.basiclearning

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.basiclearning.databinding.LayoutWiseWordViewLayoutBinding

class WiseWordDifferentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var binding: LayoutWiseWordViewLayoutBinding

    var tvDescription: TextView
    var tvName: TextView

    init {
        binding = LayoutWiseWordViewLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        tvDescription = binding.tvDescription
        tvName = binding.tvName

        if (attrs != null) {
            obtainAttributes(context, attrs, defStyleAttr)
        }
    }

    var textDescription: String
        get() = tvDescription.text.toString()
        set(value) {
            tvDescription.text = value
        }

    var textName: String
        get() = tvName.text.toString()
        set(value) {
            tvName.text = value
        }

    private fun obtainAttributes(context: Context, attrs: AttributeSet, defStyleAttrs: Int) {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.WiseWordDifferentView,
            defStyleAttrs,
            R.style.Theme_BasicLearning
        ).apply {
            try {
                tvDescription.text = getString(R.styleable.WiseWordDifferentView_textDescription)
                tvName.text = getString(R.styleable.WiseWordDifferentView_textName)
            } finally {
                recycle()
            }
        }
    }
}