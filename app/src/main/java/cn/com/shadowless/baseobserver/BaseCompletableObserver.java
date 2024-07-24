package cn.com.shadowless.baseobserver;

import android.util.Log;


import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * The type Base observer.
 *
 * @author sHadowLess
 */
public abstract class BaseCompletableObserver extends BaseAbstract<Object> implements CompletableObserver {

    @Override
    public void onSubscribe(Disposable d) {
        start();
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
