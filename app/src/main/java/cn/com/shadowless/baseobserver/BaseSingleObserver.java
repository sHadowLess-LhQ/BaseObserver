package cn.com.shadowless.baseobserver;

import android.util.Log;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
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
        fail(Log.getStackTraceString(e));
    }
}
