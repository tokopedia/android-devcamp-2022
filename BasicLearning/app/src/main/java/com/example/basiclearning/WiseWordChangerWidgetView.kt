package com.example.basiclearning

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.basiclearning.databinding.LayoutWiseWordViewWidgetLayoutBinding
import java.util.Random

class WiseWordChangerWidgetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var binding: LayoutWiseWordViewWidgetLayoutBinding
    private var listWiseWord = listOf(
        WiseWordChangerWidgetUiModel(
            name = "Catherine Pulsifer",
            description = "When looking for wise words, the best ones often come from our elders."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Rick Warren",
            description = "You've heard that it's wise to learn from experience, but it is wiser to learn from the experience of others."
        ),
        WiseWordChangerWidgetUiModel(
            name = "John C. Maxwell",
            description = "We tend to think of great thinkers and innovators as soloists, but the truth is that the greatest innovative thinking doesn't occur in a vacuum. Innovation results from collaboration."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Hermann Hesse",
            description = "Some of us think holding on makes us strong, but sometimes it is letting go."
        ),
        WiseWordChangerWidgetUiModel(
            name = "James Prescott",
            description = "But what I've discovered over time is that some of the wisest people I know have also been some of the most broken people."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Paulo Coelho",
            description = "Don't waste your time with explanations, people only hear what they want to hear."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Les Brown",
            description = "Each of us experiences defeats in life. We can transform defeat into victory if we learn from life’s whuppings."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Audrey Hepburn",
            description = "Nothing is impossible, the word itself says 'I'm possible'!"
        ),
        WiseWordChangerWidgetUiModel(
            name = "Charles F. Stanley",
            description = "What you do and say lives on in the hearts and minds of others, to some degree, with a definite result or consequence."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Neal A. Maxwell",
            description = "Faith in God includes faith in God's timing."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Dave Marcum",
            description = "If we manage ego wisely, we get the upside it delivers followed by strong returns."
        ),
        WiseWordChangerWidgetUiModel(
            name = "Lori Hill",
            description = "For me, a sense of prosperity often comes with less rather than more."
        )
    )

    init {
        binding = LayoutWiseWordViewWidgetLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        var wise = listWiseWord.first()
        setWiseWord(wise)

        val random = Random()
        binding.customvButton.onClickListener = {
            wise = listWiseWord[random.nextInt(listWiseWord.size)]
            setWiseWord(wise)
        }
    }

    private fun setWiseWord(wiseWord: WiseWordChangerWidgetUiModel) {
        binding.customvWiseWord.textName = wiseWord.name
        binding.customvWiseWord.textDescription = wiseWord.description
    }
}
