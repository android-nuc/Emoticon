package com.juhezi.emoticon.main.tabs.lovely

import android.content.Context
import com.juhezi.emoticon.abs.AbsViewModel
import com.juhezi.emoticon.main.tabs.pretendStrong.PretendPresenter

/**
 * Created by qiao1 on 2016/11/17.
 */
class LovelyViewModel(private var context: Context
                      , private final var mPresenter: LovelyPresenter)
    : AbsViewModel<LovelyPresenter>(context, mPresenter) {
}
