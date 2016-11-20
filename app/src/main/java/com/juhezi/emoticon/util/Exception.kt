package com.juhezi.emoticon.util

/**
 * Created by qiao1 on 2016/11/20.
 */
class TabNameNotAvailableException : Exception() {
    override val message: String = "Tab名称不可用！"
}

class TabNameRepeatableException : Exception() {
    override val message: String = "Tab名称重复"
}
