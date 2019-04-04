package com.syf.ghost.cloudmusic.model

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
data class HorizontalScollTabModel(val icon:String,val text:String)

data class MineManagerModel(val icon: String, val text: String, val count: String, val event:()->Unit = {})