package com.juhezi.emoticon.main.tabs.dynamic

import com.juhezi.emoticon.abs.AbsPresenter

/**
 * Created by qiao1 on 2016/11/20.
 */
class DynamicPresenter(var mView: DynamicContract.View) : AbsPresenter(), DynamicContract.Presenter {
    init {
        mView.setPresenter(this)
    }

    override fun destroy() {

    }

    override fun start() {

    }
}