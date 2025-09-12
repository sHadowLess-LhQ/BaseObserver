package cn.com.shadowless.baseobserver.base;

import android.util.Log;


import cn.com.shadowless.baseobserver.BaseAbstract;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 基础Completable观察者抽象类
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
        fail(Log.getStackTraceString(e), e);
    }

    @Override
    public void onComplete() {
        finish();
    }
}