package cn.com.shadowless.baseobserver.freshObserber;


import cn.com.shadowless.baseobserver.base.BaseSingleObserver;
import cn.com.shadowless.baseobserver.event.EventCallBack;
import cn.com.shadowless.baseobserver.event.ObserveEventSpecification;
import io.reactivex.rxjava3.annotations.NonNull;


/**
 * 基础刷新Single观察者抽象类
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseFreshSingleObserver<T> extends BaseSingleObserver<T> implements ObserveEventSpecification<T> {

    /**
     * 刷新状态
     */
    private final int state;

    /**
     * 构造函数
     *
     * @param callBack 刷新布局
     */
    public BaseFreshSingleObserver(@NonNull EventCallBack callBack) {
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
            callBack.finishRefresh();
            onRefreshEvent(t);
        } else if (state == EventCallBack.LOAD) {
            callBack.finishLoad();
            onLoadEvent(t);
        }
    }

    @Override
    public void fail(@NonNull String error, @NonNull Throwable e) {
        this.autoFinishRefreshAndLoad(state, callBack);
        onFailEvent(error, e);
    }

    @Override
    public void onSuccessEvent(@NonNull T t) {

    }

    @Override
    public void onFinishEvent() {

    }
}