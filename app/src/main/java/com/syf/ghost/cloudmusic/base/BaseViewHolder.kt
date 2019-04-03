package com.syf.ghost.cloudmusic.base

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
open  class BaseViewHolder<T>(view:View) :
    RecyclerView.ViewHolder(view),LayoutContainer {
    override val containerView: View?
        get() = itemView

    open fun bindView(model:T){

    }
}