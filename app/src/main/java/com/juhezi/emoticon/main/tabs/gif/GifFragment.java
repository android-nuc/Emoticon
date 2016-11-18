package com.juhezi.emoticon.main.tabs.gif;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.main.tabs.TabFragment;
import com.juhezi.emoticon.main.tabs.fight.FightFragment;

/**
 * Created by qiao1 on 2016/11/17.
 */
public class GifFragment extends TabFragment implements GifContract.View {
    private static String TAG = "GifFragment";

    private GifFragment(String tabName) {
        super(tabName);
    }

    private static GifFragment sInstance;

    public static GifFragment getInstance(String tabName) {
        if (sInstance == null) {
            sInstance = new GifFragment(tabName);
        }
        return sInstance;
    }

    private GifContract.Presenter mPresenter;

    @Override
    public void setPresenter(GifContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_gif, container, false);
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
