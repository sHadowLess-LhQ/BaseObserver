package cn.com.shadowless.baseobserver.freshObserber;


import cn.com.shadowless.baseobserver.base.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.event.EventCallBack;
import cn.com.shadowless.baseobserver.event.ObserveEventSpecification;
import io.reactivex.rxjava3.annotations.NonNull;


/**
 * 基础刷新Completable观察者抽象类
 *
 * @author sHadowLess
 */
public abstract class BaseFreshCompletableObserver extends BaseCompletableObserver implements ObserveEventSpecification<Object> {

    /**
     * 刷新状态
     */
    private final int state;

    /**
     * 构造函数
     *
     * @param callBack 刷新布局
     */
    public BaseFreshCompletableObserver(@NonNull EventCallBack callBack) {
        this.callBack = callBack;
        this.state = callBack.getState();
    }

    @Override
    public void start() {
        onStartEvent();
    }

    @Override
    public void fail(@NonNull String error,@NonNull Throwable e) {
        onFailEvent(error, e);
        this.autoFinishRefreshAndLoad(state, callBack);
    }

    @Override
    public void finish() {
        onFinishEvent();
        this.autoFinishRefreshAndLoad(state, callBack);
    }

    @Override
    public void onSuccessEvent(@NonNull Object o) {

    }

    @Override
    public void onRefreshEvent(@NonNull Object o) {

    }

    @Override
    public void onLoadEvent(@NonNull Object o) {

    }
}