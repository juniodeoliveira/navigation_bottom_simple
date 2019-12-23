package com.example.easynavigationbottom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_navigation_bottom.view.*

class ItemNavigationBottom : ConstraintLayout {
    private val anim: Long = 500

    private var state: StateItemNavigationBottom = StateItemNavigationBottom.DESELECT
    private lateinit var listener: Listener

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        View.inflate(context, R.layout.item_navigation_bottom, this)

        deSelect()

        rootView.setOnClickListener {
            if (state == StateItemNavigationBottom.DESELECT) {
                select()
                listener.onClickItem(this)
            }
        }
    }

    fun select() {
        view_background.animate().apply {
            this.duration = anim
            this.scaleX(1f)
            this.scaleY(1f)
        }.start()

        iv_icon.animate().apply {
            this.duration = anim
            this.scaleX(1f)
            this.scaleY(1f)
        }.start()

        state = StateItemNavigationBottom.SELECT
    }

    fun deSelect() {
        view_background.animate().apply {
            this.duration = anim
            this.scaleX(0f)
            this.scaleY(0f)
        }.start()

        iv_icon.animate().apply {
            this.duration = anim
            this.scaleX(0.66f)
            this.scaleY(0.66f)
        }.start()

        state = StateItemNavigationBottom.DESELECT
    }

    fun setListener(listener: Listener){
        this.listener = listener
    }

    interface Listener {
        fun onClickItem(itemNavigationBottom: ItemNavigationBottom)
    }
}