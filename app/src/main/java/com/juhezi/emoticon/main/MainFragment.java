package com.juhezi.emoticon.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juhezi.emoticon.R;

/**
 * Created by qiao1 on 2016/11/15.
 */
public class MainFragment extends Fragment implements MainContract.View {
    private static String TAG = "MainFragment";

    private MainContract.Presenter mPresenter;
    private MainViewModel mViewModel;

    private View rootView;

    public static MainFragment getInstance() {
        return MainFragmentHolder.sInstance;
    }

    private MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_main, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.start();
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.destroy();
        }
        mPresenter = null;
        super.onDestroy();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setViewModel(MainViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    /**
     * 静态内部类实现单例模式
     */
    private static class MainFragmentHolder {
        private static final MainFragment sInstance = new MainFragment();
    }

}
