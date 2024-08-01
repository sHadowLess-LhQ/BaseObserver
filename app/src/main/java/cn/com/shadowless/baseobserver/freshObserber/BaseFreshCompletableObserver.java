package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.BaseCompletableObserver;


/**
 * The type Base observer.
 *
 * @author sHadowLess
 */
public abstract class BaseFreshCompletableObserver extends BaseCompletableObserver {

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
        onStart();
        if (state == RefreshState.Refreshing) {
            refreshLayout.autoRefresh();
        } else if (state == RefreshState.Loading) {
            refreshLayout.autoLoadMore();
        }
    }

    @Override
    public void fail(String error, Throwable e) {
        if (state == RefreshState.Refreshing) {
            refreshLayout.finishRefresh();
        } else if (state == RefreshState.Loading) {
            refreshLayout.finishLoadMore();
        }
        onFail(error, e);
    }

    @Override
    public void finish() {
        if (state == RefreshState.Refreshing) {
            refreshLayout.finishRefresh();
        } else if (state == RefreshState.Loading) {
            refreshLayout.finishLoadMore();
        }
        onFinish();
    }

    /**
     * On start.
     */
    protected abstract void onStart();

    /**
     * On finish.
     */
    public abstract void onFinish();

    /**
     * On fail.
     *
     * @param error the error
     */
    public abstract void onFail(String error, Throwable e);
}