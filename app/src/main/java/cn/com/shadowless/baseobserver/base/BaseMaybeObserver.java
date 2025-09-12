package cn.com.shadowless.baseobserver.base;

import android.util.Log;

import cn.com.shadowless.baseobserver.BaseAbstract;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 基础Maybe观察者抽象类
 *
 * @param <T> 泛型参数
 * @author sHadowLess
 */
public abstract class BaseMaybeObserver<T> extends BaseAbstract<T> implements MaybeObserver<T> {

    @Override
    public void onSubscribe(Disposable d) {
        start();
    }

    @Override
    public void onSuccess(@NonNull T t) {
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