package cn.com.shadowless.baseobserver.loadingObserver;

import cn.com.shadowless.baseobserver.base.BaseSingleObserver;
import cn.com.shadowless.baseobserver.event.EventCallBack;
import cn.com.shadowless.baseobserver.event.ObserveEventSpecification;
import io.reactivex.rxjava3.annotations.NonNull;


/**
 * 基础加载Single观察者抽象类
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseLoadingSingleObserver<T> extends BaseSingleObserver<T> implements ObserveEventSpecification<T> {

    /**
     * 构造函数
     *
     * @param callBack 加载
     */
    public BaseLoadingSingleObserver(@NonNull EventCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void start() {
        callBack.show();
        loadingTime = callBack.getAnimationDuration() + 200;
        onStartEvent();
    }

    @Override
    public void success(@NonNull T t) {
        callBack.dismiss();
        handler.postDelayed(() -> onSuccessEvent(t), loadingTime);
    }

    @Override
    public void fail(@NonNull String error, @NonNull Throwable e) {
        callBack.dismiss();
        handler.postDelayed(() -> onFailEvent(error, e), loadingTime);
    }

    @Override
    public void onRefreshEvent(@NonNull T t) {

    }

    @Override
    public void onLoadEvent(@NonNull T t) {

    }

    @Override
    public void onFinishEvent() {

    }
}