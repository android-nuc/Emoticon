package com.juhezi.emoticon.abs;

import android.support.v4.app.Fragment;

/**
 * 抽象Fragment
 * <p>
 * Created by qiao1 on 2016/11/18.
 */
public abstract class AbsFragment<T extends AbsViewModel<? extends AbsPresenter>> extends Fragment {

    protected T mViewModel;

    public void setViewModel(T viewModel) {
        this.mViewModel = viewModel;
    }

}
