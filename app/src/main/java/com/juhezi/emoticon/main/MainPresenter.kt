package com.juhezi.emoticon.main

import android.util.Log

/**
 * Created by qiao1 on 2016/11/15.
 */
class MainPresenter(private var mView: MainContract.View) : MainContract.Presenter {

    private var TAG = "MainPresenter"

    init {
        mView.setPresenter(this)
    }

    override fun start() {
        Log.i(TAG, "start")
    }

    override fun destroy() {
        Log.i(TAG, "destroy")
    }
}