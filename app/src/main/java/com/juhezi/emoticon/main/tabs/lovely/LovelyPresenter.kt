package com.juhezi.emoticon.main.tabs.lovely

import com.juhezi.emoticon.abs.AbsPresenter

/**
 * Created by qiao1 on 2016/11/17.
 */
class LovelyPresenter(var mView: LovelyContract.View) : AbsPresenter(), LovelyContract.Presenter {
    init {
        mView.setPresenter(this)
    }

    override fun start() {

    }

    override fun destroy() {

    }


}