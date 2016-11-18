package com.juhezi.emoticon.main.tabs.gif

import com.juhezi.emoticon.abs.AbsPresenter

/**
 * Created by qiao1 on 2016/11/18.
 */
class GifPresenter(var mView: GifContract.View) : AbsPresenter(), GifContract.Presenter {
    init {
        mView.setPresenter(this)
    }

    override fun start() {

    }

    override fun destroy() {

    }


}