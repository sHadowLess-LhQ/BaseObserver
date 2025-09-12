package cn.com.shadowless.baseobserver.base;

import android.util.Log;

import org.reactivestreams.Subscription;

import cn.com.shadowless.baseobserver.BaseAbstract;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;

/**
 * 基础Flowable订阅者抽象类
 *
 * @param <T> 泛型参数
 */
public abstract class BaseFlowable<T> extends BaseAbstract<T> implements FlowableSubscriber<T> {

    @Override
    public void onSubscribe(@NonNull Subscription s) {
        start();
    }

    @Override
    public void onNext(T t) {
        success(t);
    }

    @Override
    public void onError(Throwable e) {
        fail(Log.getStackTraceString(e), e);
    }

    @Override
    public void onComplete() {
        finish();
    }
}