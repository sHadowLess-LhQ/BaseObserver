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
        onStart();
    }

    @Override
    public void success(T t) {
        if (state == RefreshState.Refreshing) {
            successRefresh(t);
        } else if (state == RefreshState.Loading) {
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
     * On finish.
     */
    public abstract void onFinish();

    /**
     * On fail.
     *
     * @param error the error
     */
    public abstract void onFail(String error);
}