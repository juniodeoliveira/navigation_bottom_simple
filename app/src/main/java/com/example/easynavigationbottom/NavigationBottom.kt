package com.example.easynavigationbottom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.navigation_bottom.view.*

class NavigationBottom : ConstraintLayout, ItemNavigationBottom.Listener {
    lateinit var currentItem: ItemNavigationBottom

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        View.inflate(context, R.layout.navigation_bottom, this)

        currentItem = item_home
        currentItem.select()

        item_home.setListener(this)
        item_indication.setListener(this)
        item_buy.setListener(this)
        item_wallet.setListener(this)
        item_help.setListener(this)
    }

    override fun onClickItem(itemNavigationBottom: ItemNavigationBottom) {
        currentItem.deSelect()
        currentItem = itemNavigationBottom
    }
}
