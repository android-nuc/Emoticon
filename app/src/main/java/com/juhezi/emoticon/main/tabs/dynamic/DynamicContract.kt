package com.juhezi.emoticon.main.tabs.dynamic

import com.juhezi.emoticon.main.MainContract

/**
 * Created by qiao1 on 2016/11/20.
 */
interface DynamicContract {

    interface Presenter : MainContract.Presenter {

    }

    interface View : MainContract.View<Presenter> {
        
    }

}