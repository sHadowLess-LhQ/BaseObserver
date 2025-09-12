package cn.com.shadowless.baseobserver.base;

import android.util.Log;

import cn.com.shadowless.baseobserver.BaseAbstract;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 基础Single观察者抽象类
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseSingleObserver<T> extends BaseAbstract<T> implements SingleObserver<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        start();
    }

    @Override
    public void onSuccess(@NonNull T t) {
        success(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        fail(Log.getStackTraceString(e), e);
    }
}