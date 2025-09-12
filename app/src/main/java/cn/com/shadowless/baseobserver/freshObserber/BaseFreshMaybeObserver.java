package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.base.BaseMaybeObserver;
import cn.com.shadowless.baseobserver.ObserveEventSpecification;


/**
 * 基础刷新Maybe观察者抽象类
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseFreshMaybeObserver<T> extends BaseMaybeObserver<T> implements ObserveEventSpecification<T> {

    /**
     * 刷新布局
     */
    private final SmartRefreshLayout refreshLayout;

    /**
     * 刷新状态
     */
    private final RefreshState state;

    /**
     * 构造函数
     *
     * @param refreshLayout 刷新布局
     */
    public BaseFreshMaybeObserver(SmartRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
        this.state = refreshLayout.getState();
    }

    @Override
    public void start() {
        onStartEvent();
    }

    @Override
    public void success(T t) {
        if (state == RefreshState.Refreshing) {
            onRefreshEvent(t);
        } else if (state == RefreshState.Loading) {
            onLoadEvent(t);
        }
    }

    @Override
    public void fail(String error, Throwable e) {
        onFailEvent(error, e);
        this.autoFinishRefreshAndLoad(state, refreshLayout);
    }

    @Override
    public void finish() {
        onFinishEvent();
        this.autoFinishRefreshAndLoad(state, refreshLayout);
    }

    @Override
    public void onSuccessEvent(T t) {

    }
}