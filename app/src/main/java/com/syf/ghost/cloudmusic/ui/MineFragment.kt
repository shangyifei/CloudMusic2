package com.syf.ghost.cloudmusic.ui

import android.support.v7.widget.LinearLayoutManager
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.adapter.MineFragmentRvAdapter
import com.syf.ghost.cloudmusic.base.AbstractBaseFragment
import com.syf.ghost.cloudmusic.model.HorizontalScollTabModel
import kotlinx.android.synthetic.main.fragment_find.*


/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
class MineFragment : AbstractBaseFragment(){
    val title = "我的"
    val adapter  by lazy {
        MineFragmentRvAdapter()
    }
    override fun getLayoutId(): Int {
      return R.layout.fragment_mine
    }

    override fun initView() {
        rv_mine.layoutManager = LinearLayoutManager(context)
        rv_mine.adapter = adapter

        adapter.setHorizontalScrollTabView(
            listOf(HorizontalScollTabModel("你好","私人FM"),
                HorizontalScollTabModel("你好","最新电音"),
                HorizontalScollTabModel("你好","最新电音"),
                HorizontalScollTabModel("你好","最新电音"),
                HorizontalScollTabModel("你好","最新电音"),
                HorizontalScollTabModel("你好","最新电音"),
                HorizontalScollTabModel("你好","最新电音"),
                HorizontalScollTabModel("你好","最新电音")))
    }

    override fun getTitle(): CharSequence {
        return title
    }
}