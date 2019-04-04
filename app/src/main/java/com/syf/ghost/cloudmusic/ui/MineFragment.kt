package com.syf.ghost.cloudmusic.ui

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.adapter.HorizontalScrollTabRvAdapter
import com.syf.ghost.cloudmusic.adapter.MineManagerAdapter
import com.syf.ghost.cloudmusic.base.AbstractBaseFragment
import com.syf.ghost.cloudmusic.base.BaseViewHolder
import com.syf.ghost.cloudmusic.base.MultiTypeAdapter
import com.syf.ghost.cloudmusic.model.HorizontalScollTabModel
import com.syf.ghost.cloudmusic.model.MineManagerModel
import kotlinx.android.synthetic.main.fragment_find.*


/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
class MineFragment : AbstractBaseFragment() {
    val title = "我的"
    val adapter by lazy {
        MultiTypeAdapter()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initView() {
        rv_mine.layoutManager = LinearLayoutManager(context)
        rv_mine.adapter = adapter
        val adapters: List<RecyclerView.Adapter<out BaseViewHolder<out Any>>> = listOf(
            HorizontalScrollTabRvAdapter(mutableListOf(HorizontalScollTabModel("a", "私人FM"))),
            MineManagerAdapter(
                mutableListOf(
                    MineManagerModel("", "本地音乐", "2") {goLocalMusicActivity()},
                    MineManagerModel("", "最近播放", "4"),
                    MineManagerModel("", "下载管理", "4")
                )
            )
        )
        adapter.setAdapter(adapters)
    }

    fun goLocalMusicActivity() {
        startActivity(Intent(context, LocalMusicActivity::class.java))
    }

    override fun getTitle(): CharSequence {
        return title
    }
}