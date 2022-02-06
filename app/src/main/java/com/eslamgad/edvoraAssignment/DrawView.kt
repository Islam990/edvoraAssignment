package com.eslamgad.edvoraAssignment

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    companion object {
        var colorSelected = Color.BLACK
    }

    private val brush = Paint().apply {
        style = Paint.Style.STROKE
        isAntiAlias = true
        strokeJoin = Paint.Join.ROUND
        strokeWidth = 8f
    }

    private val path = Path()


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val pointx = event?.x!!
        val pointy = event?.y!!

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(pointx, pointy)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(pointx, pointy)
            }
        }

        brush.color = colorSelected
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, brush)

    }
}