package com.juhezi.emoticon.main.tabs.dynamic

import android.content.Context
import com.juhezi.emoticon.abs.AbsViewModel

/**
 * Created by qiao1 on 2016/11/20.
 */
class DynamicViewModel(var context: Context, var mPresenter: DynamicPresenter)
    : AbsViewModel<DynamicPresenter>(context, mPresenter) {
}