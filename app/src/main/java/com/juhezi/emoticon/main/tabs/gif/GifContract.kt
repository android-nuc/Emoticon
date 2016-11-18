package com.juhezi.emoticon.main.tabs.gif

import com.juhezi.emoticon.main.MainContract

/**
 * Created by qiao1 on 2016/11/18.
 */
interface GifContract {

    interface Presenter : MainContract.Presenter {

    }

    interface View : MainContract.View<Presenter> {

    }

}