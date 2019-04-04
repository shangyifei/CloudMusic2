package com.syf.ghost.cloudmusic.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.utils.inflateAttach
import kotlinx.android.synthetic.main.activity_common.*

abstract class CommonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        inflateAttach(fl_content,getLayoutId())
        setToolBar()
        iniView()
    }
    open fun iniView(){

    }
    private fun setToolBar(){
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { finish() }
    }

    abstract fun getLayoutId():Int
}
