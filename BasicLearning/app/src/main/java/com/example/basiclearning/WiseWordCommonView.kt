package com.example.basiclearning

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.cardview.widget.CardView

class WiseWordCommonView: CardView {

    constructor(context: Context): super(context)

    constructor(
        context: Context,
        attrs: AttributeSet
    ) : super(
        context,
        attrs
    ) {
        obtainAttributes(
            context = context,
            attrs = attrs,
            defStyleAttrs = 0
        )
    }

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttrs: Int
    ) : super(
        context,
        attrs,
        defStyleAttrs
    ) {
        obtainAttributes(
            context = context,
            attrs = attrs,
            defStyleAttrs = defStyleAttrs
        )
    }

    private var tvDescription: TextView

    private var tvName: TextView

    init {
        inflate(context, R.layout.layout_wise_word_view_layout, this)
        tvDescription = findViewById(R.id.tv_description)
        tvName = findViewById(R.id.tv_name)
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
            R.styleable.WiseWordCommonView,
            defStyleAttrs,
            R.style.Theme_BasicLearning
        ).apply {
            try {
                tvDescription.text = getString(R.styleable.WiseWordCommonView_textDescription)
                tvName.text = getString(R.styleable.WiseWordCommonView_textName)
            } finally {
                recycle()
            }
        }
    }

}