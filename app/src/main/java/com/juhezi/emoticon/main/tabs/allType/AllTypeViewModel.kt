package com.juhezi.emoticon.main.tabs.allType

import android.content.Context
import com.juhezi.emoticon.abs.AbsViewModel

/**
 * Created by qiao1 on 2016/11/24.
 */
class AllTypeViewModel(private var context: Context,
                       private final var mPresenter: AllTypePresenter) :
        AbsViewModel<AllTypePresenter>(context, mPresenter) {
}