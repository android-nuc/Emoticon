package com.juhezi.emoticon.main.tabs.lovely;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.abs.AbsFragment;
import com.juhezi.emoticon.main.tabs.TabFragment;

/**
 * Created by qiao1 on 2016/11/17.
 */
public class LovelyFragment extends TabFragment implements LovelyContract.View {
    private static String TAG = "LovelyFragment";

    private LovelyFragment(String tabName) {
        super(tabName);
    }

    private static LovelyFragment sInstance;

    public static LovelyFragment getInstance(String tabName) {
        if (sInstance == null) {
            sInstance = new LovelyFragment(tabName);
        }
        return sInstance;
    }

    private LovelyContract.Presenter mPresenter;

    private View rootView;

    @Override
    public void setPresenter(LovelyContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_lovely, container, false);
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
        super.onDestroy();
    }
}
