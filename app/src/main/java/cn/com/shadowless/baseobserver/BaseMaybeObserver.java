package cn.com.shadowless.baseobserver;


import android.app.Activity;
import android.util.Log;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
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
        fail(Log.getStackTraceString(e));
    }

    @Override
    public void onComplete() {
        finish();
    }
}
