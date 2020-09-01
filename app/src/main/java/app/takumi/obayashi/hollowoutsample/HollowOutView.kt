package app.takumi.obayashi.hollowoutsample

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.VectorDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.graphics.drawable.toBitmap


/**
 * TODO: document your custom view class.
 */
public class HollowOutView : View {

    private val paint: Paint = Paint()
    private val backgroundPaint: Paint = Paint()

    private var srcImgDrawable: BitmapDrawable? = null
    private var srcImgBitMap: Bitmap? = null


    private var dstImgDrawable: VectorDrawable? = null
    private var dstImgBitMap: Bitmap? = null

    private var circleCenterX: Float = 0f
    private var circleCenterY: Float = 0f

    private var oldPositionX: Float = 0f
    private var oldPositionY: Float = 0f

    private var rePaint: Boolean = false


    @SuppressLint("ResourceType", "ClickableViewAccessibility")
    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        if (!rePaint) {
            srcImgDrawable = getDrawable(context, R.drawable.hero_image) as BitmapDrawable
            srcImgBitMap = srcImgDrawable?.bitmap

            VectorDrawable()
            dstImgDrawable = getDrawable(context, R.drawable.ic_26002) as VectorDrawable
            dstImgBitMap = dstImgDrawable?.toBitmap()

//            backgroundPaint.color =
//                ContextCompat.getColor(context, android.R.color.holo_blue_bright)
//            paint.color = ContextCompat.getColor(context, android.R.color.holo_blue_bright)

            circleCenterX = (width / 2).toFloat()
            circleCenterY = (height / 2).toFloat()

            // background
//            canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), backgroundPaint);
        }
        rePaint = true

        // DST
        canvas.drawCircle(circleCenterX, circleCenterY, 250F, paint)
//        canvas.drawBitmap(dstImgBitMap!!, circleCenterX, circleCenterY, paint)

        // SELECT MODE
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)

        // SRC
        canvas.drawBitmap(
            srcImgBitMap!!,
            (width / 2).toFloat() - (srcImgBitMap!!.width / 2).toFloat(),
            (height / 2).toFloat() - (srcImgBitMap!!.height / 2).toFloat(),
            paint
        )

        this.setOnTouchListener { _, event ->
            val positionX = event.rawX
            val positionY = event.rawY

            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    circleCenterX += (positionX - oldPositionX)
                    circleCenterY += (positionY - oldPositionY)
                    invalidate()
                }
            }

            oldPositionX = positionX
            oldPositionY = positionY

            return@setOnTouchListener true
        }
    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
    }

}
