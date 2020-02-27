package com.nasa.test.cicerone.utils.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.nasa.test.cicerone.R

class ProgressHolder(@param:NonNull var content: View, isDefault: Boolean = true) {

    private var holder: View

    init {
        val parent = content.parent as ViewGroup
        this.holder = LayoutInflater.from(content.context).inflate(R.layout.holder_progress, parent, false)
        holder.visibility = View.GONE
        val pos = parent.indexOfChild(content)
        parent.addView(holder, pos + 1, content.layoutParams)

    }

    fun setContentView(@NonNull content: View) {
        val parent = this.content.parent as ViewGroup
        parent.removeView(holder)

        val newParent = content.parent as ViewGroup
        newParent.addView(holder, newParent.indexOfChild(content) + 1, content.layoutParams)

        this.content = content
    }

    fun show() {
        if (holder.visibility != View.VISIBLE) {
            content.visibility = View.GONE
            holder.visibility = View.VISIBLE
        }
    }

    fun hide() {
        if (holder.visibility != View.GONE) {
            content.visibility = View.VISIBLE
            holder.visibility = View.GONE
        }
    }
}