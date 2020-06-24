package com.example.listleague

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class LeagueGridList(gridSpace: Int, gridSize: Int) : RecyclerView.ItemDecoration() {
    private var mGridSpace : Int = gridSpace
    private var mGridSize : Int = gridSize

    private var mLeftSpace = false

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    )
    {
        val frameWidth = ((parent.width - mGridSpace.toFloat() * (mGridSize - 1)) / mGridSize).toInt()
        val padding = parent.width /mGridSize - frameWidth
        val itemPosition = (view.layoutParams as RecyclerView.LayoutParams).viewAdapterPosition

        if (itemPosition < mGridSize) {
            outRect.top = 0
        } else {
            outRect.top = mGridSpace
        }

        if (itemPosition % mGridSize == 0) {
            outRect.left = 0
            outRect.right = padding
            mLeftSpace = true
        } else if ((itemPosition + 1) % mGridSize == 0) {
            mLeftSpace = false
            outRect.right = 0
            outRect.left = padding
        } else if (mLeftSpace) {
            mLeftSpace = false
            outRect.left = mGridSpace - padding
            if ((itemPosition + 2) % mGridSize == 0) {
                outRect.right = mGridSpace - padding
            } else {
                outRect.right = mGridSpace / 2
            }
        } else if ((itemPosition + 2) % mGridSize == 0) {
            mLeftSpace = false
            outRect.left = mGridSpace / 2
            outRect.right = mGridSpace - padding
        } else {
            mLeftSpace = false
            outRect.left = mGridSpace / 2
            outRect.right = mGridSpace / 2
        }
        outRect.bottom = 0
    }
}