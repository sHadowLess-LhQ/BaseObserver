package cn.com.shadowless.baseobserver.loadingObserver;

import android.app.Activity;

import androidx.annotation.NonNull;

import cn.com.shadowless.baseobserver.base.BaseCompletableObserver;
import cn.com.shadowless.baseobserver.LoadingConfig;
import cn.com.shadowless.baseobserver.ObserveEventSpecification;


/**
 * 基础加载Completable观察者抽象类
 *
 * @author sHadowLess
 */
public abstract class BaseLoadingCompletableObserver extends BaseCompletableObserver implements ObserveEventSpecification<Object> {

    /**
     * 构造函数
     *
     * @param activity Activity上下文
     * @param config   加载配置
     */
    public BaseLoadingCompletableObserver(@NonNull Activity activity, @NonNull LoadingConfig config) {
        loadingPopupView = this.getLoadingPopView(activity, config);
    }

    @Override
    public void start() {
        loadingPopupView.show();
        loadingTime = loadingPopupView.getAnimationDuration() + 200;
        onStartEvent();
    }

    @Override
    public void fail(String error, Throwable e) {
        loadingPopupView.delayDismissWith(loadingTime, () -> onFailEvent(error, e));
    }

    @Override
    public void finish() {
        loadingPopupView.delayDismissWith(loadingTime, this::onFinishEvent);
    }

    @Override
    public void onRefreshEvent(Object o) {

    }

    @Override
    public void onLoadEvent(Object o) {

    }

    @Override
    public void onSuccessEvent(Object o) {

    }
}