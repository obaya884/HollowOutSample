package app.takumi.obayashi.hollowoutsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var oldX = 0f
    var oldY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        hollowOutView.setOnTouchListener { v, event ->
//            val x = event.rawX
//            val y = event.rawY
//
//            when (event.action) {
//                MotionEvent.ACTION_MOVE -> {
//                    val left = hollowOutView.left + (x - oldX)
//                    val top = hollowOutView.top + (y - oldY)
//
//                    hollowOutView.layout(
//                        left.toInt(),
//                        top.toInt(),
//                        left.toInt() + hollowOutView.width,
//                        top.toInt() + hollowOutView.height
//                    )
//                }
//
//            }
//            oldX = x
//            oldY = y
//
//            return@setOnTouchListener true
//
//        }

    }
}