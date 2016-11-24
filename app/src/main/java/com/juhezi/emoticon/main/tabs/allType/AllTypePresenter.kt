package com.juhezi.emoticon.main.tabs.allType

import com.juhezi.emoticon.abs.AbsPresenter

/**
 * Created by qiao1 on 2016/11/24.
 */
class AllTypePresenter(var mView: AllTypeContract.View) :
        AbsPresenter(), AllTypeContract.Presenter {
    init {
        mView.setPresenter(this)
    }

    override fun start() {

    }

    override fun destroy() {

    }
}