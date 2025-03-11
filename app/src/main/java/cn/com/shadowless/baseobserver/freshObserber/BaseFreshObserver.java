package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.BaseObserver;


/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseFreshObserver<T> extends BaseObserver<T> {

    /**
     * The Loading popup view.
     */
    private final SmartRefreshLayout refreshLayout;

    /**
     * The State.
     */
    private final RefreshState state;

    /**
     * Instantiates a new Base fresh observer.
     *
     * @param refreshLayout the refresh layout
     */
    public BaseFreshObserver(SmartRefreshLayout refreshLayout) {
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