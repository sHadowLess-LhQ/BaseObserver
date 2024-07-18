package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.BaseSingleObserver;


/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseFreshSingleObserver<T> extends BaseSingleObserver<T> {

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
        onStart();
        if (state == RefreshState.Refreshing) {
            refreshLayout.autoRefresh();
        } else if (state == RefreshState.Loading) {
            refreshLayout.autoLoadMore();
        }
    }

    @Override
    public void success(T t) {
        if (state == RefreshState.Refreshing) {
            refreshLayout.finishRefresh();
            successRefresh(t);
        } else if (state == RefreshState.Loading) {
            refreshLayout.finishLoadMore();
            successLoad(t);
        }
    }

    @Override
    public void fail(String error) {
        if (state == RefreshState.Refreshing) {
            refreshLayout.finishRefresh();
        } else if (state == RefreshState.Loading) {
            refreshLayout.finishLoadMore();
        }
        onFail(error);
    }

    /**
     * On start.
     */
    protected abstract void onStart();

    /**
     * Finish refresh.
     *
     * @param t the t
     */
    protected abstract void successRefresh(T t);

    /**
     * Finish load.
     *
     * @param t the t
     */
    protected abstract void successLoad(T t);

    /**
     * On fail.
     *
     * @param error the error
     */
    public abstract void onFail(String error);
}