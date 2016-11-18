package com.juhezi.emoticon.abs

import android.content.Context
import android.databinding.BaseObservable

/**
 * Created by qiao1 on 2016/11/15.
 */
abstract class AbsViewModel<T>(private var context: Context
                               , private final var mPresenter: T)
    : BaseObservable() {
}