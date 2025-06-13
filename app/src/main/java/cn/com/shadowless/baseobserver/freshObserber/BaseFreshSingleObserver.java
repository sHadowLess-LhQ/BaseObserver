package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.base.BaseSingleObserver;
import cn.com.shadowless.baseobserver.ObserveEventSpecification;


/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseFreshSingleObserver<T> extends BaseSingleObserver<T> implements ObserveEventSpecification<T> {

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
    public BaseFreshSingleObserver(SmartRefreshLayout refreshLayout) {
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
            refreshLayout.finishRefresh();
            onRefreshEvent(t);
        } else if (state == RefreshState.Loading) {
            refreshLayout.finishLoadMore();
            onLoadEvent(t);
        }
    }

    @Override
    public void fail(String error, Throwable e) {
        this.autoFinishRefreshAndLoad(state, refreshLayout);
        onFailEvent(error, e);
    }

    @Override
    public void onSuccessEvent(T t) {

    }

    @Override
    public void onFinishEvent() {

    }
}