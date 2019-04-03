package com.syf.ghost.cloudmusic.ui

import com.syf.ghost.cloudmusic.R
import com.syf.ghost.cloudmusic.base.AbstractBaseFragment

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
class FriendsFragment : AbstractBaseFragment(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_friends
    }

    override fun getTitle(): CharSequence {
        return "朋友"
    }
}