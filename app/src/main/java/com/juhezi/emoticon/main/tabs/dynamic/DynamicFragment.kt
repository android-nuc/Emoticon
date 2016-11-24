package com.juhezi.emoticon.main.tabs.dynamic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.juhezi.emoticon.R
import com.juhezi.emoticon.main.tabs.TabFragment

/**
 * Created by qiao1 on 2016/11/17.
 */
class DynamicFragment(tabName: String) : TabFragment(tabName), DynamicContract.View {

    private var mPresenter: DynamicContract.Presenter? = null

    private var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.frag_dynamic, container, false)
        val textView = rootView!!.findViewById(R.id.tv_frag_dynamic_show) as TextView
        textView.text = tabName
        return rootView
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.start()
    }

    override fun onDestroy() {
        mPresenter?.destroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: DynamicContract.Presenter) {
        this.mPresenter = presenter
    }
}
