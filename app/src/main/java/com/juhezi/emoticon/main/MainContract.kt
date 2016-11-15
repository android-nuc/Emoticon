package com.juhezi.emoticon.main

import com.juhezi.emoticon.BasePresenter
import com.juhezi.emoticon.BaseView

/**
 * Created by qiao1 on 2016/11/15.
 */
interface MainContract {

    interface Presenter : BasePresenter {

    }

    interface View : BaseView<Presenter> {

    }

}