package cn.com.shadowless.baseobserver.freshObserber;

import cn.com.shadowless.baseobserver.base.BaseMaybeObserver;
import cn.com.shadowless.baseobserver.event.EventCallBack;
import cn.com.shadowless.baseobserver.event.ObserveEventSpecification;
import io.reactivex.rxjava3.annotations.NonNull;


/**
 * 基础刷新Maybe观察者抽象类
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseFreshMaybeObserver<T> extends BaseMaybeObserver<T> implements ObserveEventSpecification<T> {

    /**
     * 刷新状态
     */
    private final int state;

    /**
     * 构造函数
     *
     * @param callBack 刷新布局
     */
    public BaseFreshMaybeObserver(@NonNull EventCallBack callBack) {
        this.callBack = callBack;
        this.state = callBack.getState();
    }

    @Override
    public void start() {
        onStartEvent();
    }

    @Override
    public void success(@NonNull T t) {
        if (state == EventCallBack.REFRESH) {
            onRefreshEvent(t);
        } else if (state == EventCallBack.LOAD) {
            onLoadEvent(t);
        }
    }

    @Override
    public void fail(@NonNull String error, @NonNull Throwable e) {
        onFailEvent(error, e);
        this.autoFinishRefreshAndLoad(state, callBack);
    }

    @Override
    public void finish() {
        onFinishEvent();
        this.autoFinishRefreshAndLoad(state, callBack);
    }

    @Override
    public void onSuccessEvent(@NonNull T t) {

    }
}