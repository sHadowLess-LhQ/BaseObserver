package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.base.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.ObserveEventSpecification;


/**
 * 基础刷新Completable观察者抽象类
 *
 * @author sHadowLess
 */
public abstract class BaseFreshCompletableObserver extends BaseCompletableObserver implements ObserveEventSpecification<Object> {

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
    public BaseFreshCompletableObserver(SmartRefreshLayout refreshLayout) {
        this.refreshLayout = refreshLayout;
        this.state = refreshLayout.getState();
    }

    @Override
    public void start() {
        onStartEvent();
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
    public void onSuccessEvent(Object o) {

    }

    @Override
    public void onRefreshEvent(Object o) {

    }

    @Override
    public void onLoadEvent(Object o) {

    }
}