package com.juhezi.emoticon.main

import android.content.Context
import android.databinding.BaseObservable

/**
 * Created by qiao1 on 2016/11/15.
 */
class MainViewModel(private var context: Context
                    , private final var mPresenter: MainContract.Presenter)
    : BaseObservable() {

    init {

    }

}