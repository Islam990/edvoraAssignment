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
    private val pointLineList = ArrayList<Point>()
    private var rectList = ArrayList<Rect>()
    private val pointCircleList = ArrayList<Point>()


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val pointx = event?.x!!
        val pointy = event?.y!!

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                when (Common.shape) {

                    shapes.hand -> {
                        path.moveTo(pointx, pointy)
                        return true
                    }

                    shapes.rect -> {
                        rectList.add(
                            Rect().apply {
                                set(
                                    pointx.toInt(), pointy.toInt(), (pointx + 100).toInt(),
                                    (pointy + 50).toInt()
                                )
                            }
                        )

                    }

                    shapes.circle -> {

                        pointCircleList.add(
                            Point().apply {
                                x = pointx.toInt()
                                y = pointy.toInt()
                            }
                        )
                    }

                    shapes.line -> {

                        pointLineList.add(
                            Point().apply {
                                x = pointx.toInt()
                                y = pointy.toInt()
                            }
                        )
                    }
                }
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

        for (rectangle in rectList)
            canvas?.drawRect(rectangle, brush)

        for (circlePoint in pointCircleList)
            canvas?.drawCircle(circlePoint.x.toFloat(), circlePoint.y.toFloat(), 70f, brush)

        for (linePoint in pointLineList)
            canvas?.drawLine(
                linePoint.x.toFloat(), linePoint.y.toFloat(),
                (linePoint.x).toFloat(), (linePoint.y + 200).toFloat(), brush
            )
    }
}