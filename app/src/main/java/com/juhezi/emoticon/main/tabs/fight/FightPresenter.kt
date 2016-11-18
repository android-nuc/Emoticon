package com.juhezi.emoticon.main.tabs.fight

import com.juhezi.emoticon.abs.AbsPresenter

/**
 * Created by qiao1 on 2016/11/18.
 */
class FightPresenter(var mView: FightContract.View) : AbsPresenter(), FightContract.Presenter {

    init {
        mView.setPresenter(this)
    }

    override fun start() {

    }

    override fun destroy() {

    }
}