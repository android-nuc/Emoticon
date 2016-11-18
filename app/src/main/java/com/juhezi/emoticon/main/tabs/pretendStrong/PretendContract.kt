package com.juhezi.emoticon.main.tabs.pretendStrong

import com.juhezi.emoticon.main.MainContract

/**
 * Created by qiao1 on 2016/11/17.
 */
interface PretendContract {

    interface Presenter : MainContract.Presenter {

    }

    interface View : MainContract.View<Presenter> {

    }

}