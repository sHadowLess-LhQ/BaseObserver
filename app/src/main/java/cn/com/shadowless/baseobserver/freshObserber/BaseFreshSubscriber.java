package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.BaseSubscriber;


/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseFreshSubscriber<T> extends BaseSubscriber<T> {

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
    public BaseFreshSubscriber(SmartRefreshLayout refreshLayout) {
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
        this.autoFinishRefreshAndLoad(state, refreshLayout);
        onFailEvent(error, e);
    }

    @Override
    public void finish() {
        this.autoFinishRefreshAndLoad(state, refreshLayout);
        onFinishEvent();
    }

    @Override
    public void onSuccessEvent(T t) {

    }
}