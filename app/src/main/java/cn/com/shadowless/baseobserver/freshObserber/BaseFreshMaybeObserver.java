package cn.com.shadowless.baseobserver.freshObserber;


import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;

import cn.com.shadowless.baseobserver.BaseMaybeObserver;


/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseFreshMaybeObserver<T> extends BaseMaybeObserver<T> {

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
    public BaseFreshMaybeObserver(SmartRefreshLayout refreshLayout) {
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
    public void fail(String error, Throwable e) {
        this.autoFinishRefreshAndLoad(state, refreshLayout);
        onFail(error, e);
    }

    @Override
    public void finish() {
        this.autoFinishRefreshAndLoad(state, refreshLayout);
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
     * On success.
     */
    public abstract void onFinish();

    /**
     * On fail.
     *
     * @param error the error
     */
    public abstract void onFail(String error, Throwable e);
}