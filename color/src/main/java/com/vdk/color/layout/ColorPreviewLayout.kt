package com.vdk.color.layout

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import com.vdknd.color.color.colordemo.color.R

class ColorPreviewLayout : RelativeLayout {
    var mColor: Int = 0xFF0000

    val mPreview: View by lazy { this.findViewById<View>(R.id.color_preview) }
    private val mAlpha: EditText by lazy { this.findViewById<EditText>(R.id.edt_alpha) }
    val mRed: EditText by lazy { this.findViewById<EditText>(R.id.edt_red) }
    val mGreen: EditText by lazy { this.findViewById<EditText>(R.id.edt_green) }
    val mBlue: EditText by lazy { this.findViewById<EditText>(R.id.edt_blue) }
    constructor(context: Context?) : super(context) {
        construct()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        construct()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        construct()
    }

    private fun construct() {
        inflate(context, R.layout.color_preview_layout, this)
    }

    fun setColor(color: Int) {
        mAlpha.setText((Color.alpha(color)).toString())
        mRed.setText((Color.red(color)).toString())
        mGreen.setText((Color.green(color)).toString())
        mBlue.setText((Color.blue(color)).toString())

        mPreview.setBackgroundColor(color)
    }
}