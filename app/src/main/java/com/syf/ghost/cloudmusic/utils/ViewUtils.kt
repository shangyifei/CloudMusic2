package com.syf.ghost.cloudmusic.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Android on 2019/4/4.
 * auth Shangyifei
 */
fun inflate(parent:ViewGroup,resId:Int):View{
    return LayoutInflater.from(parent.context).inflate(resId,parent,false)
}
fun inflateAttach(parent:ViewGroup,resId:Int):View{
    return LayoutInflater.from(parent.context).inflate(resId,parent,true)
}
