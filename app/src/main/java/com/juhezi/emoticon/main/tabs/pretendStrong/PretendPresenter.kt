package com.juhezi.emoticon.main.tabs.pretendStrong

import com.juhezi.emoticon.abs.AbsPresenter

/**
 * Created by qiao1 on 2016/11/17.
 */
class PretendPresenter(mView: PretendContract.View) : AbsPresenter(), PretendContract.Presenter {
    init {
        mView.setPresenter(this)
    }

    override fun destroy() {

    }

    override fun start() {

    }
}