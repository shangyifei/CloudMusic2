package com.syf.ghost.cloudmusic.ui

import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.adapter.HomeActivityFragmentAdapter
import com.syf.ghost.cloudmusic.base.CommonActivity
import kotlinx.android.synthetic.main.activity_local_music.*

/**
 * Created by Android on 2019/4/4.
 * auth Shangyifei
 */
class LocalMusicActivity:CommonActivity(){
    private val fragments = arrayOf(MineFragment(),FindFragment(),FriendsFragment())
    override fun getLayoutId(): Int {
        return R.layout.activity_local_music
    }

    override fun iniView() {
        title = "我的音乐"

        local_music_viewPager.adapter = HomeActivityFragmentAdapter(supportFragmentManager,fragments)
        fragments.forEach { _ ->
            local_music_tabLayout.addTab(local_music_tabLayout.newTab())
        }
        local_music_tabLayout.setupWithViewPager(local_music_viewPager)
    }
}