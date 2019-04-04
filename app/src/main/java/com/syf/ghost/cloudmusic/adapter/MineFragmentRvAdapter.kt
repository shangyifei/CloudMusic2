package com.syf.ghost.cloudmusic.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.base.BaseViewHolder
import com.syf.ghost.cloudmusic.model.HorizontalScollTabModel
import kotlinx.android.synthetic.main.item_mine_horizontal_scroll_tabs.*

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
const val HORIZONTAL_SCROLL_TAB_TYPE = 0
const val MINE_MANAGER_TYPE = 1
const val DEFAULT_TYPE = -1

class MineFragmentRvAdapter : RecyclerView.Adapter<BaseViewHolder<out Any>>() {
    private val horizontalScollTabModelList: MutableList<HorizontalScollTabModel> = ArrayList()
    private val mineManageList:MutableList<Any> = ArrayList()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<out Any> {
        return when (p1) {
            HORIZONTAL_SCROLL_TAB_TYPE -> HorizontalScrollTabViewHodel(LayoutInflater.from(p0.context).inflate(R.layout.item_mine_horizontal_scroll_tabs,p0,false))
            else -> BaseViewHolder(View(p0.context))
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            HORIZONTAL_SCROLL_TAB_TYPE -> HORIZONTAL_SCROLL_TAB_TYPE
            MINE_MANAGER_TYPE -> MINE_MANAGER_TYPE
            else -> DEFAULT_TYPE
        }
    }

    override fun onBindViewHolder(p0: BaseViewHolder<out Any>, p1: Int) {

        if (p0 is HorizontalScrollTabViewHodel) {
            p0.bindView(horizontalScollTabModelList)
            return
        }
    }

    fun setHorizontalScrollTabView(horizontalScollTabModelList: List<HorizontalScollTabModel>) {
        this.horizontalScollTabModelList.clear()
        this.horizontalScollTabModelList.addAll(horizontalScollTabModelList)
        notifyDataSetChanged()
    }


    class HorizontalScrollTabViewHodel(view: View) :
        BaseViewHolder<MutableList<HorizontalScollTabModel>>(view){

        override fun bindView(model: MutableList<HorizontalScollTabModel>) {
            val layoutManager = LinearLayoutManager(itemView.context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            rv_scroll_tab.layoutManager = layoutManager
            rv_scroll_tab.adapter = HorizontalScrollTabRvAdapter(model)
        }
    }
}