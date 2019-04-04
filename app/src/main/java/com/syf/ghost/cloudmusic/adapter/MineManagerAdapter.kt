package com.syf.ghost.cloudmusic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.base.BaseSingleRvAdapter
import com.syf.ghost.cloudmusic.base.BaseViewHolder
import com.syf.ghost.cloudmusic.model.MineManagerModel
import com.syf.ghost.cloudmusic.utils.inflate
import kotlinx.android.synthetic.main.item_mine_manager.*

/**
 * Created by Android on 2019/4/4.
 * auth Shangyifei
 */
class MineManagerAdapter(data:MutableList<MineManagerModel>) : BaseSingleRvAdapter<MineManagerModel, MineManagerAdapter.MineManagerViewHolder>(data){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MineManagerViewHolder {
       return MineManagerViewHolder(inflate(p0, R.layout.item_mine_manager))
    }

    class MineManagerViewHolder(itemView:View):BaseViewHolder<MineManagerModel>(itemView){
        override fun bindView(model: MineManagerModel) {
            super.bindView(model)
            tv_manager_text.text = model.text
            tv_manager_hint_counter.text = "(${model.count})"
        }
    }

    override fun getItemViewType(position: Int): Int {
        return 2
    }
}
