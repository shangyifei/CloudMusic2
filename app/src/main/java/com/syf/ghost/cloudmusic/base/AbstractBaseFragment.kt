package com.syf.ghost.cloudmusic.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
open abstract class AbstractBaseFragment:Fragment(){

    open abstract fun getLayoutId():Int
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    open fun initView(){

    }

    open fun getTitle():CharSequence{
       return this.javaClass.name
    }

}