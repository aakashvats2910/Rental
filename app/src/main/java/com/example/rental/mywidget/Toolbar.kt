package com.example.rental.mywidget

import android.app.ActionBar
import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class Toolbar(private var context: Context, var title: String = "") {

    // To make a new toolbar using LinearLayout
    // This function will return the toolbar with fix set of rules.
    // which are necessary to be a toolbar.
    // I made it in order to get make my own custom toolbar.
    public fun getToolbar(): LinearLayout {
        val toolbar = LinearLayout(context)
        toolbar.orientation = LinearLayout.HORIZONTAL
        toolbar.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            dpFromPx(context, 56f).toInt()
        )
        return toolbar
    }

    private fun setTitle(toolbar: LinearLayout) {
        val titleView = TextView(context)
        toolbar.addView(titleView)
        titleView.maxWidth = dpFromPx(context, 50f).toInt()
    }

    private fun dpFromPx(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    private fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

}