package cn.com.shadowless.baseobserver.loadingObserver;

import cn.com.shadowless.baseobserver.base.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.event.EventCallBack;
import cn.com.shadowless.baseobserver.event.ObserveEventSpecification;
import io.reactivex.rxjava3.annotations.NonNull;


/**
 * 基础加载Completable观察者抽象类
 *
 * @author sHadowLess
 */
public abstract class BaseLoadingCompletableObserver extends BaseCompletableObserver implements ObserveEventSpecification<Object> {

    /**
     * 构造函数
     *
     * @param callBack 加载
     */
    public BaseLoadingCompletableObserver(@NonNull EventCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void start() {
        callBack.show();
        loadingTime = callBack.getAnimationDuration() + 200;
        onStartEvent();
    }

    @Override
    public void fail(@NonNull String error, @NonNull Throwable e) {
        callBack.dismiss();
        handler.postDelayed(() -> onFailEvent(error, e), loadingTime);
    }

    @Override
    public void finish() {
        callBack.dismiss();
        handler.postDelayed(this::onFinishEvent, loadingTime);
    }

    @Override
    public void onRefreshEvent(@NonNull Object o) {

    }

    @Override
    public void onLoadEvent(@NonNull Object o) {

    }

    @Override
    public void onSuccessEvent(@NonNull Object o) {

    }
}