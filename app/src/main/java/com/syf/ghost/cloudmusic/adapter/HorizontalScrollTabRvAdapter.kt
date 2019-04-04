package com.syf.ghost.cloudmusic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.base.BaseSingleRvAdapter
import com.syf.ghost.cloudmusic.base.BaseViewHolder
import com.syf.ghost.cloudmusic.model.HorizontalScollTabModel
import kotlinx.android.synthetic.main.item_mine_horizontal_scroll_tab.*

class HorizontalScrollTabRvAdapter(list: MutableList<HorizontalScollTabModel>) : BaseSingleRvAdapter<HorizontalScollTabModel,HorizontalScrollTabRvAdapter.HorizontalScrollTabViewHolder>(list) {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HorizontalScrollTabViewHolder {
        return HorizontalScrollTabViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_mine_horizontal_scroll_tab,p0,false))
    }

    class HorizontalScrollTabViewHolder(view: View) : BaseViewHolder<HorizontalScollTabModel>(view){
        override fun bindView(model: HorizontalScollTabModel) {
            tv_scroll_tab.text = model.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }
}