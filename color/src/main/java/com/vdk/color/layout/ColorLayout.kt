package com.vdk.color.layout

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.vdk.color.OnColorChangedListener
import com.vdk.color.view.ColorOpacityView
import com.vdk.color.view.ColorRectangleView
import com.vdk.color.view.ColorValueView
import com.vdknd.color.color.colordemo.color.R

class ColorLayout : RelativeLayout {
    private val mColorRectangleView: ColorRectangleView by lazy { findViewById(R.id.color_rectangle_view) }
    private val mColorValueView: ColorValueView by lazy { findViewById(R.id.color_value_view) }
    private val mColorOpacityView: ColorOpacityView by lazy { findViewById(R.id.color_opacity_view) }
    private val mColorPreviewLayout: ColorPreviewLayout by lazy { findViewById(R.id.color_preview_layout) }

    private var mOnColorChangedListener: OnColorChangedListener? = null

    constructor(context: Context?) : super(context) {
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        inflate(context, R.layout.color_layout, this)

        mColorRectangleView.setOnColorChangedListener(object : OnColorChangedListener {
            override fun onColorChanged(color: Int) {
                mColorValueView.setColor(color)
                mColorOpacityView.setColor(color)
                mColorPreviewLayout.setColor(color)
                mOnColorChangedListener?.onColorChanged(color)
            }
        })
        mColorValueView.setOnColorChangedListener(object : OnColorChangedListener {
            override fun onColorChanged(color: Int) {
                mColorPreviewLayout.setColor(color)
                mOnColorChangedListener?.onColorChanged(color)
            }
        })
        mColorOpacityView.setOnColorChangedListener(object : OnColorChangedListener {
            override fun onColorChanged(color: Int) {
                mColorPreviewLayout.setColor(color)
                mOnColorChangedListener?.onColorChanged(color)
            }
        })
    }

    fun setOnColorChangedListener(listener: OnColorChangedListener) {
        mOnColorChangedListener = listener
    }

    fun setColor(color: Int) {
        mColorRectangleView.setColor(color)
        mColorValueView.setColor(color)
        mColorOpacityView.setColor(color)
        mColorPreviewLayout.setColor(color)
    }
}