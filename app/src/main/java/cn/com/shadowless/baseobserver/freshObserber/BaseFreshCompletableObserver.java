package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.base.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.ObserveEventSpecification;


/**
 * The type Base observer.
 *
 * @author sHadowLess
 */
public abstract class BaseFreshCompletableObserver extends BaseCompletableObserver implements ObserveEventSpecification<Object> {

    /**
     * The Loading popup view.
     */
    private final SmartRefreshLayout refreshLayout;

    /**
     * The Page.
     */
    private final RefreshState state;

    /**
     * Instantiates a new Base fresh observer.
     *
     * @param refreshLayout the refresh layout
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