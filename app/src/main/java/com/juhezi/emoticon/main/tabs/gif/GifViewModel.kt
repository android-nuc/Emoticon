package com.juhezi.emoticon.main.tabs.gif

import android.content.Context
import com.juhezi.emoticon.abs.AbsViewModel

/**
 * Created by qiao1 on 2016/11/18.
 */
class GifViewModel(var context: Context, var mPresenter: GifPresenter)
    : AbsViewModel<GifPresenter>(context, mPresenter) {
}