package com.dm.sample.navigation.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import com.dm.sample.navigation.R
import kotlinx.android.synthetic.main.view_badge.view.*

class BadgeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_badge, this)
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
    }

    fun setBadgeNumber(number: Int) {
        badgeNumberTextView.text = number.toString()
    }
}