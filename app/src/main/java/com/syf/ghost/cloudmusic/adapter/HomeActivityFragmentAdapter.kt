package com.syf.ghost.cloudmusic.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.syf.ghost.cloudmusic.base.AbstractBaseFragment

/**
 * Created by Android on 2019/4/3.
 * auth Shangyifei
 */
class HomeActivityFragmentAdapter(fragmentManager: FragmentManager, fragments: Array<AbstractBaseFragment>) :
    FragmentPagerAdapter(fragmentManager) {
    val fragments = fragments
    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].getTitle()
    }
}