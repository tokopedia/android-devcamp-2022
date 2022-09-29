package com.example.basiclearning

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat


@SuppressLint("ClickableViewAccessibility")
class ButtonView: View {

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
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        obtainAttributes(
            context = context,
            attrs = attrs,
            defStyleAttrs = defStyleAttr
        )
    }

    private var paintButtonShape: Paint = Paint().apply {
        style = Paint.Style.FILL
    }

    private var paintText: Paint = Paint().apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 50f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            typeface = Typeface.create(resources.getFont(R.font.abeezee), Typeface.BOLD)
        }
    }

    private var pathRoundedCorner: Path = Path()
    private var rect = RectF()

    var buttonText: String = ""
        set(value) {
             field = value
             invalidate()
             requestLayout()
        }

    var buttonColor: Int = Color.GRAY
        set(value) {
            field = value
            paintButtonShape.color = field
            invalidate()
            requestLayout()
        }

    var buttonTextColor: Int = ContextCompat.getColor(context, R.color.teal_200)
        set(value) {
            field = value
            paintText.color = field
            invalidate()
            requestLayout()
        }

    var onClickListener: () -> Unit = {}

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (isEnabled) {
            if(event.action == MotionEvent.ACTION_UP) {
                buttonColor = ContextCompat.getColor(context, R.color.teal_200)
            } else if(event.action == MotionEvent.ACTION_DOWN) {
                buttonColor = Color.BLUE
                onClickListener.invoke()
            }
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        val corners = floatArrayOf(
            80f, 80f,   // Top left radius in px
            80f, 80f,   // Top right radius in px
            0f, 0f,     // Bottom right radius in px
            0f, 0f      // Bottom left radius in px
        )
        pathRoundedCorner.addRoundRect(rect, corners, Path.Direction.CW)
        canvas.drawPath(pathRoundedCorner, paintButtonShape)
        val xPos = (width / 2).toFloat()
        val yPos = (height / 2 - (paintText.descent() + paintText.ascent()) / 2)
        //((textPaint.descent() + textPaint.ascent()) / 2) is the distance from the baseline to the center.
        canvas.drawText(buttonText, xPos, yPos, paintText)
        canvas.restore()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 100
        val desiredHeight = 100

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int = when (widthMode) {
            MeasureSpec.EXACTLY -> {
                widthSize
            }
            MeasureSpec.AT_MOST -> {
                Math.min(desiredWidth, widthSize)
            }
            else -> {
                desiredWidth
            }
        }

        val height: Int = when (heightMode) {
            MeasureSpec.EXACTLY -> {
                heightSize
            }
            MeasureSpec.AT_MOST -> {
                Math.min(desiredHeight, heightSize)
            }
            else -> {
                desiredHeight
            }
        }

        rect.set(0f, 0f, width.toFloat(), height.toFloat())
        setMeasuredDimension(width, height)
    }

    private fun obtainAttributes(context: Context, attrs: AttributeSet, defStyleAttrs: Int) {
        context.obtainStyledAttributes(
            attrs,
            R.styleable.ButtonView,
            defStyleAttrs,
            R.style.Theme_BasicLearning
        ).apply {
            try {
                buttonText = getString(R.styleable.ButtonView_android_text).toString()
                buttonTextColor = getInt(R.styleable.ButtonView_textColor, Color.BLACK)
                buttonColor = ContextCompat.getColor(context, R.color.teal_200)
            } finally {
                recycle()
            }
        }
    }

}