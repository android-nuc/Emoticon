package com.juhezi.emoticon.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.juhezi.emoticon.abs.AbsPresenter
import com.juhezi.emoticon.abs.AbsViewModel
import com.juhezi.emoticon.main.tabs.TabFragment
import java.util.*

/**
 * ViewPager 和 TabLayout的Adapter
 *
 * Created by qiao1 on 2016/11/18.
 */
class VPTLAdapter(var mFragments: ArrayList<TabFragment>, var fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager) {

    fun setFragments(fragment: ArrayList<TabFragment>) {
        this.mFragments = fragment

        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mFragments.count()
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    /**
     * 设置Tab上的title
     */
    override fun getPageTitle(position: Int): CharSequence {
        return mFragments[position].tabName
    }


}