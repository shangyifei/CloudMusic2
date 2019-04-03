package com.syf.ghost.cloudmusic.ui

import android.os.Build
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.adapter.HomeActivityFragmentAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.tool_bar_main.*

class MainActivity : AppCompatActivity() {
    private val fragments = arrayOf(MineFragment(),FindFragment(),FriendsFragment())
    private val homeActivityFragmentAdapter by lazy {
        HomeActivityFragmentAdapter(supportFragmentManager, fragments)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT>21) {
            window.enterTransition = Explode()
            window.enterTransition.duration = 500
            window.exitTransition = Explode()
            window.exitTransition.duration =500
        }
        setContentView(R.layout.activity_main)
        toolbar.title = ""
        setSupportActionBar(toolbar)
        val  actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.app_name,R.string.app_name)
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        fragments.forEach { _ ->
            tabLayout.addTab(tabLayout.newTab())
        }
        tabLayout.setupWithViewPager(viewpager)
        viewpager.adapter = homeActivityFragmentAdapter

    }

}
