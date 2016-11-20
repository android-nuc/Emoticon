package com.juhezi.emoticon.main.tabs;

import android.content.Context;
import android.util.Log;

import com.juhezi.emoticon.R;
import com.juhezi.emoticon.abs.AbsFragment;
import com.juhezi.emoticon.abs.AbsPresenter;
import com.juhezi.emoticon.abs.AbsViewModel;
import com.juhezi.emoticon.main.tabs.dynamic.DynamicFragment;
import com.juhezi.emoticon.util.TabNameNotAvailableException;
import com.juhezi.emoticon.util.TabNameRepeatableException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by qiao1 on 2016/11/18.
 */
public abstract class TabFragment extends AbsFragment<AbsViewModel<AbsPresenter>> {
    private static String TAG = "TabFragment";

    protected String tabName;

    protected TabFragment(String tabName) {
        this.tabName = tabName;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public static class Builder {

        private static Map<String, AbsViewModel> mViewModelPool = new LinkedHashMap<>();
        private static Map<String, AbsPresenter> mPresenterPool = new LinkedHashMap<>();
        private static Map<String, TabFragment> mFragmentPool = new LinkedHashMap<>();

        public static Map<String, AbsViewModel> getViewModelPool() {
            return mViewModelPool;
        }

        public static Map<String, AbsPresenter> getPresenterPool() {
            return mPresenterPool;
        }

        public static Map<String, TabFragment> getFragmentPool() {
            return mFragmentPool;
        }

        private TabFragment mFragment;
        private AbsPresenter mPresenter;
        private AbsViewModel mViewModel;

        private String tabName;
        private Class viewModelClazz;
        private Class presenterClazz;
        private Class fragmentClazz;
        private Context context;

        public Builder setTabName(String tabName) {
            this.tabName = tabName;
            return this;
        }

        public Builder setViewModelClazz(Class<? extends AbsViewModel> viewModelClazz) {
            this.viewModelClazz = viewModelClazz;
            return this;
        }

        public Builder setPresenterClazz(Class<? extends AbsPresenter> presenterClazz) {
            this.presenterClazz = presenterClazz;
            return this;
        }

        public Builder setFragmentClazz(Class<? extends TabFragment> fragmentClazz) {
            this.fragmentClazz = fragmentClazz;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public TabFragment build() throws TabNameNotAvailableException, TabNameRepeatableException {

            if (tabName == null || tabName.trim().equals("")) {     //Tab名字不合法
                throw new TabNameNotAvailableException();
            }

            if (mFragmentPool.containsKey(tabName)) {   // Tab名称重复
                throw new TabNameRepeatableException();
            }


            try {
                if (fragmentClazz.getName().equals(DynamicFragment.class.getName())) {  //动态的Fragment
                    //调用构造方法
                    Constructor<TabFragment> constructorFrag = fragmentClazz.getDeclaredConstructor(String.class);
                    constructorFrag.setAccessible(true);    //取消访问检查
                    mFragment = constructorFrag.newInstance(tabName);
                } else {
                    //调用静态方法
                    Method getInstanceMethod = fragmentClazz.getMethod(context.getString(R.string.get_instance), String.class);
                    mFragment = (TabFragment) getInstanceMethod.invoke(null, tabName);
                }

                mFragmentPool.put(tabName, mFragment);
                Constructor<AbsPresenter> constructorPre = (Constructor<AbsPresenter>) presenterClazz.getDeclaredConstructors()[0];
                mPresenter = constructorPre.newInstance(mFragment);
                mPresenterPool.put(tabName, mPresenter);
                Constructor<AbsViewModel> constructorVimo = (Constructor<AbsViewModel>) viewModelClazz.getConstructors()[0];
                mViewModel = constructorVimo.newInstance(context, mPresenter);
                mViewModelPool.put(tabName, mViewModel);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return mFragment;
        }

    }
}
