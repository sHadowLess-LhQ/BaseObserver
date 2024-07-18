package cn.com.shadowless.baseobserver;


import android.util.Log;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * The type Base observer.
 *
 * @param <T> the type parameter
 * @author sHadowLess
 */
public abstract class BaseSubscriber<T> extends BaseAbstract<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {
        start();
    }

    @Override
    public void onNext(T t) {
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
