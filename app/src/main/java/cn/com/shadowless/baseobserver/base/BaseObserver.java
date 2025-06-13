package cn.com.shadowless.baseobserver.base;


import android.util.Log;

import cn.com.shadowless.baseobserver.BaseAbstract;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseObserver<T> extends BaseAbstract<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
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
