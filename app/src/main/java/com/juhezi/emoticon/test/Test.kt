package com.juhezi.emoticon.test

import com.juhezi.emoticon.main.tabs.TabFragment
import com.juhezi.emoticon.main.tabs.gif.GifFragment
import com.juhezi.emoticon.main.tabs.gif.GifPresenter
import com.juhezi.emoticon.main.tabs.gif.GifViewModel

/**
 * Created by qiao1 on 2016/11/18.
 */
fun main(args: Array<String>) {
    var builder = TabFragment.Builder()
    builder.setTabName("装X")
            .setFragmentClazz(GifFragment::class.java)
            .setPresenterClazz(GifPresenter::class.java)
            .setViewModelClazz(GifViewModel::class.java)
            .setContext(null)
            .build()
}
